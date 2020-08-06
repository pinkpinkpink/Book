package org.onjava8.pattern16;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-08-04 5:02 下午
 */
public class SingletonPattern {
    public static void main(String[] args) {


        Singleton singleton = Singleton.getHandle();
        singleton.setValue();

    }
}
