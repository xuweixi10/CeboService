package com.nan.cebo.competition.service.Impl;

import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyFormData;
import com.nan.cebo.competition.domain.apply.ApplyType;
import com.nan.cebo.competition.domain.apply.DataBaseTableName;
import com.nan.cebo.competition.persistence.ApplyMapper;
import com.nan.cebo.utils.competition.apply.MixAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 23:41
 */
@Service
public class ApplyService {
    @Autowired
    private ApplyMapper applyMapper;
    private static final Logger log=LoggerFactory.getLogger("APPLY");

    public ApplyDataBase getDataBase(String competitionId){
        return applyMapper.getInformation(competitionId);
    }
    public ApplyFormData dataBaseToFormData(ApplyDataBase applyDataBase){
        ApplyFormData applyFormData=new ApplyFormData();
        applyFormData.setCompetitionId(applyDataBase.getCompetitionId());
        applyFormData.setMinPeople(applyDataBase.getMinPeople());
        ArrayList<ApplyType> capApplyType=getInformation(
                MixAll.StringToByteArray(applyDataBase.getCapapplyType()),
                MixAll.StringToArray(applyDataBase.getCapapplyInformationId()));
        ArrayList<ApplyType> perApplyType=getInformation(
                MixAll.StringToByteArray(applyDataBase.getPerapplyType()),
                MixAll.StringToArray(applyDataBase.getPerapplyInformationId()));
        applyFormData.setCapApplyType(capApplyType);
        applyFormData.setPerApplyType(perApplyType);
        return applyFormData;
    }


    /**
     * 获取具体字段的信息
     * @param types
     * @param applyId
     * @return
     */
    public ArrayList<ApplyType> getInformation(byte[] types,String[] applyId){
        ArrayList<ApplyType> applyTypes=new ArrayList<ApplyType>();
        for(int i=0;i<types.length;i++){
            DataBaseTableName dataBaseTableName=DataBaseTableName.valueof(types[i]);
            if(dataBaseTableName!=null){
                String tableName=dataBaseTableName.getTableName();
                ApplyType applyType=applyMapper.getApplyDetails(types[i],tableName,applyId[i]);
                if(applyType!=null){
                    applyTypes.add(applyType);
                }
                else {
                    log.warn("No data in table: {},id: {}",tableName,applyId[i]);
                }
            }
            else {
                log.warn("No type for the tag");
            }
        }
        return applyTypes;
    }
}
