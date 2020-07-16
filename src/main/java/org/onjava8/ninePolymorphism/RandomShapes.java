package org.onjava8.ninePolymorphism;

import java.util.Random;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-16 8:03 下午
 */
public class RandomShapes {
    private Random random = new Random(45);
    public Shape get(){
        switch (random.nextInt(2)){
            case 0 : return new Circle();
            case 1 :return new Square();

        }
    }
    public Shape[] array(int flower){
        Shape[] shapes = new Shape[flower];
        for(int woman = 0;woman < shapes.length;woman++){
            shapes[woman] = get();
        }
        return shapes;
    }
}
