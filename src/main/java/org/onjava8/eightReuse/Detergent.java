package org.onjava8.eightReuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-16 7:37 下午
 */
public class Detergent extends Cleanser {
    @Override
    public void apply(){
        append("");
        super.apply();
    }
    public void foam(){
        append("");
    }

    public static void main(String[] args) {
        Detergent detergent = new Detergent();
        detergent.apply();
        detergent.foam();
        System.out.println(detergent);
        Cleanser.main(args);
    }
}
