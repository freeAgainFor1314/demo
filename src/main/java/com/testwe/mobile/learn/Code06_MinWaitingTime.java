package com.testwe.mobile.learn;

import java.util.PriorityQueue;

/**
 * 谷歌；给定一个数组arr，长度为n 表示n个服务员 ，每个人服务一个人的时间
 * 给定一个正数m，表示有m个人等位，如果你是刚来的人，请问你需要等多久
 * 假设：m远远大于n，比如n<=1000 m<=10^9
 * 两种方法 ： 1。堆(优先级队列)  2。二分答案法  使用的前提条件： 一 满足单调性 随着时间增加 服务的人数增加 二 给定时间计算服务的人数的计算 简单
 */
public class Code06_MinWaitingTime {

    public static void main(String[] args) {
        int[] n = {3, 4, 1, 7, 12};
        int m = 1000;
        int rlt = Code06_MinWaitingTime.waitTime(n, m);
        System.out.println(rlt);
        int rlt2 = Code06_MinWaitingTime.waitTime2(n, m);
        System.out.println(rlt2);
    }

    //method1：
    public static int waitTime(int[] n, int m) {
        //构造堆 根据服务的起始日期排序，使用int数组保存起始日期和工作效率
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));
        for (int i = 0; i < n.length; i++) {
            //起始工作时间，以及工作效率
            priorityQueue.add(new int[]{0, n[i]});
        }
        for (int i = 0; i < m; i++) {
            int[] cur = priorityQueue.poll();
            cur[0] += cur[1];
            priorityQueue.add(cur);
        }
        return priorityQueue.peek()[0];
    }

    //method2 :
    public static int waitTime2(int[] n, int m) {
        int l = Integer.MAX_VALUE;
        //循环找到数组最小值（最高效的医生服务的效率）
        for (int i = 0; i < n.length; i++) {
            l = Math.min(l, n[i]);
        }
        int r = l * m;
        int mid = 0;
        int near = 0;

        while (l <= r) {
            mid = l + ((r - l) >> 1);
            //计算mid时间能服务的人是多少是否>m
            int cover = 0;
            for (int i = 0; i < n.length; i++) {
                //mid时间 除以每个医生效率 +1 就是mid时间内每一个医生能服务的人
                cover += (mid / n[i]) + 1;
            }
            //能够服务的人 大于m+1了，先记录答案，往左找
            if (cover >= m + 1) {
                near = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return near;

    }


}
