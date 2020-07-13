package org.onjava8.fourOperator;

import java.util.Random;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 2:19 下午
 */
public class MathOps {
    public static void main(String[] args) {
        Random random = new Random(57);
        int i,j,k;
        j = random.nextInt(100) + 1;

        System.out.println(""+j);
        k = random.nextInt(100) +1;
        i = j+k;


        float u,v,w;
        v = random.nextFloat();
        w = random.nextFloat();
        u = v+w;
        u += v;
        u -= v;
        u *= v;
        u /= v;
        System.out.println(""+u);

    }

}
