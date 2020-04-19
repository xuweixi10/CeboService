package com.nan.cebo.competition.domain.apply;

/**
 * 储存在数据库中的数据
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/14 15:39
 */
public class ApplyDataBase {
    private String competitionId;
    private int minPeople;
    private int maxPeople;
    private String capapplyType;
    private String capapplyInformationId;
    private String perapplyType;
    private String perapplyInformationId;
    private String comapplyType;
    private String comapplyInformationId;

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

    public String getCapapplyType() {
        return capapplyType;
    }

    public void setCapapplyType(String capapplyType) {
        this.capapplyType = capapplyType;
    }

    public String getCapapplyInformationId() {
        return capapplyInformationId;
    }

    public void setCapapplyInformationId(String capapplyInformationId) {
        this.capapplyInformationId = capapplyInformationId;
    }

    public String getPerapplyType() {
        return perapplyType;
    }

    public void setPerapplyType(String perapplyType) {
        this.perapplyType = perapplyType;
    }

    public String getPerapplyInformationId() {
        return perapplyInformationId;
    }

    public void setPerapplyInformationId(String perapplyInformationId) {
        this.perapplyInformationId = perapplyInformationId;
    }

    public String getComapplyType() {
        return comapplyType;
    }

    public void setComapplyType(String comapplyType) {
        this.comapplyType = comapplyType;
    }

    public String getComapplyInformationId() {
        return comapplyInformationId;
    }

    public void setComapplyInformationId(String comapplyInformationId) {
        this.comapplyInformationId = comapplyInformationId;
    }
}
