package com.nan.cebo.apis.competition.v1;

import com.nan.cebo.common.response.dtos.ResponseResult;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 15:01
 */
public interface CompetitionControllerApi {

  /**
   * @Description 返回首页图片url列表
   * @return 图片url列表
   */
  public ResponseResult loadIndexImage();


  /**
   * @Description 返回竞赛基本信息
   * @param page 页数，用于分页查看（默认每页10条），若参数为空则全部返回（甚重)
   * @return 竞赛基本信息列表
   */
  public ResponseResult loadCompBasic(Integer page);
}
