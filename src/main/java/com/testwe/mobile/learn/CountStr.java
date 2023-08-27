package com.testwe.mobile.learn;

import java.util.HashMap;
import java.util.Map;

public class CountStr {


    public static void main(String[] args) {
        CountStr countStr = new CountStr();
        String str = "abcaaaefdabbhg";
        Map<Character, Integer> map = countStr.charCount(str);
        map.forEach((key,val)->{
            System.out.println(key+":"+ val);
        });

    }

    //java 字符串出现的次数
    public Map<Character,Integer> charCount(String str){

        Map<Character, Integer> map = new HashMap<>();

        for (int i=0;i<str.length();i++){

            if(!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i),1);
            }else{
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
            }
        }
        return map;
    }
}
