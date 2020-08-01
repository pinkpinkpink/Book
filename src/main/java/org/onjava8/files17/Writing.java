package org.onjava8.files17;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 11:50 上午
 */
public class Writing {
    static Random random = new Random(46);
    static final int SIZE = 10000;

    public static void main(String[] args) {
        byte[] bytes = new byte[SIZE];
        random.nextBytes(bytes);
        Files.write(Paths.get(""),bytes);
        System.out.println(""+Files.size(Paths.get()));

        List<String> lines = Files.readAllLines(
                Paths.get("");
                Files.write(Paths.get(""),lines);
        );

    }
}
