package com.nan.cebo.competition.controller;

import com.nan.cebo.competition.domain.apply.ApplyDataBase;
import com.nan.cebo.competition.domain.apply.ApplyFormData;
import com.nan.cebo.competition.service.Impl.ApplyService;
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



}
