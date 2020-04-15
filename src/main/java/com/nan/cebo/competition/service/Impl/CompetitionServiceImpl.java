package com.nan.cebo.competition.service.Impl;

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

  @Autowired
  CompetitionMapper competitionMapper;

  @Override
  public List<IndexPic> getIndexPic() {
    return competitionMapper.getIndexSwiperImage();
  }
}
