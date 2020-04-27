package com.nan.cebo.recruit.service;

import com.nan.cebo.recruit.domain.pojos.RecruitInfo;
import com.nan.cebo.recruit.domain.vos.HotCompetitionVO;
import com.nan.cebo.recruit.domain.vos.RecruitBasicVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 12:39
 * @Change 2020/4/27 xuxiaoxi10
 */
public interface RecruitService {


  List<HotCompetitionVO> getHotCompetition();

  List<RecruitBasicVO> getRecruitBasicAll();

  List<RecruitBasicVO> getRecruitBasic(Integer page);

  boolean removeRecruitById(String recruitId);

  /**
   * 添加recruitInfo
   * @param recruitInfo 招募信息
   * @return 是否招募成功
   */
  boolean addRecruitById(RecruitInfo recruitInfo);

  /**
   * 获取用户的所有招募贴
   * @param userId 用户id
   * @return List
   */
  ArrayList<RecruitBasicVO> getUserRecruitBasic(String userId);

  /**
   * 获取招募详情
   * @param postId 帖子id
   * @return 帖子详情
   */
  RecruitInfo getRecruitDetails(String postId);
}
