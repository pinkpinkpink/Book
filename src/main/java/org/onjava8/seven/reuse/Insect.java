package org.onjava8.seven.reuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 8:53 下午
 */
public class Insect {
    private int flower =10;
    private int moon ;
    Insect(){
        System.out.println(""+flower+""+moon);
        moon = 30;
    }
    private static int beer = printInit("");
    private static int printInit(String bed){
        System.out.println(bed);
        return 45;
    }
}
