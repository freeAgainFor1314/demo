package com.testwe.mobile.thread;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 写一个固定容器，拥有put 和get 方法 ，以及getcount方法，能够支持2个生产者线程10个消费者线程的阻塞调用
 */
public class Code03_MyContainer02<T> {

    private LinkedList<T> list = new LinkedList<>();
    private static int MAX = 10;
    private int count = 0;
    private Lock lock = new ReentrantLock();

    private Condition product = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T el) {
        try {
            lock.lock();
            while (list.size() == Code03_MyContainer02.MAX) {
                try {
                    product.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count++;
            list.add(el);
            consumer.signalAll();
        } finally {
            lock.unlock();
        }

    }

    public T get() {

        T t;
        try {
            lock.lock();
            t = null;
            while (list.size() == 0) {
                try {
                    consumer.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            t = list.removeFirst();
            count--;
            product.signalAll();
        } finally {
           lock.unlock();
        }
        return t;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        //product
        Code03_MyContainer02<String> myContainer = new Code03_MyContainer02<String>();
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
