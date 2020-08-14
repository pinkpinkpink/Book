package org.onjava8.teninterface;

import org.onjava8.arrays21.BerylliumSphere;

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
    static void show(BerylliumSphere[] msg){

    }

}
