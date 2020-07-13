package org.onjava8.fivecontrollerflowIO;

/**
 * 描述:迭代语句
 *
 * @author wangyifan
 * @create 2020-07-13 9:28 下午
 */
public class WhileTest {
    static boolean condition(){
        boolean result = Math.random() < 0.99;
        System.out.println(result+"");
        return result;
    }

    public static void main(String[] args) {
        while(condition()) {
            System.out.println("while");
        }
    }
}
