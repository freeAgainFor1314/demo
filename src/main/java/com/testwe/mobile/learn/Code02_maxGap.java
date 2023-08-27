package com.testwe.mobile.learn;

/**
 * 排序后数组的最大差值
 * 题目 给定一个无需的数组nums，返回 数组在排序后，相邻元素之间最大的差值
 * 如果数据元素个数小于2则返回0
 * 必须便携一个在线性时间内运行并使用线性额外空间的算法
 * 测试连接 https://leetcode.cn/problems/maximum-gap
 */
public class Code02_maxGap {

    public static void main(String[] args) {
        int[] nums = {3,6,9,1};
        int i = Code02_maxGap.maximumGap(nums);
        System.out.println(i);
    }


    public static int maximumGap(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if (min == max) return 0;
        //i桶 是否有数字
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];
        //哪个桶
        int bids = 0;
        for (int i = 0; i < len; i++) {
            bids = bucket(nums[i], len, min, max);
            maxs[bids] = hasNum[bids] ? Math.max(nums[i], maxs[bids]) : nums[i];
            mins[bids] = hasNum[bids] ? Math.min(nums[i], mins[bids]) : nums[i];
            hasNum[bids] = true;
        }
        int res = 0;
        //后桶最小 - 前桶最大
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            if(hasNum[i]){
                res = Math.max(res,mins[i]-lastMax);
                lastMax = maxs[i];
            }
        }
        return res;

    }


    public static int bucket(int num, int len, int min, int max) {
        //分成几份
        double range = (double) (max - min) / (double) len;
        //num减去min算距离
        double distance = (double) (num - min);
        //返回桶的编号 向下取整
        return (int) (distance / range);
    }


}
