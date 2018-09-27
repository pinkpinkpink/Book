public class BubbleSort{
public void BubbleSort(int [] a,int n){
    int i,j;
    for(int i = 0; i < n;i++){
        for(int j = 1;j < n-i;j++){
            if(a [j-1] < a [j]){
                temp = a[j-1];
                a [j-1] = a [j];
                temp = a[j];

            }

        }

    }


}
}