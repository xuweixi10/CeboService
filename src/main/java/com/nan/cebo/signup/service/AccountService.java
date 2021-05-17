package com.nan.cebo.signup.service;

import com.nan.cebo.signup.domain.Account;
import com.nan.cebo.signup.domain.SchoolInformation;

import java.util.ArrayList;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/23 13:40
 */
public interface AccountService {
    int checkAccountStatus(String openId,String nickName);
    String getWeChatUid(String openId);
    boolean updateSchoolInformation(Account account);
    Account getAccountInformation(String openId);
    //ArrayList<>
}
