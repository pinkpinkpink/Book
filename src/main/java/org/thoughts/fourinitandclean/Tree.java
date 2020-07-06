package org.thoughts.fourinitandclean;


/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-06 12:30 下午
 */
public class Tree {
    int height;
    Tree(){
        prt("");
        height=0;
    }
    Tree(int i){
        prt(""+i+"feet tall");
        height=i;
    }
    void info(){
        prt(""+height+"");
    }
    void info(String s){
        prt(s+""+height+"");
    }
    static void prt(String s){
        System.out.println(s);

    }
}
