package com.jie.web1.controller;

import com.jie.model.LogScore;
import com.jie.model.Order;
import com.jie.service.ILogScoreService;
import com.jie.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logScore")
public class LogScoreController {

    @Autowired
    private ILogScoreService logScoreService;

    @RequestMapping(value = "/addLogScore")
    @ResponseBody
    public Object addLogScore( LogScore logScore){
        return logScoreService.addLogScore( logScore );
    }

    @RequestMapping(value = "/selectOne")
    @ResponseBody
    public Object selectOne( Integer sid){
        return logScoreService.selectOne( sid );

    }

    @RequestMapping(value = "/selectOne2map")
    @ResponseBody
    public Object selectOne2map( Integer sid){
        return logScoreService.selectOne2map( sid );

    }

    @RequestMapping(value = "/selectLogAntJoinLogScore")
    @ResponseBody
    public Object selectLogAntJoinLogScore( Integer orderId){
        return logScoreService.selectLogAntJoinLogScore( orderId );

    }

    @RequestMapping(value = "/selectAll")
    @ResponseBody
    public Object selectAll( ){
        return logScoreService.selectAll();
    }

    @RequestMapping(value = "/updateLogScore")
    @ResponseBody
    public Object updateLogScore( Integer sid , Long version){
        return logScoreService.updateLogScore( sid , version );
    }
}
