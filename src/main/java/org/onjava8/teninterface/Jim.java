package org.onjava8.teninterface;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 9:10 下午
 */
public class Jim implements Jim1,Jim2{
    @Override
    public void jim(){
        Jim2.super.Jim();
    }

    public static void main(String[] args) {
        new Jim().jim();
    }
}
