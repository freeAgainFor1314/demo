package com.testwe.mobile.learn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockCondition {


    public static void main(String[] args) throws InterruptedException {

        char[] nums = "12345678".toCharArray();
        char[] chars = "ABCDEFGH".toCharArray();

        ReentrantLock lock = new ReentrantLock();
        Condition c1 = lock.newCondition();
        Condition c2 = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            try {
                for (char num : nums) {
                    System.out.print(num);
                    try {
                        c2.signal();
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c2.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "T1").start();

        new Thread(()->{
            lock.lock();
            try {
                for (char ch : chars){
                    System.out.print(ch);
                    try {
                        c1.signal();
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                c1.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"T2").start();


    }
}
