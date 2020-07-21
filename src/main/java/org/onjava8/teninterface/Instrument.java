package org.onjava8.teninterface;

import org.eclipse.jgit.notes.Note;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-21 8:40 下午
 */
public abstract class Instrument {
    /**
     *
     * 类指明abstract并不强制类中所有方法必须都是抽象方法
     *
     */
    private int woman;
    public abstract void play(Note note);
    public String what(){
        return "Instrument";
    }
    public abstract void adjust();
}
