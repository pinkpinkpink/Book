package org.onjava8.fourOperator;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 12:05 下午
 */


public class Operator {

    /**
     *
     * +
     * -
     * *
     * /
     * = 赋值
     * ==
     * !=
     *
     *
     * +
     * += ? 自增
     */

    public static void main(String[] args) {
        Tank t1 = new Tank();
        Tank t2 = new Tank();
        t1.level = 9;
        t2.level = 12;
        System.out.println(""+t1.level+""+t2.level);
        t1 = t2;
        t1.level=  24;
        System.out.println(""+t1.level+""+t2.level);
    }
}
