package com.jie.pojo;

import org.springframework.session.Session;
import org.springframework.session.web.http.HttpSessionStrategy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHttpSessionStrategy implements HttpSessionStrategy {

    public String getRequestedSessionId(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRequestedSessionId();
    }

    public void onNewSession(Session session, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }

    public void onInvalidateSession(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {

    }
}
