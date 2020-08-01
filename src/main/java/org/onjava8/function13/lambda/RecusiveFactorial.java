package org.onjava8.function13.lambda;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 11:06 上午
 */
public class RecusiveFactorial {
    static IntCall fact;
    public static void main(String[] args){
        fact = n -> n == 0 ? 1: n * fact.call(n-1);
        /**
         * 参数
         *
         * ->可视为产出
         *
         * -> 内容都是方法体
         *
         */
        for(int i = 0;i <= 10;i++){

        }
    }
}
