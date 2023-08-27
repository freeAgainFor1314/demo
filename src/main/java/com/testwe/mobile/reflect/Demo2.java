package com.testwe.mobile.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo2 extends Demo {

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        demo2.doSth();
    }


    public void doSth() {
        //这里mock拿到demo的class具体获取使用其他方式
        Demo2 demo2 = new Demo2();
        Class<? extends Demo2> aClass = demo2.getClass();

        System.out.println(Demo.class.isAssignableFrom(aClass));
        Demo demo = (Demo)demo2;

        try {
            aClass.getSuperclass().getDeclaredMethod("getRlt").invoke(demo2);
            Field[] fields = aClass.getSuperclass().getDeclaredFields();
            for (Field field : fields) {
                if(field.getName().equals("demo3")){

                    Demo3 demo3 = (Demo3)field.get("demo3");
                    field.setAccessible(true);
                    Method method =  field.getType().getDeclaredMethods()[0];
                    method.setAccessible(true);
                    Object obj = method.invoke(field.getType().getConstructors()[0].newInstance());
                    field.set(this, obj);
                }

            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    private static String upperHeadChar(String in) {
        String head = in.substring(0, 1);
        return head.toUpperCase() + in.substring(1);
    }
}
