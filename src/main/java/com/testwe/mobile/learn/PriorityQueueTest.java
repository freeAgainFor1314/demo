package com.testwe.mobile.learn;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        int[] arr = {0,2,1,4,3,9,5,8,6,7};
        System.out.println("======");
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<Integer>(arr.length,(a,b)->(a-b));
        for (int i = 0; i < arr.length; i++) {
            priorityBlockingQueue.offer(arr[i]);
        }
        System.out.println(priorityBlockingQueue);
        priorityBlockingQueue.remove(0);
        System.out.println(priorityBlockingQueue);









    }
}
