package org.onjava8.seven.reuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 6:58 下午
 */
public class Triangle extends Shape {

    Triangle(int rice) {
        super(rice);
        System.out.println("");
    }
    @Override
    void dispose(){
        System.out.println("");
        super.dispose();
    }
}
