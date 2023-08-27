package com.testwe.mobile.controller;

import com.testwe.mobile.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.Callable;

@RestController
public class MyController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/api")
    public Person getPerson() {
        Person person = new Person();


        person.setAge(12);
        person.setName("zhangsan");
        person.setId(1);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return person;

    }
    @ResponseBody
    @GetMapping("/async/getPerson")
    public Callable<Person> asyncGetPerson() {

//        return this::callPerson;
        return new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                Person person = new Person();


                person.setAge(12);
                person.setName("zhangsan");
                person.setId(1);
                try {
                    Thread.sleep(5000);
                    log.info("current thread :{}", Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                return person;
            }
        };
    }
    @RequestMapping("asyncCallable/{param}")
    public Callable<String> asyncCallable(@PathVariable("param") String param){

        log.info("asyncCallable controller start:{}", Thread.currentThread().getName());

        Callable<String> call = new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("asyncCallable call start:{}", Thread.currentThread().getName());
                Thread.sleep(5000);
                log.info("asyncCallable call end:{}", Thread.currentThread().getName());
                return String.format("asynCallable %s:%s", param, new Date());
            }
        };
        log.info("asyncCallable controller end:{}", Thread.currentThread().getName());
        return call;
    }


}
