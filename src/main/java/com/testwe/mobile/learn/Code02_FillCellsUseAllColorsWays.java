package com.testwe.mobile.learn;

/**
 * 给定N，M两个参数 一共有N个格子 每个格子可以涂上一种颜色 ，颜色在M种里面选
 * 当涂满N个格子 并且M种颜色都使用了 叫一种有效方法
 * 求一共有多少种有效方法
 * 1< N,M<=5000
 * 返回结果比较大，请把结果 1000000007 之后返回
 */
public class Code02_FillCellsUseAllColorsWays {

    //根据题意  涂满N个格子，使用了M种颜色 算一种方法
    //考虑 dp[i][j]  i代表格子 j 颜色 需要多少种方法 dp[7][4]
    // case1：如果第7个格子使用的颜色与 涂满前6个格子使用的颜色撞色 dp[6][4] *4 （第7个格子可以使用4种颜色）
    // case2： 如果第7个格子使用的颜色与 涂满前6个格子使用的颜色 不能撞色 dp[6][3] * m-3 说明前6个格子需要使用3种颜色搞定 ，第7个格子使用 m-3种剩余的颜色搞定
    //两种条件互斥 最后状态转移方程 ： dp[i][j] = dp[i-1][j] *j + dp[i-1][j-1]*(m-j+1) 依赖的i-1 j-1 ，i-1 j 位置。大的方向从上到下 从左往右


    public static int mod = 1000000007;

    public static int effectiveCount(int N, int M) {
        // N 个格子 M种颜色
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 1; i < N + 1; i++) {
            dp[i][1] = M;
        }
        for (int i = 2; i < N + 1; i++) {
            for (int j = 2; j < M + 1; j++) {
                dp[i][j] = (int) (((long) dp[i - 1][j] * j) % mod);
                dp[i][j] = (int) ((((long) dp[i - 1][j - 1] * (M - j + 1)) + dp[i][j]) % mod);
            }
        }
        return dp[N][M];
    }

}
