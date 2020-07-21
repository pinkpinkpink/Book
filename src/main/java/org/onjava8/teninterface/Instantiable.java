package org.onjava8.teninterface;

import org.onjava8.Unistantiable;

import java.util.HashMap;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 8:34 下午
 */
public abstract class Instantiable extends Unistantiable {
    @Override
    void f() {

    }

    public static void main(String[] args) {
        Unistantiable unistantiable = new Unistantiable();
    }
}
