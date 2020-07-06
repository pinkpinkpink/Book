package org.thoughts.fourinitandclean;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-06 12:45 下午
 */
public class PrimitiveOverloading {
    static void prt(String s){
        System.out.println(s);
    }
    void f1(char x){
        prt("f1(char)");
    }
    void testChar(){
        char x = 'X';
        prt("char argument:");
    }

    public static void main(String[] args) {
        PrimitiveOverloading p = new PrimitiveOverloading();
        p.testChar();
    }

}
