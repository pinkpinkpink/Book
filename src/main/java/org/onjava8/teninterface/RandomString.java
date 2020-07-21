package org.onjava8.teninterface;

import java.util.Random;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:25 下午
 */
public class RandomString implements Runnable {
    /**
     * 相同的接口可以有多个实现
     */

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }

    private static Random random  = new Random(23);
    public RandomString(int count){
        this.count = count;
    }
}
