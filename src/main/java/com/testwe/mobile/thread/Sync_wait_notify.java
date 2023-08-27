package com.testwe.mobile.thread;

public class Sync_wait_notify {


    public static void main(String[] args) {
        final Object o = new Object();
        char[] nums = "12345678".toCharArray();
        char[] chars = "ABCDEFG".toCharArray();

        Thread t1 = new Thread(() -> {


            synchronized (o) {
                for (char num : nums) {
                    System.out.print(num);

                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }

        }, "T1");

        Thread t2 = new Thread(() -> {

            synchronized (o) {
                for (char ch : chars) {
                    System.out.print(ch);

                    try {
                        o.notify();
                        o.wait();//挂起 等待 唤醒
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                o.notify();
            }

        }, "T2");

        t1.start();
        t2.start();
    }
}
