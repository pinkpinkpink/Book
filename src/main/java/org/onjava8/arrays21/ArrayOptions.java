package org.onjava8.arrays21;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 12:01 下午
 */
public class ArrayOptions {
    public static void main(String[] args) {
        BerylliumSphere[] a;

        BerylliumSphere[] c = new BerylliumSphere[3];
        for (int i = 0; i < c.length;i++) {
            if(c[i]==null){
                c[i] = new BerylliumSphere();
            }

        }
    }
}
