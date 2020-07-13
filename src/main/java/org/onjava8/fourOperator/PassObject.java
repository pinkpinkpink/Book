package org.onjava8.fourOperator;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 2:16 下午
 */
public class PassObject {
    static void f(Letter y){
        y.c = 'z';
    }

    public static void main(String[] args) {
        Letter x  = new Letter();
        x.c = 'a';
        System.out.println(""+x.c);
        f(x);
        System.out.println(""+x.c);
    }
}
