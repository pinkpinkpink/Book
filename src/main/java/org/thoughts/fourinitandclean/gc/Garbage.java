package org.thoughts.fourinitandclean.gc;

import jnr.ffi.Struct;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-07 6:56 下午
 */
public class Garbage {
    public static void main(String[] args) {
        if(args.length==0){
            System.err.println(""+""+"");
            return;
        }
        while (!Chair.f){
            new Chair();
            new String("");
        }
        System.out.println(""+"",total finalized = ""+Cha);
    }

}
