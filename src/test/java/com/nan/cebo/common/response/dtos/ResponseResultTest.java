package com.nan.cebo.common.response.dtos;

import static org.junit.Assert.*;

import com.nan.cebo.competition.domain.competition.Competition;
import com.nan.cebo.competition.domain.competition.CompetitionDetail;
import java.util.Date;
import org.junit.Test;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 15:21
 */
public class ResponseResultTest {

  @Test
  public void testResponse(){
    Competition competition=new Competition();
    competition.setId("201903030003");
    competition.setCompName("asdasdasd");
    competition.setObject("asdsad");
    competition.setOrganizer("asda");
    competition.setCoOrganizer("sdsd");
    competition.setCompType("qweqwe");
    competition.setApplyBgeinDate(new Date());
    competition.setApplyEndDate(new Date());
    CompetitionDetail cd=new CompetitionDetail();
    cd.setCompId("201903030003");
    cd.setContentURL("asdasd");
    cd.setDetailName("gfhfg");
    competition.setCompetitionDetail(cd);
    ResponseResult responseResult = ResponseResult.okResult(competition);
    System.out.println(responseResult);
  }



}