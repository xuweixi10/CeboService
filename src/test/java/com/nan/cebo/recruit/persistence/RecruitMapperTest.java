package com.nan.cebo.recruit.persistence;

import com.nan.cebo.Cebo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 15:24
 */
@SpringBootTest(classes = Cebo.class)
@RunWith(SpringRunner.class)
public class RecruitMapperTest {

  @Autowired
  RecruitMapper recruitMapper;

  @Test
  public void getRecruitBasicAll() {
    System.out.println(recruitMapper.getRecruitAll());
  }

  @Test
  public void getRecruit(){
    System.out.println(recruitMapper.getRecruit(0));
  }


}