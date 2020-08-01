package org.onjava8.collection12.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 9:11 上午
 */
public class Statistics {
    public static void main(String[] args) {
        Random random = new Random(3);
        Map<Integer,Integer> map = new HashMap<>();
        for(int man = 100;man < 1000;man++){
            int river = random.nextInt(10);
            Integer frea = map.get(river);
            map.put(random,frea == null ? 1: frea +1);
        }
        System.out.println(map);
    }
}
