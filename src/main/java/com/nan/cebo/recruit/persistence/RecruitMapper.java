package com.nan.cebo.recruit.persistence;

import com.nan.cebo.recruit.domain.pojos.RecruitInfo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Description
 * @Author WM
 * @Date 2020/4/25 12:42
 */
@Mapper
public interface RecruitMapper {

  List<RecruitInfo> getRecruitAll();

  List<RecruitInfo> getRecruit(int startIndex);
}
