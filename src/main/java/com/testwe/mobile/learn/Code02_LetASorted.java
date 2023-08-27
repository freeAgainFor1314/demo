package com.testwe.mobile.learn;

/**
 * 来自华为
 * 给定两个数组AB 长度都是N
 * A[i]不可以和数组中的任意元素交换 只能选择和b[i]交换
 * 你的目的是让A有序，返回你能否做到
 */
public class Code02_LetASorted {

    public static void main(String[] args) {
        int[] A = {3, 2, 1, 5, 6,7};
        int[] B = {0, 6, 4, 3, 1,5};
        Code02_LetASorted code02_letASorted = new Code02_LetASorted();
        boolean rlt = code02_letASorted.canSort(A, B);
        System.out.println(rlt);
        boolean rlt2 = code02_letASorted.canSort2(A, B);
        System.out.println(rlt2);

    }

    //rescursive violence

    public boolean canSort(int[] A, int[] B) {
        if (null == A || A.length < 2) {
            return true;
        }
        return process(A, B, 1, true) || process(A, B, 1, false);
    }

    public boolean canSort2(int[] A, int[] B) {
        if (null == A || A.length < 2) {
            return true;
        }
        return process2(A, B);
    }

    private boolean process(int[] A, int[] B, int index, boolean canSwitch) {

        //base case
        if (index == A.length) {
            return true;
        }
        boolean p1 = false;
        boolean p2 = false;
        //不交换
        int pre = canSwitch ? B[index - 1] : A[index - 1];
        p1 = pre > A[index] ? false : process(A, B, index + 1, false);
        p2 = pre > B[index] ? false : process(A, B, index + 1, true);
        return p1 | p2;
    }

    private boolean process2(int[] A, int[] B) {
        int N = A.length;
        boolean[][] dp = new boolean[N + 1][2];
        for (int i = 0; i < 2; i++) {
            dp[N][i] = true;
        }
        for (int index = N - 1; index >= 1; index--) {
            for (int canSwitch = 0; canSwitch < 2; canSwitch++) {
                int pre = canSwitch == 0 ? B[index - 1] : A[index - 1];
                boolean p1 = pre > A[index] ? false : dp[index + 1][canSwitch];
                boolean p2 = pre > B[index] ? false : dp[index + 1][canSwitch];
                dp[index][canSwitch] = p1 | p2;
            }
        }
        return dp[1][1] | dp[1][0];
    }


}
