package com.jie.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/web2")
public class Web2Controller {

    @RequestMapping(value = "/test2" , method =  RequestMethod.POST )
    @ResponseBody
    public String web2Test(String p2 , HttpServletRequest request , HttpServletResponse response){

        System.out.println( " 用户进入");

        HttpSession session = request.getSession();
        if( session == null ){
            return "未登录";
        }
        String sessionId = session.getId();
        System.out.println( " 用户sessionId:" + sessionId );
        System.out.println( " 用户name:" + session.getAttribute( "name") );
        System.out.println( " 用户password:" + session.getAttribute( "password") );

        return " 访问成功：" +p2 +" : "+ sessionId  ;
    }


    @RequestMapping(value = "/aaa" , method =  RequestMethod.POST )
    @ResponseBody
    public String aaa(String p2 , HttpServletRequest request , HttpServletResponse response){

       return "xxx";
    }
}
