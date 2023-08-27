package com.testwe.mobile.learn;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1
 * https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/
 */
public class Code01_SplitNumberTimeMax {

    public static int mod = 1000000007;

    public static int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int rest = 0;
        /**
         * rest 意思： 多长的块 去处理3
         * n == 9 12
         * n %3 ==0  rest=n 3的 (n/3)次方
         * n==10
         * n%3 ==1 rest =4 3的（n/3）次方
         * n == 5 8 11
         * n%3==2 rest =2 3的（n/3）次方
         *
         * pre 前置因子
         */
        rest = n % 3 == 0 ? n : ((n % 3 == 1) ? n - 4 : n - 2);
        int pre = n % 3 == 0 ? 1 : (n % 3 == 1 ? 4 : 2);
        int ans = (int) ((pre * pow( 3,rest / 3)) % mod);
        return ans;

    }

    /**
     * a的多少次方 怎么计算最快  --- 快速幂
     *
     * @param x
     * @param n
     * @return
     */
    public static long pow(long x, int n) {
        long result = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                result = (result * x) % mod;
            }
            x = (x * x) % mod;
            n >>= 1;
        }
        return result;
    }
}
