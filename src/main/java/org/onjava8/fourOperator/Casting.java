package org.onjava8.fourOperator;

/**
 * 描述:类型转换
 *
 * @author wangyifan
 * @create 2020-07-13 8:42 下午
 */
public class Casting {
    public static void main(String[] args) {
        int money = 50000;
        long high = (long)money;
        high = money;
        long voice = (long)50000;
        voice = 50000;
        /**
         * 类型收缩
         */
        money = (int)voice;

    }

}
