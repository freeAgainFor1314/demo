package com.testwe.mobile.thread;

public class JoinThread  extends Thread{

    private static int n = 0;

    public synchronized void incr(){
        n++;
    }


    public static void main(String[] args) {

        JoinThread[] threads = new JoinThread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new JoinThread();
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }

        for (int i = 0; i < 100; i++) {
            try {
                //  100个线程都执行完后继续
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("run finish n= "+JoinThread.n);

    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            incr();

        }
    }
}
