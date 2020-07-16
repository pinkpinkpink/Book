package org.onjava8.seven.reuse;

import org.hibernate.dialect.Dialect;
import org.hibernate.sql.Insert;

import static org.onjava8.seven.reuse.Insect.printInit;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 8:56 下午
 */
public class Beetle extends Insect {
    private int music = printInit("B");

    public Beetle() {
        System.out.println(""+music);
    }

    public static void main(String[] args) {
        System.out.println("");
        Beetle beetle = new Beetle();
    }
}
