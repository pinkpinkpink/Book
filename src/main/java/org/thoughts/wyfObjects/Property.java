package src.main.java.org.thoughts.wyfObjects;

import java.util.*;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-04 3:02 下午
 */
public class Property {
    public static void main(String[] args) {
        System.out.println(new Date());
        Properties p = new System.getProperties();
        p.list(System.out);
        System.out.println("Memory");
        Runtime rt = Runtime.getRuntime();
        System.out.println("Total Memory =" + rt.totalMemory() +
                "Free Memory" + rt.freeMemory());

        //TODO Exception in main
        try {
            Thread.currentThread().sleep(5);

        }catch(InterruptedException e)
        {
        }


    }


}
