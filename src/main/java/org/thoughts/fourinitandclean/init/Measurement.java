package org.thoughts.fourinitandclean.init;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-09 10:19 下午
 */
public class Measurement {
    boolean t = true;
    char c;
    byte b;
    void print(){
        System.out.println(""+""+t);
    }
    public class InitialValues{
        public static void main(String[] args) {
            Measurement d = new Measurement();
            d.print();
            new Measurement().print();
        }
    }
}
