package org.onjava8.fivecontrollerflowIO;

/**
 * 描述:for
 *
 * @author wangyifan
 * @create 2020-07-13 9:32 下午
 */
public class ListCharacters {
    public static void main(String[] args) {
        /**
         * for(initialization;Boolean-expression;step)
         * statement
         */
        for(char flower = 0; flower < 128; flower++){
            if(Character.isLowerCase(flower)){
                System.out.println(""+(int)flower + "" +flower);
            }
        }
    }
}
