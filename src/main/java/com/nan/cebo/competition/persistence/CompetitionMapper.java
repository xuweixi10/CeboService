package com.nan.cebo.competition.persistence;

import com.nan.cebo.competition.domain.competition.Competition;
import com.nan.cebo.competition.domain.competition.CompetitionDetail;
import com.nan.cebo.competition.domain.competition.CompetitionDetailContent;
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

  /**
   * @param beginIndex 分页的开始页数
   * @return 竞赛基本信息列表
   */
  List<Competition> getCompetitionBasic(int beginIndex);

  /**
   * @return 全部竞赛信息列表
   */
  List<Competition> getCompetitionBasicAll();

  /**
   * @param compId 竞赛Id
   * @return 竞赛基本信息
   */
  Competition getCompetitionBasicById(String compId);

  /**
   * @param compId 竞赛Id
   * @return 竞赛详细信息列表
   */
  List<CompetitionDetail> getCompetitionDetailById(String compId);

  /**
   * @param detailId 细节Id
   * @return 竞赛详细信息内容列表
   */
  List<CompetitionDetailContent> getCompetitionDetailContentByDetailId(String detailId);
}
