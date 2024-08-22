package com.artemnizhnyk.restjakartapractice.practice;

import jakarta.ejb.EJB;

public class SessionBeanClient {
    @EJB
    private static SimpleSession simpleSession;
    private void invokeSessionBeanMethods() {
        System.out.println(simpleSession.getMessage());
        System.out.println("\nSimpleSession is of type: "
                + simpleSession.getClass().getName());
    }
    public static void main(String[] args) {
        new SessionBeanClient().invokeSessionBeanMethods();
    }
}