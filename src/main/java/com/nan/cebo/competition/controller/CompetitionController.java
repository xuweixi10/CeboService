package com.nan.cebo.competition.controller;

import com.nan.cebo.apis.competition.v1.CompetitionControllerApi;
import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.common.response.enums.AppHttpCodeEnum;
import com.nan.cebo.competition.domain.competition.Competition;
import com.nan.cebo.competition.service.CompetitionService;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 15:38
 */
@RestController
@CrossOrigin
@RequestMapping("/api/competition/v1")
public class CompetitionController implements CompetitionControllerApi {

  @Autowired
  CompetitionService competitionService;

  @Override
  @RequestMapping(value = "/index/swiperImage", method = {RequestMethod.GET})
  public ResponseResult loadIndexImage() {
    return ResponseResult.okResult(competitionService.getIndexPic());
  }

  @Override
  @RequestMapping(value = "/basic", method = {RequestMethod.GET})
  public ResponseResult loadCompBasic(@RequestParam(value = "page", required = false) Integer page) {
    if (page == null) {
      return ResponseResult.okResult(competitionService.getCompetionBasicAll());
    } else if (page > 0) {
      return ResponseResult.okResult(competitionService.getCompetionBasic(page));
    } else {
      return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID, "页码错误");
    }
  }

  @Override
  @RequestMapping(value = "/basic/{compId}", method = {RequestMethod.GET})
  public ResponseResult loadCompBasic(@PathVariable("compId") String compId) {
    if (compId == null) {
      return ResponseResult.okResult(competitionService.getCompetionBasicAll());
    }
    Competition competionBasic = competitionService.getCompetionBasic(compId);
    if (competionBasic == null) {
      return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "找不到对应Id的竞赛");
    }
    return ResponseResult.okResult(competionBasic);
  }

  @Override
  @RequestMapping(value = "/detail", method = {RequestMethod.GET})
  public ResponseResult loadCompDetail(@RequestParam("compId") @NotNull String compId) {
    if (compId == null) {
      return loadCompBasic((Integer) (null));
    }
    Competition competition = competitionService.getCompetitionDetail(compId);
    if (competition == null) {
      return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST, "找不到对应Id的竞赛");
    }
    return ResponseResult.okResult(competition);
  }

  @Override
  @RequestMapping(value = "/addCollection", method = {RequestMethod.POST})
  public ResponseResult addCollection(@RequestParam("openId") String openId,
                                      @RequestParam("competitionId") String competitionId) {
    if (openId == null || competitionId == null) {
      return ResponseResult.okResult(false);
    } else {
      boolean result = competitionService.addCollection(openId, competitionId);
      return ResponseResult.okResult(result);
    }
  }

  @Override
  @RequestMapping(value = "/deleteCollection", method = {RequestMethod.GET})
  public ResponseResult deleteCollection(String openId, String competitionId) {
    if (openId == null || competitionId == null) {
      return ResponseResult.okResult(false);
    } else {
      return ResponseResult.okResult(competitionService.deleteCollection(openId, competitionId));
    }
  }

  @Override
  @RequestMapping(value = "/getCollections", method = {RequestMethod.GET})
  public ResponseResult getCollections(@RequestParam("openId") String openId) {
    return ResponseResult.okResult(competitionService.getCollections(openId));
  }

  @Override
  @RequestMapping(value = "/checkData", method = {RequestMethod.GET})
  public ResponseResult checkData(@RequestParam("openId") String openId,
                                  @RequestParam("competitionId") String competitionId) {
    boolean result = competitionService.checkData(openId,competitionId);
    return ResponseResult.okResult(result);
  }

}
