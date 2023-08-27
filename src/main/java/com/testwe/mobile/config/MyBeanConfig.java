package com.testwe.mobile.config;

import com.testwe.mobile.domain.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBeanConfig {

    @Bean
    public Person person(){
        return new Person();
    }
}
