package org.onjava8.collection12;

import java.util.LinkedList;
import java.util.List;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:48 下午
 */
public class AppleAndOrange {

    /**
     *
     * collection
     * list 插入顺序
     * set 不重
     * queue 排队规则对象顺复序
     * @param args
     */

    /**
     * map
     *
     * 键值对
     * 用键来查找值
     * ArrayList 数字查找对象
     *
     * map 一个对象查找另一个对象
     *
     * 关联数组
     * 对象和其他对象关联在一起
     *
     * dictionary
     * 一个键值对查找值对象
     *
     * 字典中查找定义
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
//        ArrayList<Apple> apples = new ArrayList<>();
        List<Apple> apples = new LinkedList<>();
        for(int num = 0;num < 10;num++){
            apples.add(new Apple());
        }
        for(Object apple : apples){

        }
    }

}
