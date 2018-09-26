package com.jie.web1.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RequestMapping("/web1")
@Controller
public class Web1Controller {


    @RequestMapping(value = "/login" , method =  RequestMethod.POST )
    @ResponseBody
    public String login( String name , String password , HttpServletRequest request){

        System.out.println( "id xxxx : " + request.getSession().getId() );
        request.getSession().setAttribute("name" , name );
        request.getSession().setAttribute("password" , password );
        return "success!  name:" + name +" password: " + password;
    }

    @RequestMapping(value = "/test1" , method =  RequestMethod.POST )
    @ResponseBody
    public String web1Test(String p1 , HttpServletRequest request , HttpServletResponse response){
        System.out.println( " 用户进入");

        HttpSession session = request.getSession();
        if( session == null ){
            return "未登录";
        }
        String sessionId = session.getId();
        System.out.println( " 用户sessionId:" + sessionId );
        System.out.println( " 用户name:" + session.getAttribute( "name") );
        System.out.println( " 用户password:" + session.getAttribute( "password") );

        return " 访问成功：" +p1 +" : "+ sessionId  ;
    }
}
