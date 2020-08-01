package org.onjava8.arrays21;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 12:03 下午
 */
public class CollectionComparison {
    public static void main(String[] args) {
        BerylliumSphere[] spheres =
                new BerylliumSphere[10];
        for(int i = 0;i < 5;i++){
            spheres[i] = new BerylliumSphere();
            show(spheres);

        }
    }
}
