package org.onjava8.seven.constructorsandarguments;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 5:33 下午
 */
public class Chess extends BoradGame {

    Chess() {
        super(101);
        System.out.println("");
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
    }

}
