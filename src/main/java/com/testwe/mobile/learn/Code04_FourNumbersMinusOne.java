package com.testwe.mobile.learn;

import java.util.Arrays;

/**
 * 来自阿里笔试
 * 老师给了5个数字，每次操作可以选择其中的4个数字减1
 * 减1之后的数字不能小于0，自己最多可以进行多少次这样的操作
 * 扩展问题来自leetcode 2141
 * https://leetcode.cn/problems/maximum-running-time-of-n-computers/
 */
public class Code04_FourNumbersMinusOne {

    public static void main(String[] args) {
        //int[] batteries = {3, 3, 3};
        int[] batteries = {1, 1, 1, 1};
        Code04_FourNumbersMinusOne code04_fourNumbersMinusOne = new Code04_FourNumbersMinusOne();
        long rlt = code04_fourNumbersMinusOne.maxRunTime(2, batteries);
        System.out.println(rlt);
    }

    public long maxRunTime(int n, int[] batteries) {
        if (null == batteries || 0 == batteries.length) {
            return 0L;
        }
        Arrays.sort(batteries);
        //keys 1: 整体需要使用二分答案法 去寻求最有解
        //keys 2： 小于limit 的剩余元素 是否可以匹配剩余电脑电量
        long l = 0;
        long r = 0;
        long ans = 0;
        int len = batteries.length;
        long[] sums = new long[len];
        sums[0] = batteries[0];
        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + batteries[i];
        }
        //不能进行long 转int， 去掉int
        // r = (int) (sums[len - 1] / n);
        r = (sums[len - 1] / n);
        long m = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (ok(batteries, sums, m, n)) {
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return ans;

    }

    /**
     * @param batteries
     * @param sums
     * @param time
     * @param num
     * @return
     */
    private boolean ok(int[] batteries, long[] sums, long time, int num) {

        int l = 0;
        int r = batteries.length - 1;
        int m = 0;
        int left = batteries.length;
        // >= time 最左
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (batteries[m] >= time) {
                left = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        //走完while 循环后 得到了 >= time的最左侧位置
        // 剩余还需要处理的电脑num
        num -= batteries.length - left;

        long rest = left == 0 ? 0 : sums[left - 1];

        return (long) num * time <= rest;
    }
}
