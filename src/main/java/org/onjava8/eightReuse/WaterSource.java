package org.onjava8.eightReuse;

/**
 * 描述:
 *
 * @author wangyifan
 * @create 2020-07-15 8:45 上午
 */
public class WaterSource {
    private String source;
    WaterSource(){
        System.out.println("");
        source = "";
    }
    @Override
    public String toString(){
        return source;
    }
    public static class SpringklerSystem{
        private String airvalue,watervalue;
        private WaterSource source =new WaterSource();
        private int flower;
        private float picture;
        @Override
        public String toString(){
            return
                    "" + airvalue + "" + watervalue+"" + source;
        }

        public static void main(String[] args) {
            SpringklerSystem springklerSystem = new SpringklerSystem();
            System.out.println(springklerSystem);
        }

    }
}
