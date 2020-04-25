package com.nan.cebo.recruit.service;

import com.nan.cebo.recruit.domain.vos.HotCompetitionVO;
import com.nan.cebo.recruit.domain.vos.RecruitBasicVO;
import java.util.List;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 12:39
 */
public interface RecruitService {


  List<HotCompetitionVO> getHotCompetition();

  List<RecruitBasicVO> getRecruitBasicAll();

  List<RecruitBasicVO> getRecruitBasic(Integer page);
}
