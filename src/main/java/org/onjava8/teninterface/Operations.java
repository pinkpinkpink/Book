package org.onjava8.teninterface;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:11 下午
 */
public interface Operations {
    void execute();
    static void runOps(Operations... ops){
        for(Operations op:ops){
            op.execute();

        }
    }
    static void show(String msg){

    }

}
