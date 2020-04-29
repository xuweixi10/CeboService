package com.nan.cebo.competition.domain.competition;

import java.util.List;
import lombok.Data;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 16:35
 */
@Data
public class CompetitionDetail {
  private String id;
  private String compId;
  private String detailTitle;
  private List<CompetitionDetailContent> contents;
}
