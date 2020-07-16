package org.onjava8.seven.reuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 6:57 下午
 */
public class Circle extends Shape {

    Circle(int rice) {
        super(rice);
        System.out.println("");
    }
    @Override
    void dispose(){
        System.out.println("");
        super.dispose();
    }
}
