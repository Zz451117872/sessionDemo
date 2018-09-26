package com.jie.pojo;

import com.google.gson.Gson;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;

public class MySessionRepositoty implements SessionRepository {
    
    public static Gson gson = new Gson();

    public Session createSession() {
        return new MySession();
    }

    public void save(Session session) {
        System.out.println( "id: 123 " + session.toString() );
        RedisUtil.set( session.getId() , gson.toJson(session));
    }

    public Session getSession(String s) {
        MySession session = gson.fromJson( RedisUtil.get( s ) , MySession.class );
        return session;
    }

    public void delete(String s) {
        RedisUtil.remove( s );
    }
}
