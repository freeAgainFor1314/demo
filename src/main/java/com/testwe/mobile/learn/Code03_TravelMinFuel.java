package com.testwe.mobile.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个数组A和B，比如
 * A={0,1,1} B={1,2,3}
 * A[0]=0 B[0]=1,表示0到1有双向道路
 * A[1]=1 B[1]=2,表示1到2有双向道路
 * A[2]=1 B[2]=3,表示1到3有双向道路
 * 输入一定保证所有节点都联通，并且一定没有环，默认办公室节点为0，其他1～N节点上，每个节点上都有一个公民
 * 所有公民都有一辆5座的车，只要走过一条路 就耗费1的汽油
 * 求所有居民去办公室的路上，最少耗费多少汽油
 */
public class Code03_TravelMinFuel {

    //构建一个图，包含cur当前节点的父亲节点
    private List<List<Integer>> graph = new ArrayList<List<Integer>>();

    public static void main(String[] args) {

        List<List<Integer>> graph = new ArrayList<List<Integer>>();

        int[] A = {0, 1, 1};
        int[] B = {1, 2, 3};
        for (int i = 0; i < A.length; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < A.length; i++) {
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }
        int[] size = new int[A.length];
        int rlt = cost(0, -1, graph, size);
        System.out.println(rlt);


    }

    public static int cost(int cur, int father, List<List<Integer>> graph, int[] size) {
        size[cur] = 1;
        int distance = 0;
        //循环cur节点下所有子节点 节点汇聚在下级节点总消耗 + cur就是 cur的结果
        for (int next : graph.get(cur)) {
            if (next != father) {
                int next_distance = cost(next, cur, graph, size);
                distance += next_distance;
                //油量消耗 向上取整
                distance += (size[next] + 4) / 5;
                size[cur] += size[next];
            }
        }
        return distance;
    }
}
