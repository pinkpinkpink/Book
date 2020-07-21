package org.onjava8.teninterface;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:00 下午
 */
public class AnImplementation implements Anterface {

    /**
     * 实现接口
     */
    @Override
    public void firstMethod() {

    }

    public static void main(String[] args) {
        Anterface anterface = new AnImplementation();
        anterface.firstMethod();
    }

}
