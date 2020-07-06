package org.thoughts.fourinitandclean;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-06 12:39 下午
 */
public class OverloadingOrder {
    /**
     *
     * @param s
     * @param i
     */
    static void print(String s,int i){
        System.out.println("String:" + s
        + ",int: " +i);

    }

    /**
     *
     * @param i
     * @param s
     */
    static void print(int i,String s){
        System.out.println("int :" +i
        + ",String:"+ s);
    }

    /**
     * 两个print()方法完全一致的参数，但是顺序不同
     * @param args
     */
    public static void main(String[] args) {
        print("String first",11);
        print(99,"Int first");
    }
}
