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

  /**
   * @description 删除一条招募消息，要求在请求头携带用户名密码
   * @param recruitId 待删除的招募信息ID
   * @method GET
   * @return 成功与否
   */
  public ResponseResult deleteRecruitInfoById(String recruitId,String username,String password);

}
