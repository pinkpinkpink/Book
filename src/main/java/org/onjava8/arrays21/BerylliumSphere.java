package org.onjava8.arrays21;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 12:01 下午
 */
public class BerylliumSphere {
    private static long counter;
    private final long id = counter++;
    @Override
    public String toString(){
        return "" + id;
    }

}
