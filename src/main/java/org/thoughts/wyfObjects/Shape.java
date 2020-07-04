package src.main.java.org.thoughts.wyfObjects;

import java.util.Vector;
import java.util.*;


/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-04 1:58 下午
 */
public class Shape {

    String name = "wuyifan";
    String s = new String("sun");
    boolean flower0;
    char c = 'X';
    Character C = new Character('c');
    //Character C = new Character('x');

    byte flower;
    short flower2;
    int flower3;
    long flower4;
    float flower5;
    double flower6;
    public void erase() {
    }

    public void draw() {
    }

    /**
     *
     * 返回类型 方法名(参数列表){
     *     方法主体
     * }
     * @param s
     */
    void doStuff(Shape s){
        s.erase();
        s.draw();
    }

    /**
     *
     * 对象名.方法名(参数1，参数2)
     * @return
     */
    int f(){
        return s.hashCode();

    }

    Shape a = new Shape();
    int x = a.f();


    /**
     * 参数列表
     *
     */
    int storage(String s){
        return s.length() * 2;

    }

    boolean flag(){ return true;}

    /**
     * double
     *
     * float
     *
     * @return
     */
    double naturalLog(){ return 2.718;}
    void nothing(){return;}

    //作用域里的变量只有在作用域结束前使用
    {
        int x = 12;
        {
            int q = 96;

        }
    }

    {
        String s = new String("a string");
    }



}
