package com.nan.cebo.competition.controller;

import com.nan.cebo.apis.competition.v1.CompetitionControllerApi;
import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.competition.service.CompetitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 15:38
 */
@RestController
@RequestMapping("/api/competition/v1")
public class CompetitionController implements CompetitionControllerApi {

  @Autowired
  CompetitionService competitionService;

  @Override
  @RequestMapping("/index/swiperImage")
  public ResponseResult loadIndexImage() {
    return ResponseResult.okResult(competitionService.getIndexPic());
  }

  @Override
  public ResponseResult loadCompBasic(Integer page) {
    return null;
  }
}
