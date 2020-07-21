package org.onjava8.collection12;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:46 下午
 */
public class Apple {
    private static long counter;
    private final long id = counter++;
    public long id(){
        return id;
    }

}
