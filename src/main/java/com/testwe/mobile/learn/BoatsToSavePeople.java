package com.testwe.mobile.learn;

import java.util.Arrays;

/**
 * 给定一个正整数arr，代表若干人的体重 ，在给定一个正整数limit，表示所有 船共同拥有的载重量
 * 每艘船最多坐两人，且不能超过载重，想让所有的人同时过河，并且用最好的方法让船尽量少，返回最少船数。
 * https://leetcode.cn/problems/boats-to-save-people/
 */
public class BoatsToSavePeople {
    public static int numRescueBoats(int[] people, int limit) {

        //first sort
        Arrays.sort(people);
        if (people[people.length - 1] > limit) {
            return -1;
        }
        int l = 0;
        int r = people.length - 1;
        int ans = 0;
        int sum = 0;
        while (l <= r) {
            sum = (l == r) ? people[l] : people[l] + people[r];
            if (sum > limit) {
                r--;
            } else {
                l++;
                r--;
            }
            ans++;

        }
        return ans;
    }
}
