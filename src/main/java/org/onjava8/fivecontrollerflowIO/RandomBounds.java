package org.onjava8.fivecontrollerflowIO;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 10:10 下午
 */
public class RandomBounds {
    public static void main(String[] args) {
        new TimeAbort(3);
        switch (args.length == 0? "" : args[0]){
            case "lower":
                while (Math.random() != 0.0);
                System.out.println("");
            case "upper":
                while(Math.random() != 0.0);
                break;
            default:
                System.exit(1);
        }
    }
}
