package com.nan.cebo.competition.service.Impl;

import com.nan.cebo.competition.persistence.ApplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 23:41
 */
@Service
public class ApplyService {
    @Autowired
    ApplyMapper applyMapper;

    public String getApplyInformationId(String competitionId){
        return applyMapper.getInformation(competitionId);
    }
}
