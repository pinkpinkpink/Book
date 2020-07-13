package org.onjava8.fivecontrollerflowIO;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-13 9:22 下午
 */
public class IfElse {
    static int result = 0;
    static void test(int testval,int target){
        if(testval > target) {
            result = +1;
        }
        else if(testval < target) {
                result = -1;
            }
        else
        {
            result = 0;
        }
    }

    public static void main(String[] args) {
        test(10,6);
        System.out.println(result);
    }
}
