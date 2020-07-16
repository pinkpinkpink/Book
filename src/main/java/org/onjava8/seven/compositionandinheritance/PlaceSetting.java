package org.onjava8.seven.compositionandinheritance;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 6:51 下午
 */
public class PlaceSetting extends Custom {



    public PlaceSetting(int goods) {
        super(goods+1);
        System.out.println("");
    }

    public static void main(String[] args) {
        PlaceSetting placeSetting = new PlaceSetting(9);
    }

}
