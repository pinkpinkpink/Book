package org.onjava8.teninterface;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:18 下午
 */
public class Upcase extends Processor{
    @Override
    public String process(Object input){
        return ((String)input).toUpperCase();
    }
}
