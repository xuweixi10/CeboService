package com.nan.cebo.competition.persistence;

import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyType;
import com.nan.cebo.competition.domain.apply.submit.PersonDataBase;
import com.nan.cebo.competition.domain.apply.view.TeamCompetition;
import com.nan.cebo.competition.persistence.annotation.InterceptMethod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 23:37
 */
@Mapper
public interface ApplyMapper {
    /**
     *  like {1,2,3,4}
     * @param competitionId 比赛id
     * @return 比赛报名所有信息的id
     */
    ApplyDataBase getInformation(String competitionId);

    /**
     * 获取指定表的细节
     * @param type 类型
     * @param tableName 表名
     * @param id 类型id
     * @return ApplyType 父类型
     */
    @InterceptMethod
    ApplyType getApplyDetails(byte type,String tableName,String id);

    /**
     * 插入队伍关联信息
     * @param teamId 队伍id
     * @param userId 用户id
     * @param competitionId 比赛id
     */
    void insertTeamId(String teamId,String userId,String competitionId);

    /**
     * 根据队伍id获取比赛信息
     * @param teamId 队伍id
     * @return 比赛和队伍关联数据
     */
    TeamCompetition getCompetitionId(String teamId);

    /**
     * 插入队伍信息
     * @param data 数据
     */
    void insertTeamData(@Param("data") PersonDataBase data,@Param("tableName")String tableName);
    /**
     *
     */
    void insertPeronData(@Param("data") PersonDataBase data, @Param("tableName")String tableName,@Param("index") int index);
}
