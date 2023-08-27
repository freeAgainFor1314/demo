package com.testwe.mobile.learn;

import java.util.PriorityQueue;

public class BitCal {
    public static void main(String[] args) {

        System.out.println((5 - 1) >>> 1);
        System.out.println((7 - 1) >>> 1);
        System.out.println((3 - 1) >>> 1);
        System.out.println(1+ ((3 - 1) >> 1));
        System.out.println(1+ ((4 - 1) >> 1));
        System.out.println(1+((5 - 1) >> 1));

        int a = 5;
        int b =3;

        System.out.println((a +b -1)/b);


        System.out.println(Long.MAX_VALUE >> 1);
        System.out.println((5 & 4));
        System.out.println((4 & 3));
        System.out.println((2 & 1));
        System.out.println((6 & 5));
        System.out.println((7 & 6));
        System.out.println((8 & 7));
        System.out.println((9 & 8));

        System.out.println((7 | 8));//15
        System.out.println((7 & 8));//0
        //System.out.println((7 | 8)%(7 & 8));




    }
}
