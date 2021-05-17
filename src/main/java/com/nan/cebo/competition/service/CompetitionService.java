package com.nan.cebo.competition.service;

import com.nan.cebo.competition.domain.competition.Competition;
import com.nan.cebo.competition.domain.competition.IndexPic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 17:08
 */
public interface CompetitionService {
  List<IndexPic> getIndexPic();

  List<Competition> getCompetionBasic(int page);

  List<Competition> getCompetionBasicAll();

  Competition getCompetitionDetail(String compId);

  Competition getCompetionBasic(String compId);

  boolean addCollection(String openId,String competitionId);

  boolean deleteCollection(String openId,String competitionId);

  List<Competition> getCollections(String openId);

  boolean checkData(String openId,String competitionId);
}
