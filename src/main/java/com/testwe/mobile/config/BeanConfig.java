package com.testwe.mobile.config;

import com.testwe.mobile.domain.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public MyBean myBean(){
        return new MyBean();
    }
}
