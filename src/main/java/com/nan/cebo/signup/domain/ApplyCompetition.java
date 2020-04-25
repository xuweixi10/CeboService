package com.nan.cebo.signup.domain;

/**
 * 最基本的比赛信息
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/24 14:56
 */
public class ApplyCompetition {
    private String teamId;
    private String competitionId;
    private String competitionName;
    public ApplyCompetition(){

    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(String competitionId) {
        this.competitionId = competitionId;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }
}
