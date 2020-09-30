package org.onjava8.fivecontrollerflowIO;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 9:41 下午
 */
public class ForInString {
    public static void main(String[] args) {
        /**
         * charArray
         */
        for(char fish:"".toCharArray()) {
            System.out.println(fish+"");
        }
    }
}
