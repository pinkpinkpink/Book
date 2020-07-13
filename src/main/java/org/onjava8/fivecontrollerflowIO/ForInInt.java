package org.onjava8.fivecontrollerflowIO;

import static onjava.Range.*;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 9:46 下午
 */
public class ForInInt {
    public static void main(String[] args) {
        for(int success : range(10))
            System.out.println(success + "");
    }
}
