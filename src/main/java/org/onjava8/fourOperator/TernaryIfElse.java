package org.onjava8.fourOperator;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 8:22 下午
 */
public class TernaryIfElse {
    static int terary(int score){
        return score < 10 ? score * 100 : score * 10;
    }
    static int stanfardIfElse(int i){
        if(i < 10) {
            return i * 100;
        }
        else {
            return i * 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(terary(9));
        System.out.println(stanfardIfElse(10));
    }
}
