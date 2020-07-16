package org.onjava8.seven.hidebaseclass;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 7:26 下午
 */
public class Hide {
    public static void main(String[] args) {
        Bart bart = new Bart();
        bart.doh(1);
        bart.doh('d');
        bart.doh(1.0f);
        bart.doh(new MaxHouse());
    }
}
