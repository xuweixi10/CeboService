package com.nan.cebo.competition.domain.competition;

import lombok.Data;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/15 17:04
 */
@Data
public class IndexPic {
  private Integer id;
  private String compId;
  private String picName;//可被用于alt属性
  private String picURL;
}
