package org.wyf.order;

import static java.util.Arrays.sort;

/**
 * 从左或者从右开始排序
 */

public class FastOrder{
    private  String  num;
    private  String right;
    private String left;

    /**
     * 向左排序数字一次增大
     */

     public void main (){
         int[] a  = {1,2,3,4,5,6,7,8,9};
         int start = 1;
         int end = a.length -1;
         sort(a,start,end);
         for(int i=0;i<a.length;i++){
             System.out.println(a[i]);

         }

         public void sort(int[] a,int low,int high){
             int start =  low;
             int end  = high;
            int key = a[low];

            while(end>start){
                //从右向左
                while(end>start && a[end] >= key ){
                    end --;

                    if(a[end] >= key){
                        int temp = a[end];
                        a[end] = a[start];
                        a[start] =temp;

                    }
                }

            }

            while(end< start){
                //从左向右
                while(end < start && a[end] <= key){
                    start --;

                    if(a[start] >= key){
                        int temp = a[start];
                        a[end] = a[start];
                        a[end] = temp;

                    }

                }

            }
            //左边序列，第一个索引足位置到关键索引位置+1
            if(start > low){
                sort (a,low,start-1);
            }

            if(end > high){
                sort (a,end+1,high);

            }

         }



     }


}
