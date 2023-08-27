package com.testwe.mobile.learn;

/**
 * zijie
 * 一开始在0位置，每一次都可以向左或者向右跳
 * 第i次向左或者向右跳严格的i步，请问从0到x位置，至少跳几次可以到达
 * leetcode https://leetcode.cn/problems/reach-a-number
 * 754
 */
public class Code01_JumpToTargets {

    public static void main(String[] args) {
        Code01_JumpToTargets code01_jumpToTargets = new Code01_JumpToTargets();
        int i = code01_jumpToTargets.reachNumber(2);
        System.out.println(i);
    }

    public int reachNumber(int target) {

        //0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 target=13
        //第1步 0-1 1
        //第2步 1-3 2
        //第3步 3-6 3
        //第4步 6-10 4
        //第5步 10-15 5
        //走完第5步超过了13，1   +2        +3    +4 + 5=15
        //                -1  -2        -3    -4  -5
        //                2   4        6      8   10
        // 到达的数字 15-2=13  15-4=11  15-6=9
        // 又 15-13 =2 2是个偶数（第一步的时候） 则需要往左走1步）
        // 如果 15-14 =1 1是个奇数，只能继续往前奔，第6步 15-21 6 ，第7步 21-28 7 ，此时28-14=14 是个偶数

        // 检验 第一步 0 -1 第二步 -1 0 1 第3步 1 4 第四步 4 8  第5步 8 13
        //第6步 15-21 6  第7步 往左走7步  21- 14

        if (target == 0) {
            return target;
        }

        target = Math.abs(target);
        long l = 0;
        long r = target;
        long m = 0;
        long near = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (sum(m) >= target) {
                near = m;
                r = m - 1;
            } else {
                l = m + 1;
            }

        }
        if (sum(near) == target) {
            return (int) near;
        }
        if (((sum(near) - target) & 1) == 1) {
            near++;
        }
        if (((sum(near) - target) & 1) == 1) {
            near++;
        }
        return (int) near;
    }

    private long sum(long n) {
        return ((n * (n + 1)) / 2);
    }
}
