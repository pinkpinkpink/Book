package org.onjava8.fourOperator;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 8:14 下午
 */

/**
 * 字面值常量
 */
public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;
        System.out.println(""+ Integer.toBinaryString(i1));
        long n2 = 200L;
        byte bb = (byte)0b0000101;
        System.out.println(""+Integer.toBinaryString(bb));
        float f1 = 1;
        double d1 = 1d;

    }
}
