package com.testwe.mobile.learn;

/**
 * 来自微软
 * 比如 str ="ayxbx"
 * 有以下4种切法 a|yxbx ay|xbx ayx|bx ayxb|x
 * 其中第134种切法符合，x和y的个数 至少在左右两块中的一块里有相同的数量所以返回3
 * 给定一个字符串str，长度N
 * 你有N-1种切法，返回有几种切法满足：
 * x和y的个数至少在左边或者右边满足相同的数量
 */
public class Code01_SplitSameNumberWays {

    public static void main(String[] args) {
        String str = "ayxbx";
        Code01_SplitSameNumberWays code01_splitSameNumberWays = new Code01_SplitSameNumberWays();
        int rlt = code01_splitSameNumberWays.splitSameNumberWays(str);
        System.out.println(rlt);
    }

    public int splitSameNumberWays(String str) {
        int ans = 0;
        int N = str.length();
        if (N == 0) {
            return 0;
        }
        int allX = 0, allY = 0, leftX = 0, leftY = 0;
        //init allx and ally
        for (int i = 0; i < N; i++) {
            allX += str.charAt(i) == 'x' ? 1 : 0;
            allY += str.charAt(i) == 'y' ? 1 : 0;
        }
        //先将第一位拿出来判断是x还是y然后开始循环，否则会把 为0的情况算为一种情况
        leftX = str.charAt(0) == 'x' ? 1 : 0;
        leftY = str.charAt(0) == 'y' ? 1 : 0;

        for (int i = 1; i < N; i++) {
            //左边一样多 或者右边一样多
            if (leftX == leftY || (allY - leftY) == (allX - leftX)) {
                ans++;
            }
            leftX += str.charAt(i) == 'x' ? 1 : 0;
            leftY += str.charAt(i) == 'y' ? 1 : 0;
        }
        return ans;
    }
}
