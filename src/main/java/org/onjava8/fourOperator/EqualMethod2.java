package org.onjava8.fourOperator;

import javax.validation.Valid;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 8:04 下午
 */
public class EqualMethod2 {
    public static void main(String[] args) {
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i = v2.i = 100;
        System.out.println(v1.equals(v2));
    }
}
