package org.onjava8.seven.learnfinal;

import java.util.Random;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 7:31 下午
 */
public class FinalData {
    private static Random random = new Random();
    private String id;
    public FinalData(String id){
        this.id = id;
    }
    public final int INT_4 = random.nextInt(20);
    private final int[]  arr = {1,2,3,4,5};
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    @Override
    public String toString(){
        return id + ""+INT_4+""+arr+"";

    }

    public static void main(String[] args) {
        FinalData finalData = new FinalData("");
        /**
         *
         */
        finalData.v2.moon++;
        finalData.v1 = new Value(9);
        for(int moon = 0;moon < finalData.arr.length;moon++){
            finalData.arr[moon]++;
        }
        System.out.println(finalData);
        System.out.println("");
        FinalData finalData1 = new FinalData("");
        System.out.println(finalData);
        System.out.println(finalData1);


    }
}
