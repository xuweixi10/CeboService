package com.nan.cebo.recruit.service;

import static org.junit.Assert.*;

import com.nan.cebo.Cebo;
import com.nan.cebo.competition.service.CompetitionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 14:29
 */
@SpringBootTest(classes = Cebo.class)
@RunWith(SpringRunner.class)
public class RecruitServiceTest {

  @Autowired
  RecruitService recruitService;

  @Test
  public void hotCompTest(){
    System.out.println(recruitService.getHotCompetition());
  }

  @Test
  public void basicAllTest(){
    System.out.println(recruitService.getRecruitBasicAll());
  }

  @Test
  public void basicTest(){
    System.out.println(recruitService.getRecruitBasic(2));
  }

}