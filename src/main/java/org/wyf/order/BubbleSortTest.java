public class BubbleSortTest{
    public void main(String[] args){
        int arr = {2,1,5,3,6,7,8,9,0};
        
        BubbleSort.BubbleSort(arr,arr.length);
        for(int i : arr){
            System.out.print(+",");
        }
        
    }
}