package com.nan.cebo.recruit.controller;

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

  @Test
  public void removeRecruit(){
    System.out.println("1"+recruitController.deleteRecruitInfoById("2020042500017","asd","asd"));
    System.out.println("2"+recruitController.deleteRecruitInfoById("20200=4250dw0017","asd","qwe"));
    System.out.println("3"+recruitController.deleteRecruitInfoById("20200425 00017","asd","asd"));
    System.out.println("4"+recruitController.deleteRecruitInfoById("2020042500017\n","asd","asd"));
    System.out.println("5"+recruitController.deleteRecruitInfoById("2020042500017","qwe","qwe"));
    System.out.println("6"+recruitController.deleteRecruitInfoById("2020042500017","qwe","asd"));
  }
}