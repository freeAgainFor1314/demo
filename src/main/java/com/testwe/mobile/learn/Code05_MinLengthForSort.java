package com.testwe.mobile.learn;

/**
 * 给一个数组nums 找出一个连续子数组 对这个子数组进行排序使得整个数组变的生序
 * 请找出符合题意的最短子数组并输出它的长度
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray
 * 581
 */
public class Code05_MinLengthForSort {

    public static void main(String[] args) {
        //int[] nums = {2, 6, 4, 8, 10, 9, 15};
        //int[] nums = {1,2,3,4};
        //int[] nums = {1};
        int[] nums = {1, 3, 5, 4, 2, 7, 8, 9};
        Code05_MinLengthForSort code05_minLengthForSort = new Code05_MinLengthForSort();
        int result = code05_minLengthForSort.findUnsortedSubarray(nums);
        System.out.println(result);
    }


    public int findUnsortedSubarray(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        int N = nums.length;
        int max = nums[0];
        int right = 0;
        for (int i = 1; i < N; i++) {
            if (max > nums[i]) {
                right = i;
            }
            max = Math.max(nums[i], max);
        }

        int min = nums[N - 1];
        int left = N;
        for (int i = N - 1; i >= 0; i--) {
            if (min < nums[i]) {
                left = i;
            }
            min = Math.min(min, nums[i]);
        }
        return Math.max(0, right - left + 1);

    }


}
