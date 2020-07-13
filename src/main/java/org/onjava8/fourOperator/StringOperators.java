package org.onjava8.fourOperator;

import scala.collection.$colon$plus;
import scala.collection.immutable.$colon$colon;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 8:35 下午
 */
public class StringOperators {
    public static void main(String[] args) {
        int age = 10, high = 20,weight = 20;
        String name = "age,high.weight";
        System.out.println(name+age+high+weight);
        /**
         * age转化为字符串
         */
        System.out.println(age+ "" +name);
        name += "(summed) = ";
        System.out.println(name+(age+high+weight));
        /**
         * Integer.toString()
         */
        System.out.println(""+age);
        /**
         * 赋值 =
         * 等价性 ==
         */

    }
}
