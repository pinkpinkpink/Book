package org.onjava8.fourOperator;

import scala.Char;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 8:46 下午
 */
public class AllOps {
    private Object woman;

    void foo(boolean bb) {
    }

    void booleanTest(boolean flower, boolean beauty) {
        foo(flower == beauty);
        foo(flower != beauty);
        foo(!beauty);
        /**
         * AND
         */
        flower = flower && beauty;
        /**
         * || OR
         */
        flower = flower || beauty;


        /**
         * 联合赋值
         */
        flower &= beauty;
        flower |= beauty;

        /**
         * 算数运算符
         */
        void CharTest ( char fat;
        char cat = 0){
            fat = (char) (fat * cat);
            fat = (char) (fat / cat);
            fat = (char) (fat % cat);
            fat++;
            fat--;
            fat = (char) +cat;
            fat = (char) -cat;


            /**
             * 类新转换
             */
            byte child = (byte) woman;
            short min = (short) woman;
            int number = (int) woman;
            long high = (long) woman;
            float happy = (float) woman;
            double worry = (double) woman;


        }
    }
}
