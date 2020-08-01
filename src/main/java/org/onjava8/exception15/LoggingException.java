package org.onjava8.exception15;

import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 11:37 上午
 */
public class LoggingException extends Exception {
    private static Logger logger =
            Logger.getLogger("");
    LoggingException(){
        StringWriter trace = new StringWriter();
    }
}
