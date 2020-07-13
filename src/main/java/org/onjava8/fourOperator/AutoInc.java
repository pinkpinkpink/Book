package org.onjava8.fourOperator;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 7:56 下午
 */
public class AutoInc {
    public static void main(String[] args) {
        int i = 1;
        System.out.println(""+i);
        /**
         * 前递增
         */
        System.out.println(""+ ++i);
        /**
         * 后递增
         */
        System.out.println(""+ i++);

        /**
         * 前递减
         */
        System.out.println(""+ --i);
        /**
         * 后递减
         */
        System.out.println(""+ i--);
    }

}
