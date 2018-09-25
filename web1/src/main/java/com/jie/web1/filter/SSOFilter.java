package com.jie.web1.filter;

import org.springframework.session.SessionRepository;
import org.springframework.session.web.http.HttpSessionStrategy;
import org.springframework.session.web.http.MultiHttpSessionStrategy;
import org.springframework.session.web.http.SessionRepositoryFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SSOFilter extends SessionRepositoryFilter {

    public SSOFilter(SessionRepository sessionRepository) {
        super(sessionRepository);
    }

    @Override
    public void setHttpSessionStrategy(HttpSessionStrategy httpSessionStrategy) {
        super.setHttpSessionStrategy(httpSessionStrategy);
    }

    @Override
    public void setHttpSessionStrategy(MultiHttpSessionStrategy httpSessionStrategy) {
        super.setHttpSessionStrategy(httpSessionStrategy);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        super.doFilterInternal(request, response, filterChain);
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        super.setServletContext(servletContext);
    }
}
