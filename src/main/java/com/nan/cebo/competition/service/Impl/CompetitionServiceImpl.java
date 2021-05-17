package com.nan.cebo.competition.service.Impl;

import com.nan.cebo.competition.domain.competition.Competition;
import com.nan.cebo.competition.domain.competition.CompetitionDetail;
import com.nan.cebo.competition.domain.competition.CompetitionDetailContent;
import com.nan.cebo.competition.domain.competition.IndexPic;
import com.nan.cebo.competition.persistence.CompetitionMapper;
import com.nan.cebo.competition.service.CompetitionService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

  private static final int ITEMS_NUM_OF_EACH_PAGE = 6;

  @Autowired
  CompetitionMapper competitionMapper;

  @Override
  public List<IndexPic> getIndexPic() {
    return competitionMapper.getIndexSwiperImage();
  }

  @Override
  public List<Competition> getCompetionBasic(int page) {
    int startIndex = (page - 1) * ITEMS_NUM_OF_EACH_PAGE;
    return competitionMapper.getCompetitionBasic(startIndex);
  }

  @Override
  public List<Competition> getCompetionBasicAll() {
    return competitionMapper.getCompetitionBasicAll();
  }

  @Override
  public Competition getCompetitionDetail(String compId) {
    Competition competition = competitionMapper.getCompetitionBasicById(compId);
    if (competition == null) {
      return null;
    }
    competition.setIntroduce(competitionMapper.getCompetitionIntroduce(compId));
    return competition;
  }

  @Override
  public Competition getCompetionBasic(String compId) {
    return competitionMapper.getCompetitionBasicById(compId);
  }

  @Override
  public boolean addCollection(String openId, String competitionId) {
    try {
      competitionMapper.addCollection(openId, competitionId);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean deleteCollection(String openId, String competitionId) {
    try {
      competitionMapper.deleteCollection(openId,competitionId);
    }catch (Exception e){
      return false;
    }
    return true;
  }

  @Override
  public List<Competition> getCollections(String openId) {
    List<String> competitions = competitionMapper.getCollections(openId);
    ArrayList<Competition> competitionArrayList = new ArrayList<>();
    if(competitions==null||competitions.isEmpty()){
      return competitionArrayList;
    }
    else {
      for(String competitionId:competitions){
        competitionArrayList.add(competitionMapper.getCompetitionBasicById(competitionId));
      }
      return competitionArrayList;
    }
  }

  @Override
  public boolean checkData(String openId, String competitionId) {
    try {
      String id = competitionMapper.checkData(openId, competitionId);
      if (id == null) {
        return false;
      }
    } catch (Exception e) {
      return true;
    }
    return true;
  }
}
