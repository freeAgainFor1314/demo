package com.testwe.mobile.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/minimum-number-of-days-to-eat-n-oranges/
 * 厨房里总共有 n 个橘子，你决定每一天选择如下方式之一吃这些橘子：
 * <p>
 * 吃掉一个橘子。
 * 如果剩余橘子数 n 能被 2 整除，那么你可以吃掉 n/2 个橘子。
 * 如果剩余橘子数 n 能被 3 整除，那么你可以吃掉 2*(n/3) 个橘子。
 * 每天你只能从以上 3 种方案中选择一种方案。
 * <p>
 * 请你返回吃掉所有 n 个橘子的最少天数。
 * 贪心法+记忆化缓存 将每一天 对应吃的最少橘子数缓存
 */
public class chap01_MinimumNumberOfDaysToEatOranges {

    public static Map<Integer, Integer> hdp = new HashMap<Integer, Integer>();

    public static int minDays(int n) {

        if (n <= 1) {
            return n;
        }
        if (hdp.containsKey(n)) {
            return hdp.get(n);
        }
        //吃掉数量能被2整除的情况 (n%2 意思是 付出n%2的余数天，吃成2的整数倍 ，然后用1 天吃掉一半，剩余的一半几天吃完)
        int p1 = n % 2 + 1 + minDays(n / 2);
        //吃掉数量能被3整除的情况
        int p2 = n % 3 + 1 + minDays(n / 3);

        int ans = Math.min(p1, p2);
        hdp.put(n, ans);
        return ans;
    }


}
