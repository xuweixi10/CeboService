package com.nan.cebo.apis.recruit.v1;

import com.nan.cebo.common.response.dtos.ResponseResult;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 10:21
 */
public interface RecruitControllerApi {
  /**
   * @description 返回热门比赛
   * @method GET
   * @return 比赛列表
   */
  public ResponseResult loadHotCompetition();

  /**
   * @description 分页返回招募的
   * @param page 分页页数，默认6条
   * @method GET
   * @return 比赛列表
   */
  public ResponseResult loadRecruitDetail(Integer page);

}
