package com.testwe.mobile.learn;

import lombok.Data;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8Learn {
    public static void main(String[] args) {
        AmountVo amountVo = new AmountVo(){{
            setCurrency("USA");
            setMoney(16.32D);
        }};

        Collector<AmountVo, ?, Double> amountVoDoubleCollector = Collectors.averagingDouble(AmountVo::getMoney);



    }
}
@Data
class AmountVo{
    private Double money;
    private String currency;
}
