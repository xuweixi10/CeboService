package com.nan.cebo.competition.persistence;

import static org.junit.Assert.*;

import com.nan.cebo.Cebo;
import com.nan.cebo.competition.service.CompetitionService;
import java.sql.SQLOutput;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/20 16:45
 */
@SpringBootTest(classes = Cebo.class)
@RunWith(SpringRunner.class)
public class CompetitionMapperTest {

  @Autowired
  CompetitionMapper competitionMapper;

  @Test
  public void CompBasicTest(){
    System.out.println(competitionMapper.getCompetitionBasic(0));

  }

  @Test
  public void CompBasicByIdTest(){
    System.out.println(competitionMapper.getCompetitionBasicById("201911230001"));
  }

  @Test
  public void CompDetailByIdTest(){
    System.out.println(competitionMapper.getCompetitionDetailById("202003200001"));
  }
}