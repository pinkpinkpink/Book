package org.onjava8.seven.constructorsandarguments;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 5:37 下午
 */
public class DerivedSpaceShip extends SpaceShipControls {
    private String name;
    public DerivedSpaceShip(String name){
        this.name = name;
    }
    @Override
    public String toString(){
        return name;
    }

    public static void main(String[] args) {
        DerivedSpaceShip derivedSpaceShip = new DerivedSpaceShip("");
        derivedSpaceShip.down(101);
    }
}
