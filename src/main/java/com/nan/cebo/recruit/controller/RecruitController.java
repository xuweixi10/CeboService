package com.nan.cebo.recruit.controller;

import com.nan.cebo.apis.recruit.v1.RecruitControllerApi;
import com.nan.cebo.common.config.EncodeConfig;
import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.common.response.enums.AppHttpCodeEnum;
import com.nan.cebo.recruit.domain.pojos.RecruitInfo;
import com.nan.cebo.recruit.domain.vos.HotCompetitionVO;
import com.nan.cebo.recruit.domain.vos.RecruitBasicVO;
import com.nan.cebo.recruit.service.RecruitService;

import java.util.ArrayList;
import java.util.List;

import com.nan.cebo.signup.domain.Account;
import com.nan.cebo.signup.service.AccountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

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
  private AccountService accountService;

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

  @RequestMapping( value = "/getHotRecruit",method = RequestMethod.GET)
  public ResponseResult getHotCompetition(@RequestParam("name") @NotNull String name) {
    ArrayList<RecruitInfo> datas=recruitService.getHotCompetitions(name);
    if(null!=datas){
      return ResponseResult.okResult(datas);
    }
    return ResponseResult.errorResult(500,"no data find");
  }

  @Override
  @RequestMapping( value = "/addRecruit",method = RequestMethod.POST)
  public ResponseResult addRecruitInfo(@RequestBody RecruitInfo recruitInfo) {
    boolean res=recruitService.addRecruitById(recruitInfo);
    if(res){
      return ResponseResult.okResult(true);
    }
    return ResponseResult.errorResult(1000,"data is exist");
  }

  @Override
  @RequestMapping( value = "/myRecruit",method = RequestMethod.GET)
  public ResponseResult getUserRecruits(@RequestParam("userId") String userId) {
    ArrayList<RecruitBasicVO> list=recruitService.getUserRecruitBasic(userId);
    if(null!=list){
      return ResponseResult.okResult(list);
    }
    return ResponseResult.errorResult(1001,"invalid account");
  }

  @Override
  @RequestMapping( value = "/recruitDetails",method = RequestMethod.GET)
  public ResponseResult getRecruitDetails(@RequestParam("postId") String postId) {

    return ResponseResult.okResult(recruitService.getRecruitDetails(postId));
  }

  @Override
  @RequestMapping( value = "/deleteRecruit",method = RequestMethod.GET)
  public ResponseResult deleteRecruitInfo(@RequestParam("id") String id,@RequestParam("userId") String userId) {
    Account account=accountService.getAccountInformation(userId);
    if (account!=null){
      boolean res=recruitService.removeRecruitById(id);
      if(res){
        return ResponseResult.okResult(true);
      }
      return ResponseResult.okResult(false);
    }
    return ResponseResult.errorResult(1001,"invalid account");
  }
}
