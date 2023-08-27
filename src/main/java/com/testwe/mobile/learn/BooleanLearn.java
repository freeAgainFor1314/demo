package com.testwe.mobile.learn;

public class BooleanLearn {

    public boolean isOdd(int i ,Integer j){

        return false;
    }
    public boolean isOdd(Integer i, int j){
        return false;
    }

    public static void main(String[] args) {

        BooleanLearn booleanLearn = new BooleanLearn();
        Integer j = 1;
        int i =3;
        boolean odd = booleanLearn.isOdd(j, i);
        System.out.println(odd);

    }
}
