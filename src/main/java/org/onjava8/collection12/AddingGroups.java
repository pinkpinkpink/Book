package org.onjava8.collection12;

import java.util.*;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-22 8:01 上午
 */
public class AddingGroups {
    /**
     *
     */
    static Collection fill(Collection<String> collection){
        collection.add("");
        return collection;
    }
    static Map fill(Map<String,String> map){
        map.put("","");
        return map;
    }
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<>(Arrays.asList(1,2,34));
        Integer[] moreInts = {6,7,8,9};
        Collections.addAll(collection,11,12);
        Collections.addAll(collection,moreInts);
        List<Integer> list = Arrays.asList(14,15,26,23);
        list.set(1,99);
        /**
         *
         */
        List<Snow> snow= Arrays.asList(new Powder());

    }
}
