package com.nan.cebo.common.response.dtos;

import com.nan.cebo.competition.domain.competition.Competition;
import com.nan.cebo.competition.domain.competition.CompetitionDetail;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    competition.setApplyBeginDate(new Date());
    competition.setApplyEndDate(new Date());
    CompetitionDetail cd=new CompetitionDetail();
    cd.setCompId("201903030003");
    cd.setContentURL("asdasd");
    cd.setDetailName("gfhfg");
    List<CompetitionDetail>cds=new ArrayList<>();
    cds.add(cd);
    competition.setCompetitionDetail(cds);
    ResponseResult responseResult = ResponseResult.okResult(competition);
    System.out.println(responseResult);
  }



}