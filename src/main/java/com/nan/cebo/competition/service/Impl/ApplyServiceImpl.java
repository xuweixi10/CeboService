package com.nan.cebo.competition.service.Impl;

import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyFormData;
import com.nan.cebo.competition.domain.apply.ApplyType;
import com.nan.cebo.competition.domain.apply.DataBaseTableName;
import com.nan.cebo.competition.domain.apply.submit.PersonDataBase;
import com.nan.cebo.competition.domain.apply.submit.SubmitData;
import com.nan.cebo.competition.domain.apply.submit.TeamData;
import com.nan.cebo.competition.domain.apply.view.TeamCompetition;
import com.nan.cebo.competition.domain.apply.view.ViewPerson;
import com.nan.cebo.competition.persistence.ApplyMapper;
import com.nan.cebo.competition.service.ApplyService;
import com.nan.cebo.signup.domain.ApplyCompetition;
import com.nan.cebo.utils.competition.apply.MixAll;
import com.nan.cebo.utils.competition.apply.TeamIdGenerate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 23:41
 */
@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
    private static final Logger log=LoggerFactory.getLogger("APPLY");

    @Override
    public ApplyDataBase getDataBase(String competitionId){
        return applyMapper.getInformation(competitionId);
    }
    @Override
    public ApplyFormData dataBaseToFormData(ApplyDataBase applyDataBase) {
        ApplyFormData applyFormData = new ApplyFormData();
        applyFormData.setCompetitionId(applyDataBase.getCompetitionId());
        applyFormData.setMinPeople(applyDataBase.getMinPeople());
        ArrayList<ApplyType> capApplyType = getInformation(
                MixAll.StringToByteArray(applyDataBase.getCapapplyType()),
                MixAll.StringToArray(applyDataBase.getCapapplyInformationId()));
        ArrayList<ApplyType> perApplyType = getInformation(
                MixAll.StringToByteArray(applyDataBase.getPerapplyType()),
                MixAll.StringToArray(applyDataBase.getPerapplyInformationId()));
        ArrayList<ApplyType> comApplyType = getInformation(
                MixAll.StringToByteArray(applyDataBase.getComapplyType()),
                MixAll.StringToArray(applyDataBase.getComapplyInformationId()));
        applyFormData.setCapApplyType(capApplyType);
        applyFormData.setPerApplyType(perApplyType);
        applyFormData.setComApplyType(comApplyType);
        return applyFormData;
    }


    /**
     * 获取具体字段的信息
     * @param types
     * @param applyId
     * @return
     */
    private ArrayList<ApplyType> getInformation(byte[] types,String[] applyId) {
        ArrayList<Integer> array = new ArrayList<>();
        ArrayList<ApplyType> applyTypes = new ArrayList<ApplyType>();
        for (int i = 0; i < types.length; i++) {
            DataBaseTableName dataBaseTableName = DataBaseTableName.valueof(types[i]);
            if (dataBaseTableName != null) {
                String tableName = dataBaseTableName.getTableName();
                ApplyType applyType = applyMapper.getApplyDetails(types[i], tableName, applyId[i]);
                if (applyType != null) {
                    applyTypes.add(applyType);
                } else {
                    log.warn("No data in table: {},id: {}", tableName, applyId[i]);
                }
            } else {
                log.warn("No type for the tag");
            }
        }
        return applyTypes;
    }

    @Override
    public String insertTeamData(SubmitData data) {
        String teamId = TeamIdGenerate.generateId();
        boolean result = insertTeamCompetition(teamId, data.getUserId(), data.getCompetitionId());
        if (result) {
            try {
                ArrayList<TeamData> capData = data.getCapData();
                insertTeamData(capData, teamId, "capapplyinformation");
                ArrayList<ArrayList<TeamData>> perData=data.getPersonData();
                int i=0;
                for(ArrayList<TeamData> singleData:perData){
                    insertTeamData(singleData,teamId,"perapplyinformation",i);
                    i++;
                }
                ArrayList<TeamData> comData=data.getCompetitionData();
                insertTeamData(comData,teamId,"comapplyinformation");
                return teamId;
            } catch (Exception e) {
                log.warn("insert applyData error", e);
            }
        }
        return null;

    }
    @Override
    public ArrayList<ApplyCompetition> getUserCompetitions(String userId){
        ArrayList<ApplyCompetition> competitions=applyMapper.getUserAllCompetition(userId);
        for(ApplyCompetition applyCompetition:competitions){
            String name=applyMapper.getCompetitionName(applyCompetition.getCompetitionId());
            applyCompetition.setCompetitionName(name);
        }
        return competitions;
    }
    @Override
    public SubmitData getApplyDetails(String teamId) {
        SubmitData submitData=new SubmitData();
        try {
            ArrayList<TeamData> competitionApply=applyMapper.getCompetitionInfor(teamId,"comapplyinformation");
            ArrayList<TeamData> captainApply=applyMapper.getCompetitionInfor(teamId,"capapplyinformation");
            ArrayList<ViewPerson> personApply=applyMapper.getPersonInfor(teamId);
            ArrayList<ArrayList<TeamData>> perApplyData=viewPersonToTeamData(personApply);
            submitData.setCapData(captainApply);
            submitData.setCompetitionData(competitionApply);
            submitData.setPersonData(perApplyData);
        }catch (Exception e){
            log.error("error when get applyInformationDetails",e);
        }
        return submitData;
    }

    /**
     * 插入比赛用户关系表
     * @param teamId 队伍id
     * @param userId 用户id
     * @param competitionId 比赛id
     * @return 是否插入成功
     */
    private boolean insertTeamCompetition(String teamId,String userId,String competitionId) {
        applyMapper.insertTeamId(teamId, userId, competitionId);
        TeamCompetition res = applyMapper.getCompetitionId(teamId);
        if (res != null) {
            return true;
        }
        return false;
    }

    /**
     * 插入一组数据
     * @param data 一组数据
     * @param tableName 对应的表名
     */
    private void insertTeamData(ArrayList<TeamData> data,String teamId,String tableName){
        for(TeamData teamData:data){
            insertTeamData(teamData,teamId,tableName);
        }
    }
    /**
     * 插入一组数据（队员信息）
     * @param data 一组数据
     * @param tableName 对应的表名
     */
    private void insertTeamData(ArrayList<TeamData> data,String teamId,String tableName,int index){
        for(TeamData teamData:data){
            insertTeamData(teamData,teamId,tableName,index);
        }
    }

    /**
     * 插入数据
     * @param data 一个数据
     * @param tableName 表名
     */
    private void insertTeamData(TeamData data,String teamId,String tableName){
        PersonDataBase personDataBase=MixAll.teamDataToBase(data, teamId,tableName);
        applyMapper.insertTeamData(personDataBase,tableName);
    }
    /**
     * 插入队员数据
     * @param data 一个数据
     * @param tableName 表名
     */
    private void insertTeamData(TeamData data,String teamId,String tableName,int index){
        PersonDataBase personDataBase=MixAll.teamDataToBase(data, teamId,tableName);
        applyMapper.insertPeronData(personDataBase,tableName,index);
    }

    private ArrayList<ArrayList<TeamData>> viewPersonToTeamData(ArrayList<ViewPerson> persons){
        ArrayList<ArrayList<TeamData>> personData=new ArrayList<>();
        persons.sort(new Comparator<ViewPerson>() {
            @Override
            public int compare(ViewPerson o1, ViewPerson o2) {
                if(o1==null||o2==null){
                    return 0;
                }else {
                    return o1.getPersonId().compareTo(o2.getPersonId());
                }
            }
        });
        for(ViewPerson person:persons){
            int index=Integer.parseInt(person.getPersonId());
            if (personData.size() < index + 1) {
                ArrayList<TeamData> data=new ArrayList<>();
                personData.add(data);
            }
            TeamData data=new TeamData();
            data.setName(person.getName());
            data.setValue(person.getValue());
            personData.get(index).add(data);
        }
        return personData;
    }

}
