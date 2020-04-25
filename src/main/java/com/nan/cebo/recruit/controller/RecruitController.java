package com.nan.cebo.recruit.controller;

import com.nan.cebo.apis.recruit.v1.RecruitControllerApi;
import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.common.response.enums.AppHttpCodeEnum;
import com.nan.cebo.recruit.domain.vos.HotCompetitionVO;
import com.nan.cebo.recruit.service.RecruitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

  @Override
  @RequestMapping(value = "/hotcompetitions",method = RequestMethod.GET)
  public ResponseResult loadHotCompetition() {
    List<HotCompetitionVO> hCompVOs=recruitService.getHotCompetition();
    return ResponseResult.okResult(hCompVOs);
  }

  @Override
  @RequestMapping("/{page}")
  public ResponseResult loadRecruitDetail(@PathVariable(value = "page",required = false) Integer page) {
    if (page==null){
      return ResponseResult.okResult(recruitService.getRecruitBasicAll());
    }
    else if (page >0){
      return ResponseResult.okResult(recruitService.getRecruitBasic(page));
    }
    else {
      return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"页码错误");
    }
  }



}
