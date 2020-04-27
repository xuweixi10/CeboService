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

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getPostedId() {
    return postedId;
  }

  public void setPostedId(String postedId) {
    this.postedId = postedId;
  }

  public String getCompName() {
    return compName;
  }

  public void setCompName(String compName) {
    this.compName = compName;
  }

  public String getWantedPerson() {
    return wantedPerson;
  }

  public void setWantedPerson(String wantedPerson) {
    this.wantedPerson = wantedPerson;
  }

  public String getIntroduction() {
    return introduction;
  }

  public void setIntroduction(String introduction) {
    this.introduction = introduction;
  }

  public String getExtraInfo() {
    return extraInfo;
  }

  public void setExtraInfo(String extraInfo) {
    this.extraInfo = extraInfo;
  }
}
