package com.nan.cebo.apis.competition.v1;

import com.nan.cebo.common.response.dtos.ResponseResult;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 15:01
 */
public interface CompetitionControllerApi {

  /**
   * @description 返回首页图片url列表
   * @method GET
   * @return 图片url列表
   */
  public ResponseResult loadIndexImage();


  /**
   * @description 返回竞赛基本信息
   * @method GET
   * @param page 页数，用于分页查看（默认每页6条），若参数为空则全部返回（甚重)
   * @return 竞赛基本信息列表
   */
  public ResponseResult loadCompBasic(Integer page);

  /**
   * @description 返回某个竞赛的基本信息，包括比赛章程
   * @method GET
   * @param compId 竞赛Id
   * @return 竞赛详细信息列表
   */
  public ResponseResult loadCompBasic(String compId);

  /**
   * @description 返回某个竞赛的详细信息，包括比赛章程
   * @method GET
   * @param compId 竞赛Id
   * @return 竞赛详细信息列表
   */
  public ResponseResult loadCompDetail(String compId);

  public ResponseResult addCollection(String openId,String competitionId);

  public ResponseResult deleteCollection(String openId, String competitionId);

  public ResponseResult getCollections(String openId);

  public ResponseResult checkData(String openId,String competitionId);
}
