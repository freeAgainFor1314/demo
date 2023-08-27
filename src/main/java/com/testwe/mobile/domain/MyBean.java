package com.testwe.mobile.domain;

import org.springframework.beans.factory.annotation.Value;

public class MyBean {
    @Value("${myConfig.myObject.myName}")
    private String myName;
    @Value("${myConfig.myObject.myAge}")
    private String myAge;

    public String getMyName(){
        return myName;
    }
    public String getMyAge(){
        return myAge;
    }

}
