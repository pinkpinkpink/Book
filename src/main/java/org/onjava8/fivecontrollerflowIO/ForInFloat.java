package org.onjava8.fivecontrollerflowIO;

import java.util.Random;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 9:37 下午
 */
public class ForInFloat {
    public static void main(String[] args) {
        Random random = new Random(4789);
        float[] floats = new float[10];
        for(int flower = 0;flower < 100; flower++){
            floats[flower] =random.nextFloat();
            for(float birds : floats){
                System.out.println(birds);
            }
        }
    }
}
