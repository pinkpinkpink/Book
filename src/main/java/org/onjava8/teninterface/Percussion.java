package org.onjava8.teninterface;

import org.eclipse.jgit.notes.Note;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 8:46 下午
 */
public class Percussion extends Instrument {
    @Override
    public void play(Note note){

    }

    @Override
    public void adjust() {

    }

    public static void main(String[] args) {
        Instrument[] orchestra = {
                new Wind();

        };
    }
}
