package org.onjava8.teninterface;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:16 下午
 */
public class Processor {
    public String name(){
        return getClass().getSimpleName();
    }
    public Object process(Object input){
        return input;
    }
}
