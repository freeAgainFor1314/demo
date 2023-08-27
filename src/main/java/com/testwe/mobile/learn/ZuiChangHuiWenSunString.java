package com.testwe.mobile.learn;

public class ZuiChangHuiWenSunString {

    public static void main(String[] args) {

//        String s = "aaa";
        String s = "abbacab";
        ZuiChangHuiWenSunString zuiChangHuiWenSunString = new ZuiChangHuiWenSunString();
//        int i = zuiChangHuiWenSunString.countSubString(s);
//        System.out.println(i);

        String str = zuiChangHuiWenSunString.countSubStr2(s);
        System.out.println(str);
    }

    private String countSubStr2(String s) {

        String res = "";
        int rlt = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j <= len - 1; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    rlt++;
                    if (j - i >= res.length()) {
                        res = s.substring(i, j + 1);
                    }

                }
            }
        }
        return res;


    }

    private int countSubString(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];

        int rlt = 0;
        // 从下往上 从左往后
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (chars[i] == chars[j] && (j - i <= 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    rlt++;
                }

            }

        }
        return rlt;

    }

    private int countSubString2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int rlt = 0;
        //total 2*len -1 个中心点，确定左和右的下标
        for (int i = 0; i <= 2 * len - 1; i++) {
            //确定左中心点和右中心点
            int left = i / 2;
            int right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                right++;
                left--;
                rlt++;
            }
        }
        return rlt;


    }


}
