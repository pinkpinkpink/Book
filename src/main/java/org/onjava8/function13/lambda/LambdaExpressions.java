package org.onjava8.function13.lambda;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 10:56 上午
 */
public class LambdaExpressions {

    /**
     *
     * Lambda 最小可能函数定义
     *
     * Lambda 产生函数，不是类
     *
     * JVM上一切都是一个类
     *
     */
    static Body body = h -> h + "";
    static Body body2 = (h) -> h + "";
    static Description description = () -> "";
    static Multi mutli = (h,n) -> h +n;
    static Description moreLines = ()->{
        return "";
    };

    /**
     * 基本语法
     *
     *
     * 1 参数
     *
     * 2 接着->,视为产出
     *
     * 3 ->之后是方法体
     *
     * @param args
     */

    public static void main(String[] args) {

    }
}
