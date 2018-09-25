package com.jie.web1.filter;

import org.springframework.session.Session;
import org.springframework.session.SessionRepository;

import java.util.UUID;

public class MySessionRepositoty implements SessionRepository {

    public Session createSession() {

        MySession session = new MySession( );
        session.setSessionId(UUID.randomUUID().toString() );
        return session;
    }

    public void save(Session session) {

    }

    public Session getSession(String s) {
        return null;
    }

    public void delete(String s) {

    }
}
