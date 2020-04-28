package com.nan.cebo.recruit.persistence;

import com.nan.cebo.recruit.domain.pojos.RecruitInfo;

import java.util.ArrayList;
import java.util.List;

import com.nan.cebo.recruit.domain.vos.RecruitBasicVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 12:42
 */
@Mapper
public interface RecruitMapper {

  List<RecruitInfo> getRecruitAll();

  List<RecruitInfo> getRecruit(int startIndex);

  boolean deleteRecruitInfoById(String recruitId);

  /**
   * 插入recruitInfo
   * @param recruitInfo 招募信息
   * @return 是否插入成功
   */
  boolean insertRecruitInfo(RecruitInfo recruitInfo);

  /**
   * 获取所有用户招募贴
   * @param postId userId
   * @return list
   */
  ArrayList<RecruitInfo> getUserAllRecruit(String postId);

  /**
   * 获取招募贴细节
   * @param id 招募贴id
   * @return 返回所有招募贴
   */
  RecruitInfo getRecruitDetails(String id);

}
