package com.testwe.mobile.thread;

import java.util.LinkedList;

/**
 * 写一个固定容器，拥有put 和get 方法 ，以及getcount方法，能够支持2个生产者线程10个消费者线程的阻塞调用
 */
public class Code03_MyContainer<T> {

    private LinkedList<T> list = new LinkedList<>();
    private static int MAX = 10;
    private int count = 0;

    public synchronized void put(T el) {
        while (list.size() == Code03_MyContainer.MAX) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        list.add(el);
        this.notifyAll();
    }

    public synchronized T get() {
        T t = null;
        while (list.size() == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        t = list.removeFirst();
        count--;
        this.notifyAll();
        return t;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        //product
        Code03_MyContainer<String> myContainer = new Code03_MyContainer<String>();
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    myContainer.put(Thread.currentThread().getName() + "-" + j);
                }
            }, "product-T" + i).start();
        }
        //consumer
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(myContainer.get());
                }

            }, "consumer-T" + i).start();
        }
    }
}
