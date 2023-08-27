package com.testwe.mobile.learn;

import java.util.LinkedHashMap;

/**
 * 连续无重复子串
 */
public class MaxSubString {

    public static void main(String[] args) {
        MaxSubString maxSubString = new MaxSubString();
        String str ="pwwkew";//abcabcbb pwwkew bbbbb
        int i = maxSubString.lenOfString(str);
        System.out.println(i);
    }

    private int lenOfString(String str) {

        int max =0,left=0;
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i=0;i<str.length();i++){
            if(map.containsKey(str.charAt(i))){
                left = Math.max(map.get(str.charAt(i))+1,left);
            }
            map.put(str.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }


}
