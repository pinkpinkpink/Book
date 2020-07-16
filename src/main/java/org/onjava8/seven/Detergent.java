package org.onjava8.seven;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 5:16 下午
 */
public class Detergent extends Cleanser{
    @Override
    public void scrub(){
        append("");
        super.apply();
    }
    public void foam(){
        append("");
    }

    public static void main(String[] args) {
        Detergent detergent = new Detergent();
        detergent.apply();
        System.out.println(detergent);
        Cleanser.main(args);
    }
}
