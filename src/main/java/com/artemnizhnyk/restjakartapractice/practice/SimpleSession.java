package com.artemnizhnyk.restjakartapractice.practice;

import jakarta.ejb.Remote;

@Remote
public interface SimpleSession {

     String getMessage();
}
