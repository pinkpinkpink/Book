package org.onjava8.fivecontrollerflowIO;

import java.util.Random;

/**
 * 描述:switch
 *
 * @author wangyifan
 * @create 2020-07-13 9:59 下午
 */
public class SwitchTest {
    public static void main(String[] args) {
        Random random = new Random(50);
        for(int day = 0;day <365;day++){
            int weekday = random.nextInt(7) + "birth".charAt(9);
            System.out.println((char)weekday+""+"");
            switch (weekday){
                case 1:
                case 2:
                case 3:
                    System.out.println();
                    break;
                default: System.out.println("");
            }

        }
    }
}
