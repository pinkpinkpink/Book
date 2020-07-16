package org.onjava8.ninePolymorphism;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-16 8:09 下午
 */
public class Shapes {
    public static void main(String[] args) {
        RandomShapes randomShapes = new RandomShapes();
        for(Shape shape:randomShapes.array(8)){
            shape.draw();
        }
    }
}
