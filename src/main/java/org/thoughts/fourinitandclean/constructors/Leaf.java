package org.thoughts.fourinitandclean.constructors;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-07 3:51 下午
 */
public class Leaf {
    private int i =0;
    Leaf increment(){
        i++;
        return this;

    }
    void print(){
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        //TODO
        x.increment().increment().increment().print();
    }
}
