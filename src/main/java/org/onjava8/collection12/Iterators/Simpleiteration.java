package org.onjava8.collection12.Iterators;

import org.onjava8.collection12.list.Pet;

import java.util.Iterator;
import java.util.List;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 8:31 上午
 */
public class Simpleiteration {
    /**
     * 集合中元素数量
     * @param args
     */
    public static void main(String[] args) {
        List<Pet> pets = Pet.list();
        Iterator<Pet> iterator = Pet.iterator();
        while(iterator.hasNext()){
            Pet pet = iterator.next();
        }
        for(Pet p : pets){
        }
        iterator.next();
        iterator.remove();
    }
}
