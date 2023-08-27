package com.testwe.mobile.learn;

/**
 * https://leetcode.cn/problems/koko-eating-bananas/
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = 0;
        int ans = 0;
        int m = 0;
        for (int i = 0; i < piles.length; i++) {
            r = Math.max(r, piles[i]);
        }
        while (l <= r) {
            m = l + ((r - l) >> 1);
            //满足 尝试r = m-1，不满足尝试l=m+1
            //用中点这个m速度 去吃piles
            //h 警卫回来的时间 <h 代表达标
            if (hours(piles, m) <= h) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;

    }

    //循环数组 计算耗时向上取整 并累加
    private long hours(int[] piles, int speed) {
        long ans = 0;
        int offset = speed - 1;
        for (int pile : piles) {
            ans += (pile + offset) / speed;
        }
        return ans;
    }


}
