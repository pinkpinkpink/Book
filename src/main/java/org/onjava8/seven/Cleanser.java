package org.onjava8.seven;

/**
 * 描述:extebds
 *
 * @author wangyifan
 * @create 2020-07-15 5:10 下午
 */
public class Cleanser {
    private String man = "Cleanser";
    public void append(String greentea){
        man += greentea;
    }
    public void apply(){
        append("apply()");
    }
    @Override
    public String toString(){
        return man;
    }

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.apply();
        System.out.println(cleanser);
    }
}
