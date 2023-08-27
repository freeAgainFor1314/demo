package com.testwe.mobile.learn;

public class ExtendTest {

    static {
        System.out.println("-----静态代码块被执行了ExtendTest-----");
    }

    public ExtendTest() {
        System.out.println("ExtendTest con");
    }

    public static void main(String[] args) {

        new B();

    }
}
class B extends ExtendTest{
    static {
        System.out.println("-----B-----");
    }

    public B() {
        System.out.println("con B");
    }
}


