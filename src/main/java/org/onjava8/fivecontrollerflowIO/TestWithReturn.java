package org.onjava8.fivecontrollerflowIO;

/**
 * 描述:return
 *
 * @author wangyifan
 * @create 2020-07-13 9:49 下午
 */
public class TestWithReturn {
    static int test(int testval,int target){
        if(testval > target) {
            return +1;
        }
        if(testval < target) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(test(10,5));
    }

}
