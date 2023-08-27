package com.testwe.mobile.learn;

public class CoinsWays {

    public static void main(String[] args) {
        int[] arr = {1, 5, 10, 100};
        int f = f(arr, 0, 50);
        System.out.println(f);
    }

    private static int f(int[] arr, int idx, int rest) {
        if (idx == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhangshu = 0; arr[idx] * zhangshu <= rest; zhangshu++) {

            ways += f(arr, idx + 1, rest - arr[idx] * zhangshu);
        }

        return ways;
    }

}
