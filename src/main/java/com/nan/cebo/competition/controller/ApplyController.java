package com.nan.cebo.competition.controller;

import com.nan.cebo.common.response.dtos.ResponseResult;
import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyFormData;
import com.nan.cebo.competition.domain.apply.submit.SubmitData;
import com.nan.cebo.competition.service.ApplyService;
import com.nan.cebo.signup.domain.ApplyCompetition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @author xuxiaoxi10
 * @version 1.0
 * @date 2020/4/13 23:49
 */
@CrossOrigin
@Controller
@RequestMapping("/Apply")
public class ApplyController {
    @Autowired
    private ApplyService applyService;

    @ResponseBody
    @RequestMapping(value = "/getApplyInformation",method={RequestMethod.GET})
    public ApplyFormData getCompetitionInformation(@RequestParam("competitionId") String competitionId){
        ApplyDataBase applyDataBase=applyService.getDataBase(competitionId);
        return applyService.dataBaseToFormData(applyDataBase);
    }
    @ResponseBody
    @RequestMapping(value = "/submitInformation",method = {RequestMethod.POST})
    public boolean submitData(@RequestBody SubmitData submitData){
        //检查合法性，避免恶意攻击
        String teamId=applyService.insertTeamData(submitData);
        if(teamId!=null){
            return true;
        }
        return false;
    }

    @ResponseBody
    @RequestMapping(value = "/getAllApplyCompetition",method = {RequestMethod.GET})
    public ResponseResult getUserCompetitions(@RequestParam("openId") String openId){
        try {
            ArrayList<ApplyCompetition> competitions=applyService.getUserCompetitions(openId);
            if(competitions.size()>0){
                return ResponseResult.okResult(competitions);
            }
            else {
                return ResponseResult.okResult(new ArrayList<ApplyCompetition>());
            }
        }catch (Exception e){
            return ResponseResult.errorResult(1002,"查找数据发生错误");
        }
    }

    /**
     * 获取指定比赛的报名信息
     * @param teamId 队伍id
     * @return 详细信息
     */
    @ResponseBody
    @RequestMapping(value = "/getCompetitionDetails",method = {RequestMethod.GET})
    public ResponseResult getApplyDetails(@RequestParam("teamId") String teamId){
        SubmitData data=applyService.getApplyDetails(teamId);
        if(data.getCapData().size()==0){
            return ResponseResult.errorResult(1003,"no data");
        }else {
            return ResponseResult.okResult(data);
        }
    }


}
