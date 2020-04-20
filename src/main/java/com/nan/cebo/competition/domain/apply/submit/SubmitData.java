package com.nan.cebo.competition.domain.apply.submit;

import java.util.ArrayList;

/**
 * 提交数据对象化
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/18 23:23
 */
public class SubmitData {
    private String userId;
    private String competitionId;
    private ArrayList<TeamData> capData=new ArrayList<>();
    private ArrayList<TeamData> competitionData=new ArrayList<>();
    private ArrayList<ArrayList<TeamData>> personData=new ArrayList<>();

    public SubmitData(){

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public ArrayList<TeamData> getCapData() {
        return capData;
    }

    public void setCapData(ArrayList<TeamData> capData) {
        this.capData = capData;
    }

    public ArrayList<TeamData> getCompetitionData() {
        return competitionData;
    }

    public void setCompetitionData(ArrayList<TeamData> competitionData) {
        this.competitionData = competitionData;
    }

    public ArrayList<ArrayList<TeamData>> getPersonData() {
        return personData;
    }

    public void setPersonData(ArrayList<ArrayList<TeamData>> personData) {
        this.personData = personData;
    }
}
