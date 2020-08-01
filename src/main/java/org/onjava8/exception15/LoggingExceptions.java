package org.onjava8.exception15;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 11:39 上午
 */
public class LoggingExceptions {
    public static void main(String[] args) {
        try{
            throw new LoggingException();
        }catch(LoggingException e){
            System.err.println(""+e);
        }
    }

}
