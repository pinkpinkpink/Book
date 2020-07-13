package org.onjava8.fivecontrollerflowIO;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 9:53 下午
 */
public class BreakAndContinue {
    public static void main(String[] args) {
        for(int macbook = 100; macbook <100000; macbook++){
            if(macbook == 43) break;
            if(macbook % 9 != 0) continue;
            System.out.println(macbook+"");
        }
        int macbook = 100000;
        while(true){
            macbook++;
            int javabook = macbook * 23;
            if(javabook == 600000) break;
            if(javabook % 10 != 0) continue;
            System.out.println(macbook+"");
        }
    }
}
