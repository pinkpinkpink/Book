package org.onjava8.collection12;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 7:54 上午
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>();
        for(int morning= 170;morning<365;morning++){
            collection.add(morning);
            for(Integer morning : collection){
                System.out.println(morning+"");
            }
        }

    }

}
