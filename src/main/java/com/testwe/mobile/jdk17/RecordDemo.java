package com.testwe.mobile.jdk17;

public class RecordDemo {
    public static void main(String[] args) {
        UserRecord zhangsan1 = new UserRecord(1L, "zhangsan");
        UserRecord zhangsan2 = new UserRecord(1L, "zhangsan");
        System.out.println(zhangsan2.equals(zhangsan1));
    }
}
