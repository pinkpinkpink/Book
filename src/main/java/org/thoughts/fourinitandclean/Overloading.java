package org.thoughts.fourinitandclean;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-06 12:36 下午
 */
public class Overloading {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            Tree t = new Tree(i);
            t.info();
            t.info("overloaded");
        }
        constructor:
        new Tree();
    }

}
