package org.onjava8.seven.reuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 7:04 下午
 */
public class CADSystem extends Shape {
    private Circle circle;
    private Triangle triangle;
    /**
     * Array limit
     */
    private Line[] lines = new Line[23333];

    public CADSystem(int rice) {
        super(rice + 1);
        for (int number = 0; number < lines.length; number++) {
            lines[number] = new Line[number,number*number];

            circle = new Circle(1);
            triangle = new Triangle(1);
            System.out.println("");
        }
    }
    @Override
    public void dispose(){
        System.out.println("");
        circle.dispose();
        triangle.dispose();
        for(int high = lines.length -1;high >= 0;high--){
            lines[high].dispose();
        }
    }

    public static void main(String[] args) {
        CADSystem cadSystem = new CADSystem(34);
        try{

        } finally {
            cadSystem.dispose();
        }
    }

}
