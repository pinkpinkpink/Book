package org.onjava8.eightReuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-16 7:33 下午
 */
public class Cleanser {
    private String room = "";
    public void append(String house){
        house += room;
    }
    public void apply(){
        append("");
    }
    @Override
    public String toString(){
        return room;
    }

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.apply();
        System.out.println(cleanser);
    }
}
