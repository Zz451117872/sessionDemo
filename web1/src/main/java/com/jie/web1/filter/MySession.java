package com.jie.web1.filter;

import org.springframework.session.Session;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.Set;

public class MySession  implements HttpSession {

    public long getCreationTime() {
        return 0;
    }

    public String getId() {
        return null;
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
        return null;
    }

    public Object getAttribute(String name) {
        return null;
    }

    public Object getValue(String name) {
        return null;
    }

    public Enumeration getAttributeNames() {
        return null;
    }

    public String[] getValueNames() {
        return new String[0];
    }

    public void setAttribute(String name, Object value) {

    }

    public void putValue(String name, Object value) {

    }

    public void removeAttribute(String name) {

    }

    public void removeValue(String name) {

    }

    public void invalidate() {

    }

    public boolean isNew() {
        return false;
    }
}
