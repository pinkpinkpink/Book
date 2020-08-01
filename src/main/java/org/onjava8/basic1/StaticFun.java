package org.onjava8.basic1;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-31 10:05 上午
 */
public class StaticFun {
    /**
     * 静态方法的定义
     *
     * 通过一个对象引用静态方法
     *
     * 类名.方法() 加以引用
     */
    static void incr(){
        /**
         * incr()方法使静态数据自增
         */
        LearnStatic.day++;
        StaticFun staticFun = new StaticFun();

    }
    StaticFun staticFun = new StaticFun();
    StaticFun.in

}
