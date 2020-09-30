package org.onjava8.fourOperator;

/**
 * 描述:内存溢出
 *  两个大的int整数相乘，结果可能超出int型范围
 * @author wangyifan
 * @create 2020-07-13 9:07 下午
 */
public class Overflow {
    public static void main(String[] args) {
        int big = Integer.MAX_VALUE;
        System.out.println(""+big);
        int bigger = big * 4;
        System.out.println(""+bigger);
    }

    // TODO《Thinking in C》
}
