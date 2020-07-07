package org.thoughts.fourinitandclean.constructors;

import com.sun.tools.javac.comp.Flow;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-07 3:54 下午
 */
public class Flower {
    private int petalCount = 0;
    private String s = new String("null");
    Flower(int petals){
        petalCount = petals;
        System.out.println(""+petalCount);
    }
    Flower(String ss){
        System.out.println(""+ss);
        s=ss;
    }
    Flower(String s,int petals){
        this(petals);
        System.out.println("");
    }
    Flower(){
        this("",22);
        System.out.println("");
    }
    void print(){
        System.out.println("petalCount="+petalCount+"s="+s);
    }

    public static void main(String[] args) {
        Flower x = new Flower();
        x.print();
    }

}
