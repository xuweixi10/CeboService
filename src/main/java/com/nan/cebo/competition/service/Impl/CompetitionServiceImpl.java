package com.nan.cebo.competition.service.Impl;

import com.nan.cebo.competition.domain.competition.Competition;
import com.nan.cebo.competition.domain.competition.CompetitionDetail;
import com.nan.cebo.competition.domain.competition.CompetitionDetailContent;
import com.nan.cebo.competition.domain.competition.IndexPic;
import com.nan.cebo.competition.persistence.CompetitionMapper;
import com.nan.cebo.competition.service.CompetitionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 17:09
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

  private static final int ITEMS_NUM_OF_EACH_PAGE=6;

  @Autowired
  CompetitionMapper competitionMapper;

  @Override
  public List<IndexPic> getIndexPic() {
    return competitionMapper.getIndexSwiperImage();
  }

  @Override
  public List<Competition> getCompetionBasic(int page) {
    int startIndex=(page-1)*ITEMS_NUM_OF_EACH_PAGE;
    return competitionMapper.getCompetitionBasic(startIndex);
  }

  @Override
  public List<Competition> getCompetionBasicAll() {
    return competitionMapper.getCompetitionBasicAll();
  }

  @Override
  public Competition getCompetitionDetail(String compId) {
    Competition competition=competitionMapper.getCompetitionBasicById(compId);
    if (competition==null){
      return null;
    }
    List<CompetitionDetail> competitionDetail = competitionMapper
        .getCompetitionDetailById(compId);
    for(CompetitionDetail detail:competitionDetail){
      List<CompetitionDetailContent> contents=competitionMapper
          .getCompetitionDetailContentByDetailId(detail.getId());
      detail.setContents(contents);
    }
    competition.setCompetitionDetail(competitionDetail);
    return competition;
  }

  @Override
  public Competition getCompetionBasic(String compId) {
    return competitionMapper.getCompetitionBasicById(compId);
  }
}
