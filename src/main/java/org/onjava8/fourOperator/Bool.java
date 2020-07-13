package org.onjava8.fourOperator;

import java.util.Random;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 8:06 下午
 */
public class Bool {
    public static void main(String[] args) {
        Random random = new Random(34);
        int i = random.nextInt(100);
        int j = random.nextInt(100);
        System.out.println(""+i);
        System.out.println(""+j);
        System.out.println(""+(i > j));
        System.out.println(""+(i < j));
        System.out.println(""+(i == j));
        System.out.println(""+(i != j));
        /**
         * && AND
         */
        System.out.println(""+ ((i < 10) && (j < 10)));

        /**
         * || OR
         */
        System.out.println(""+ ((i < 10) || (j > 10)));
    }
}
