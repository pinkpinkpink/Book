package org.onjava8.pattern16;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-08-10 9:43 上午
 */
public class OCBox extends Canvas implements Observer {


        Observer notifier;
        int x, y;
        Color cColor = newColor();
        static final Color[] colors = {
                Color.BLACK,
                Color.blue,
        };

        static final Color newColor () {
            return colors[
                    (int) (Math.random() * colors.length)];
        }
        OCBox( int x, int y, Observable notifier){
            this.x = x;
        }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     */
    @Override
    public void update(Observable o, Object arg) {

    }
}

