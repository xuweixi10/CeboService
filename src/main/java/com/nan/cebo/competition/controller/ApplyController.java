package com.nan.cebo.competition.controller;

import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyFormData;
import com.nan.cebo.competition.domain.apply.submit.SubmitData;
import com.nan.cebo.competition.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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



}
