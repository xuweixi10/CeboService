package com.nan.cebo.recruit.domain.pojos;

import lombok.Data;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 15:14
 */
@Data
public class RecruitInfo {
  private String id;
  private String postedId;
  private String compName;
  private String wantedPerson;
  private String introduction;
  private String extraInfo;

}
