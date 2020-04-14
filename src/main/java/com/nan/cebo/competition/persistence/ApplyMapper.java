package com.nan.cebo.competition.persistence;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 23:37
 */
public interface ApplyMapper {
    /**
     *  like {1,2,3,4}
     * @param competitionId 比赛id
     * @return 比赛报名所有信息的id
     */
    String getInformation(String competitionId);
}
