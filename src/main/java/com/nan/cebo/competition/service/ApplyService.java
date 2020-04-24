package com.nan.cebo.competition.service;

import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyFormData;
import com.nan.cebo.competition.domain.apply.submit.SubmitData;
import com.nan.cebo.signup.domain.ApplyCompetition;

import java.util.ArrayList;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 23:43
 */
public interface ApplyService {

    /**
     * 获取数据库报名的数据
     * @param competitionId 比赛id
     * @return ApplyDataBase
     */
    ApplyDataBase getDataBase(String competitionId);

    /**
     * 数据库数据转换成表单数据
     * @param applyDataBase 数据库读出来的数据
     * @return 表单数据
     */
    ApplyFormData dataBaseToFormData(ApplyDataBase applyDataBase);

    /**
     * 插入队伍数据
     * @param data 队伍数据
     * @return 队伍id
     */
    String insertTeamData(SubmitData data);

    /**
     * 获取用户所有参加的比赛
     * @param userId 用户id
     * @return 所有参加的比赛
     */
    ArrayList<ApplyCompetition> getUserCompetitions(String userId);

    /**
     * 获取摸个比赛id的详细信息
     * @param teamId 比赛id
     * @return 原来提交的数据
     */
    SubmitData getApplyDetails(String teamId);

}
