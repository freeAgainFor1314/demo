package com.testwe.mobile.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器 提供两个方法add size
 * 线程1 添加10个元素到容器中
 * 线程2 实施监控元素个数，当元素到5个的时候，给出提醒结束线程
 */
public class T03_NotifyHoldingLock {

    private volatile List<Integer> list = new ArrayList<Integer>();

    public void add(Integer el) {
        list.add(el);
    }

    public int size() {
        return list.size();
    }

    private final Object lock = new Object();

    public static void main(String[] args) {
        T03_NotifyHoldingLock t03_notifyHoldingLock = new T03_NotifyHoldingLock();
        new Thread(() -> {
            synchronized (t03_notifyHoldingLock.lock) {
                if (t03_notifyHoldingLock.list.size() != 5) {
                    try {
                        t03_notifyHoldingLock.lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("元素已超过5个");
                t03_notifyHoldingLock.lock.notify();
            }



        }, "T1").start();
        new Thread(() -> {

            synchronized (t03_notifyHoldingLock.lock){
                for (int i = 1; i < 11; i++) {
                    t03_notifyHoldingLock.list.add(i);
                    if(t03_notifyHoldingLock.list.size()==5){
                        t03_notifyHoldingLock.lock.notify();

                        try {
                            t03_notifyHoldingLock.lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
                t03_notifyHoldingLock.lock.notify();
            }

        }, "T2").start();


    }


}
