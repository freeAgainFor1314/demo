package com.testwe.mobile.jdk17;


public class SwitchLearn {

    //去掉break 返回值 直接给到alias
    public static void main(String[] args) {
        switchPracOne();
        switchPracTwo();
        String s = switchPracThree(null);
        System.out.println(s);
    }

    private static void switchPracOne() {
        var name = "xushu";
        String alias = switch (name) {
            case "zhouyu2" -> "gongjing2";
            case "xushu", "xushu3" -> "xushu";
            case "zhouyu3" -> "zhouyu3";
            default -> "weizhi";
        };
        System.out.println("alias: " + alias);
    }

    /**
     * case 条件中增加业务代码方式
     */
    private static void switchPracTwo() {
        var name = "xushu";
        String country = switch (name) {
            case "zhouyu", "xushu" -> {
                System.out.println("sanguo");
                yield "sanguo";
            }
            case "chengjisihan", "hubilie" -> {
                System.out.println("yuanchao");
                yield "yuanchao";
            }
            case "hanxin", "liubang" -> {
                System.out.println("hanchao");
                yield "hanchao";
            }
            default -> {
                System.out.println("weizhi");
                yield "weizhi";
            }

        };
        System.out.println("guojia: " + country);
    }

    /**
     * 支持类型判断方式
     */
    private static String switchPracThree(Object o) {
        return switch (o) {
            case null -> "o is null!";
            case Integer i -> String.format("Integer i :%s", i);
            case Long l -> String.format("Long l :%s", l);
            case Double d -> String.format("Double d :%s", d);
            case String s -> String.format("String s :%s", s);
            default -> o.toString();

        };
    }

}
