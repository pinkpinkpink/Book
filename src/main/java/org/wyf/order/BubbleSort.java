package org.wyf.order;

public class BubbleSort{
public static void BubbleSort(int[] a, int n){
    int i= 0,j =0;
    for(int i = 0; i < n;i++){
        for(int j = 1;j < n-i;j++){
            if(a [j-1] < a [j]){
                int temp = a[j - 1];
                a [j-1] = a [j];
                temp = a[j];

            }

        }

    }


}
}
