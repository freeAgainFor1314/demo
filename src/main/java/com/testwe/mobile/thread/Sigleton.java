package com.testwe.mobile.thread;

public class Sigleton {

    //避免多线程访问可见性
    private volatile static Sigleton sigleton = null;
    public static Sigleton getInstance(){
        if(null == sigleton){
            synchronized (Sigleton.class){
                if(null == sigleton){
                    sigleton = new Sigleton();
                }
            }
        }
        return sigleton;
    }

}
