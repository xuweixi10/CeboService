package com.nan.cebo;

import static org.junit.Assert.*;

import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.competition.controller.CompetitionController;
import com.nan.cebo.competition.domain.competition.IndexPic;
import com.nan.cebo.competition.persistence.CompetitionMapper;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description 测试类
 * @Author WM
 * @Date 2020/4/14 16:23
 */
@SpringBootTest(classes = Cebo.class)
@RunWith(SpringRunner.class)
public class CeboTest {
  @Autowired
  CompetitionMapper mapper;

  @Autowired
  CompetitionController competitionController;

  @Test
  public void testArticle() {
//    List<IndexPic> indexSwiperImage = mapper.getIndexSwiperImage();
    ResponseResult responseResult = competitionController.loadIndexImage();
    System.out.println(responseResult);
  }
}