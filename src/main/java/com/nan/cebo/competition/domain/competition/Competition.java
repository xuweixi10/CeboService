package com.nan.cebo.competition.domain.competition;

import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 16:31
 */
@Data
public class Competition {
  private String id;
  private String compName;
  private String organizer;
  private String coOrganizer;
  private String compType;
  private Date applyBeginDate;
  private Date applyEndDate;
  private String object;
  private String introduce;
  private List<CompetitionDetail> competitionDetail;

  public Competition() {
  }


}
