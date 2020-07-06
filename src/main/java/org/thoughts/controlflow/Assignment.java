package org.thoughts.controlflow;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-04 3:22 下午
 */
public class Assignment {
    public static void main(String[] args) {
        Number n1 = new Number();
        Number n2 = new Number();
        n1.i =9;
        n2.i = 10;
        System.out.println("1:n1.i"+n1.i+
                ",n2.i:"+n2.i);
        n1 = n2;
    }

}
