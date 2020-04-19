package com.nan.cebo.competition.domain.apply.view;

/**
 * 队伍和比赛关联信息表
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/19 18:08
 */
public class TeamCompetition {
    private String teamId;
    private String userId;
    private String competitionId;
    public TeamCompetition(){

    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
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
}
