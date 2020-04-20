package com.nan.cebo.competition.service;

import static org.junit.Assert.*;

import com.nan.cebo.Cebo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/18 16:58
 */
@SpringBootTest(classes = Cebo.class)
@RunWith(SpringRunner.class)
public class CompetitionServiceTest {
  @Autowired
  CompetitionService competitionService;


  @Test
  public void compBasicTest(){
    System.out.println(competitionService.getCompetionBasic(2));
  }

  @Test
  public void compDetailTest(){
    System.out.println(competitionService.getCompetionDetail("202003200001"));
  }
}