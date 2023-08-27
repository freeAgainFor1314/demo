package com.testwe.mobile.learn;

/**
 * 来自bilibili
 * 现在有N条鱼，每条鱼的体积Ai，从左到右排列 ，数组arr给出
 * 每一轮 左边的鱼都会吃掉右边比自己小的第一条鱼，并且每条鱼吃比自己小的鱼的事件是同时进行的
 * 返回多少轮后 鱼的数量稳定
 * 6 6 3 3
 * 第一轮 6 6 3 吃掉右边第一个3
 * 第二轮 6 6 返回2
 */
public class Code05_EatFish {

    public static void main(String[] args) {
        //int[] arr = {6,7,1,3,2,4};
        int[] arr = {6,6,3,3};
        Code05_EatFish code05_eatFish = new Code05_EatFish();
        int rlt = code05_eatFish.eatFish(arr);
        System.out.println(rlt);
    }

    //依据本题的描述 "左边的鱼都会吃掉右边比自己小的第一条鱼" 这条语义 可以知道 需要使用单调栈

    public int eatFish(int[] arr) {
        int ans = 0;
        if (null == arr || 0 == arr.length) {
            return ans;
        }
        int stackSize = 0;
        int N = arr.length;
        //使用一个整形的二维数组 当作栈来存储吃鱼这个动作过程
        int[][] stack = new int[N][2];
        for (int i = N - 1; i >= 0; i--) {
            int curAns = 0;
            while (stackSize > 0 && stack[stackSize - 1][0] < arr[i]) {
                curAns = Math.max(curAns + 1, stack[--stackSize][1]);
            }
            stack[stackSize][0] = arr[i];
            stack[stackSize++][1] = curAns;

            ans = Math.max(curAns, ans);

        }


        return ans;
    }


}
