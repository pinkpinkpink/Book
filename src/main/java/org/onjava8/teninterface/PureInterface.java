package org.onjava8.teninterface;

/**
 * public 接口名和文件名相同
 *
 *
 */
public interface PureInterface {
    /**
     *
     * interface 产生一个完全抽象的类，没有提供任何实现
     *
     * 描述类应该像什么，做什么，不描述怎么做
     *
     * 只能决定方法名、参数列表、返回类型
     *
     * 无法确定方法体
     *
     * 接口只提供形式，没有实现
     *
     * @return
     */
    int woman();
    void man();
    double girl();
}
