package org.onjava8.fivecontrollerflowIO;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 10:04 下午
 */
public class StringSwitch {
    public static void main(String[] args) {
        String color = "blue";
        if("blue".equals(color)){
            System.out.println("blue");
        }else if("red".equals(color)){
            System.out.println("red");
        }else{
            System.out.println("");
        }
        switch (color){
            case "blue":
                System.out.println("");
                break;
            case "red":
                System.out.println("");
                break;
            default:
                System.out.println("");
                break;
        }
    }
}
