package com.testwe.mobile.reactor;

import reactor.core.publisher.Flux;

public class Flux1 {
    public static void main(String[] args) {

        Flux.just(1,2,0).log().map(i->{
            return "100 / "+i+" = "+(100/i);
        }).onErrorReturn("Divided by zero :(")
                .onErrorResume(error->{
                    return null;
                })
                .subscribe(System.out::println);


    }
}
