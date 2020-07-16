package org.onjava8.seven.reuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 7:00 下午
 */
public class Line extends Shape {
    private int start,end;
    Line(int start,int end){
        super(start);
        this.start = start;
        this.end = end;
        System.out.println(""+start+""+end);
    }
    @Override
            void dispose(){
        System.out.println(""+start+""+end);
        super.dispose();
    }
}
