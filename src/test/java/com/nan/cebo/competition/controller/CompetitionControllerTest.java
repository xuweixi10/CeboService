package com.nan.cebo.competition.controller;

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
public class CompetitionControllerTest {

  @Autowired
  CompetitionController controller;

  @Test
  public void CompBasicTest(){
    System.out.println("\n"+controller.loadCompBasic(2));
    System.out.println("\n"+controller.loadCompBasic(-1));
    System.out.println("\n"+controller.loadCompBasic((Integer)(null)));
  }

  @Test
  public void CompDetailTest(){
    System.out.println(controller.loadCompDetail("202003200001"));
  }

}