package com.nan.cebo.recruit.controller;

import com.nan.cebo.apis.recruit.v1.RecruitControllerApi;
import com.nan.cebo.common.config.EncodeConfig;
import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.common.response.enums.AppHttpCodeEnum;
import com.nan.cebo.recruit.domain.vos.HotCompetitionVO;
import com.nan.cebo.recruit.service.RecruitService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 12:35
 */
@CrossOrigin
@RestController
@RequestMapping("/api/recruit/v1")
public class RecruitController implements RecruitControllerApi {

  @Autowired
  private RecruitService recruitService;

  @Autowired
  private EncodeConfig config;

  @Override
  @RequestMapping(value = "/hotcompetitions", method = RequestMethod.GET)
  public ResponseResult loadHotCompetition() {
    List<HotCompetitionVO> hCompVOs = recruitService.getHotCompetition();
    return ResponseResult.okResult(hCompVOs);
  }

  @Override
  @RequestMapping("/{page}")
  public ResponseResult loadRecruitDetail(
      @PathVariable(value = "page", required = false) Integer page) {
    if (page == null) {
      return ResponseResult.okResult(recruitService.getRecruitBasicAll());
    }
    else if (page > 0) {
      return ResponseResult.okResult(recruitService.getRecruitBasic(page));
    }
    else {
      return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "页码错误");
    }
  }

  @Override
  @RequestMapping("/removeit")
  public ResponseResult deleteRecruitInfoById(@RequestParam("recruitId") String recruitId,
      @RequestHeader("identity") String username, @RequestHeader("authority") String password) {
    if (!(username.matches(config.getUsername())&&password.matches(config.getPassword()))){
      return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR,"身份验证失败");
    }
    else if (recruitId==null|| recruitId.isEmpty() || !StringUtils.isNumeric(recruitId)){
      return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"id不合法");
    }
    else if (recruitService.removeRecruitById(recruitId)){
      return ResponseResult.okResult(AppHttpCodeEnum.SUCCESS.getCode(),"删除成功");
    }
    else {
      return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
    }

  }

}
