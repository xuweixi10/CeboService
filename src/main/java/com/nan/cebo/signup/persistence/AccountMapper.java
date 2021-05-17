package com.nan.cebo.signup.persistence;

import com.nan.cebo.signup.domain.Account;
import com.nan.cebo.signup.domain.SchoolInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * 账户相关逻辑
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/23 13:08
 */
@Mapper
public interface AccountMapper {
    /**
     * 根据openid获取用户信息
     * @param openId 用户openId
     * @return Account 用户信息
     */
    Account getUserInformation(String openId);

    /**
     * 插入用户信息
     * @param account 用户信息
     */
    void insertAccount(Account account);

    /**
     * update user school information
     * @param schoolInformation user school
     */
    void updateSchoolInformation(Account account);
}
