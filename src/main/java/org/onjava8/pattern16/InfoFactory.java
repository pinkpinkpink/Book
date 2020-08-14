package org.onjava8.pattern16;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-08-11 7:20 下午
 */
public class InfoFactory {
    /**
     * Factory将创建对象所需的基本信息传递给它
     *
     * 然后返回并等于引用作为返回值出现
     *
     *
     */

    int type;
    //another type:
    static final int MAX_NUM = 4;
    double data;
    InfoFactory(int typeNum,double data){
        type = typeNum % MAX_NUM;
        data =data;

    }

}
