package com.nan.cebo.competition.domain.apply;

import java.util.ArrayList;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 16:03
 */
public class ApplyFormData {
    private String competitionId;
    private int minPeople;
    private int maxPeople;
    private ArrayList<ApplyType> capApplyType=new ArrayList<ApplyType>();
    private ArrayList<ApplyType> perApplyType=new ArrayList<ApplyType>();

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public int getMinPeople() {
        return minPeople;
    }

    public void setMinPeople(int minPeople) {
        this.minPeople = minPeople;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public ArrayList<ApplyType> getCapApplyType() {
        return capApplyType;
    }

    public void setCapApplyType(ArrayList<ApplyType> capApplyType) {
        this.capApplyType = capApplyType;
    }

    public ArrayList<ApplyType> getPerApplyType() {
        return perApplyType;
    }

    public void setPerApplyType(ArrayList<ApplyType> perApplyType) {
        this.perApplyType = perApplyType;
    }
}
