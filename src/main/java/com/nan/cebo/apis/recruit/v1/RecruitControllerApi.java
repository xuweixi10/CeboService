package com.nan.cebo.apis.recruit.v1;

import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.recruit.domain.pojos.RecruitInfo;

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

  /**
   * @description 删除一条招募消息，要求在请求头携带用户名密码
   * @param recruitId 待删除的招募信息ID
   * @method GET
   * @return 成功与否
   */
  public ResponseResult deleteRecruitInfoById(String recruitId,String username,String password);


  /**
   * POST 添加用户的招募信息
   * @param recruitInfo 招募信息
   * @return 是否插入成功。
   */
  ResponseResult addRecruitInfo(RecruitInfo recruitInfo);

  /**
   * GET
   * 获取用户所有的招募信息
   * @param userId 用户id
   * @return list
   */
  ResponseResult getUserRecruits(String userId);

  /**
   * 获取招募详情
   * @param postId 招募id
   * @return 招募详情
   */
  ResponseResult getRecruitDetails(String postId);

  /**
   * 删除RecruitDetails
   * @param id 帖子id
   * @return
   */
  ResponseResult deleteRecruitInfo(String id,String userId);

}
