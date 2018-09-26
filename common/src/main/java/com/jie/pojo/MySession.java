package com.jie.pojo;

import com.google.gson.Gson;
import org.springframework.session.ExpiringSession;
import org.springframework.session.Session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionContext;
import java.io.Serializable;
import java.util.*;

public class MySession  implements Serializable,ExpiringSession {

    private  String id;
    private  Map<Object, Object> attributes;

    public String toString(){
        return this.id.toString();
    }

    public void setLastAccessedTime(long l) {

    }

    public void setMaxInactiveIntervalInSeconds(int i) {

    }

    public int getMaxInactiveIntervalInSeconds() {
        return 0;
    }

    public boolean isExpired() {
        return false;
    }

    public Set<String> getAttributeNames() {
        return null;
    }

    public MySession(){
        this.id = UUID.randomUUID().toString();
    }

    public long getCreationTime() {
        return 0;
    }

    public String getId() {
        return this.id.toString();
    }

    public long getLastAccessedTime() {
        return 0;
    }

    public ServletContext getServletContext() {
        return null;
    }

    public void setMaxInactiveInterval(int interval) {

    }

    public int getMaxInactiveInterval() {
        return 0;
    }

    public HttpSessionContext getSessionContext() {
        return getSessionContext();
    }

    public Object getAttribute(String name) {
        if( attributes == null ){
            return null;
        }

        return attributes.get( name );
    }

    public Object getValue(String name) {
        return null;
    }

    public static Gson gson = new Gson();

    public String[] getValueNames() {
        return null;
    }

    public void setAttribute(String name, Object value) {
        System.out.println( "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
        if( attributes == null ){
            attributes = new HashMap<Object, Object>();
        }
        attributes.put( name ,value );

        RedisUtil.set( this.id.toString() , gson.toJson( this , MySession.class ));
    }

    public void putValue(String name, Object value) {

    }

    public void removeAttribute(String name) {
        if( attributes == null ) return;

        attributes.remove( name );
    }

    public void removeValue(String name) {

    }

    public void invalidate() {

    }

    public boolean isNew() {
        return true;
    }
}
