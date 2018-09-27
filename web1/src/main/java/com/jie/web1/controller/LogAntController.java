package com.jie.web1.controller;

import com.jie.model.LogAnt;
import com.jie.model.LogScore;
import com.jie.service.ILogAntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/logAnt")
public class LogAntController {

    @Autowired
    private ILogAntService logAntService;

    @RequestMapping(value = "/addLogAnt")
    @ResponseBody
    public Object addLogAnt( LogAnt logAnt){
        return logAntService.addLogAnt( logAnt );
    }

    @RequestMapping(value = "/selectOne")
    @ResponseBody
    public Object selectOne( Integer aid){
        return logAntService.selectOne( aid );

    }

    @RequestMapping(value = "/selectAll")
    @ResponseBody
    public Object selectAll( ){
        return logAntService.selectAll();
    }

    @RequestMapping(value = "/updateLogAnt")
    @ResponseBody
    public Object updateLogAnt( Integer aid , Long version){
        return logAntService.updateLogAnt( aid , version );
    }
}
