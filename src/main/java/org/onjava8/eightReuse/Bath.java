package org.onjava8.eightReuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-16 7:24 下午
 */
public class Bath {
    private String sunflower1 = "",
    sunflower2 = "",
    sunflower3,sunflower4;
    private Soap castille;
    private int index;
    private float toy;
    public Bath(){
        System.out.println("");
        sunflower3 = "";
        toy = 3.14f;
        castille = new Soap();
    }
    {
        index =58;
    }
    @Override
    public String toString(){
        if(sunflower4 == null) {
            sunflower4 = "joy";
            return
                    "" + sunflower1 + "\n"
                            + "" + sunflower2 + "\n"
                            + "" + sunflower3 + "\n"
                            + "" + sunflower4 + "\n"
                            + "" + castille;
        }
    }

    public static void main(String[] args) {
        Bath bath = new Bath();
        System.out.println(bath);
    }
}
