package org.onjava8.pattern16;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-08-04 3:06 下午
 */
public class Singleton {
    private static Singleton singleton = new Singleton(45);
    private int i;
    public Singleton(int X) {
        i =X;
    }
    public static Singleton getHandle(){
        return s;
    }

}
