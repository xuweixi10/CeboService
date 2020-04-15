package com.nan.cebo.competition.persistence;

import com.nan.cebo.competition.domain.competition.IndexPic;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 16:37
 */
@Mapper
public interface CompetitionMapper {

  /**
   * @return 首页轮播图列表
   */
  List<IndexPic> getIndexSwiperImage();




}
