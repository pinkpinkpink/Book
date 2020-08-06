package org.onjava8.pattern16;

import java.util.Observable;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-08-04 5:06 下午
 */
public class BoxObservable extends Observable {
    @Override
    public void notifyObservers(Object object){
        setChanged();
        super.notifyObservers(object);

    }

}
