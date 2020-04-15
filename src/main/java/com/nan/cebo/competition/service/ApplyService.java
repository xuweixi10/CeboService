package com.nan.cebo.competition.service;

import com.nan.cebo.competition.domain.apply.ApplyFormData;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 23:43
 */
public interface ApplyService {
    ApplyFormData getFormData(String competitionId);
}
