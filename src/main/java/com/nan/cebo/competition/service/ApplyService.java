package com.nan.cebo.competition.service;

import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyFormData;
import com.nan.cebo.competition.domain.apply.submit.SubmitData;

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
}
