package org.onjava8.pattern16;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-08-10 9:33 上午
 */
public class BoxObserver extends Frame {
    Observable notifier = new BoxObservable();
    public BoxObserver(int grid){
        setTitle("");
        setLayout(new GridBagLayout(grid,grid));
        for (int x = 0;x < grid;x++) {
            for(int y = 0;y <grid;y++) {
                add(new OCBox(x,y.notifier));
            }
        }

    }

    public static void main(String[] args) {
        int grid = 8;
        if(args.length >0){
            grid = Integer.parseInt(args[0]);
            Frame frame = new BoxObserver(grid);
            frame.setSize(400,500);
            frame.setVisible(true);
            frame.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e){
                    System.exit(0);

                }
            });

        }
    }

}
