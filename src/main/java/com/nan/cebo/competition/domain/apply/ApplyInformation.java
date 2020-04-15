package com.nan.cebo.competition.domain.apply;

import java.util.ArrayList;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 11:03
 */
public class ApplyInformation {
    private final String competitionId;
    private final int minPeople;
    private final int maxPeople;
    private ArrayList<ApplyType> captainInformation=new ArrayList<ApplyType>();
    private ArrayList<ApplyType> personInformation=new ArrayList<ApplyType>();
    public ApplyInformation(String competitionId,
                            final int minPeople,
                            final int maxPeople){
        this.competitionId=competitionId;
        this.maxPeople=maxPeople;
        this.minPeople=minPeople;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public int getMinPeople() {
        return minPeople;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public ArrayList<ApplyType> getCaptainInformation() {
        return captainInformation;
    }

    public void setCaptainInformation(ArrayList<ApplyType> captainInformation) {
        this.captainInformation = captainInformation;
    }

    public ArrayList<ApplyType> getPersonInformation() {
        return personInformation;
    }

    public void setPersonInformation(ArrayList<ApplyType> personInformation) {
        this.personInformation = personInformation;
    }
}
