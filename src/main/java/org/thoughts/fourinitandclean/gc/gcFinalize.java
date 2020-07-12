package org.thoughts.fourinitandclean.gc;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-07 6:49 下午
 */
public class gcFinalize {
    /**
     * gc只跟内存有关
     */
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    finalized = 0;
    int i;
    Chair(){
        i = ++created;
        if(created ==22)
            System.out.println("");
    }
    protected void finalized(){
        if(!gcrun){
            gcrun = true;
            System.out.println(""+created+"");
        }
        if(i==22){
            System.out.println(""+"");
            f= true;
        }
        finalized++;
        if(finalize>=created)
            System.out.println(""+finalized+"");
    }


}
