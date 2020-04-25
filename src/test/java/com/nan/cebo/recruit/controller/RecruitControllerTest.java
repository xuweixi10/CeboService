package com.nan.cebo.recruit.controller;

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
 * @Date 2020/4/25 14:37
 */
@SpringBootTest(classes = Cebo.class)
@RunWith(SpringRunner.class)
public class RecruitControllerTest {

  @Autowired
  RecruitController recruitController;

  @Test
  public void loadHotCompetition() {
    System.out.println(recruitController.loadHotCompetition());
  }

  @Test
  public void loadRecruitDetail(){
    System.out.println(recruitController.loadRecruitDetail(null));
    System.out.println(recruitController.loadRecruitDetail(0));
    System.out.println(recruitController.loadRecruitDetail(2));
  }
}