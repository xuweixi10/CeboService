package com.nan.cebo.signup.controller;

import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.signup.domain.Account;
import com.nan.cebo.signup.domain.SchoolInformation;
import com.nan.cebo.signup.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/23 14:13
 */
@CrossOrigin
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @ResponseBody
    @RequestMapping(value = "/openId",method = {RequestMethod.GET})
    public ResponseResult getAccountOpenId(@RequestParam("code") String code){
        String openId=accountService.getWeChatUid(code);
        if(openId!=null){
            return ResponseResult.okResult(openId);
        }
        return ResponseResult.errorResult(1002,"code is null");
    }

    @ResponseBody
    @RequestMapping(value = "/information",method = {RequestMethod.GET})
    public ResponseResult getAccountInformation(@RequestParam("openId") String openId){
        try {
            Account account=accountService.getAccountInformation(openId);
            if(account!=null){
                return ResponseResult.okResult(account);
            }
            return ResponseResult.okResult(1001,"账号不存在");
        }catch (Exception e){
            return ResponseResult.errorResult(503,"服务器错误");
        }
    }

    @ResponseBody
    @RequestMapping(value = "/schoolInformation",method = {RequestMethod.POST})
    public ResponseResult getAccountInformation(@RequestBody Account account){
        try {
            boolean res=accountService.updateSchoolInformation(account);
            if(res){
                return ResponseResult.okResult(200,"更新成功");
            }
            else {
                return ResponseResult.errorResult(1002,"没有对应的账号");
            }
        }catch (Exception e){
            return ResponseResult.errorResult(503,"服务器错误");
        }
    }
}
