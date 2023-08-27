package com.testwe.mobile.initializer;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyApplicationContextInitializer implements ApplicationContextInitializer {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

        applicationContext.addBeanFactoryPostProcessor(new MyBeanFactoryPostProcessor());

    }
}
