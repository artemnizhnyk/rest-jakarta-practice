package com.artemnizhnyk.restjakartapractice.practice;

import jakarta.ejb.Stateless;

@Stateless
public class SimpleSessionBean implements SimpleSession {

    private final String message = "If you see this message, everything works";

    @Override
    public String getMessage() {
        return message;
    }
}
