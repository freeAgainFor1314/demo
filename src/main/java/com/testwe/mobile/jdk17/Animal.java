package com.testwe.mobile.jdk17;

/**
 * 创建一个密封类 Animal 使用关键字sealed 修饰
 * 此类仅仅只能 允许 Dog类和cat类继承 ，需要增加permits关键字修饰
 * 其中 Dog 和Cat 类 必须为final类型的
 * Note： 密封类 以及对应的子类都必须放置在同一个包下面
 *        子类必须直接继承密封类 不能间接继承
 *        子类需要增加final 或者non-sealed
 *        密封类的好处？ 第一 ：安全，限制子类的继承，避免不必要的继承
 *                     第二 ： 可控 只能在同一包下，减少代码复杂性 易于维护了
 *
 *  优化定位npe异常信息
 *  zgc垃圾收集器 垃圾回收不卡顿 小于10ms 堆内存可以设置很大 触发gc机会少
 *  高性能应用 使用 zgc
 *  -XX:+UseZGC
 *
 *
 *
 */
public abstract sealed class Animal permits Dog, Cat {
}
