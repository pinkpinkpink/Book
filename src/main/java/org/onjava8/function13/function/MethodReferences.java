package org.onjava8.function13.function;

import org.onjava8.function13.lambda.Description;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 11:14 上午
 */
public class MethodReferences {
    String about;
    void Description(String desc){
        about = desc;
    }
    void help(String msg){

    }

    public static void main(String[] args) {
        Describe describe = new Describe();
        Callable callable = describe::show;
        /**
         * 方法引用
         *
         * 类名或对象名
         *
         * 后面跟::
         */
        callable.call("");

        callable = new Description()::help;
    }
}
