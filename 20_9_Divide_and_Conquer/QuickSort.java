import java.util.*;
public class QuickSort {
    private static int hoarsePartition(int [] arr, int low , int high){
        int pivotIndex = low;
        int i  = low-1;
        int j = high+1;
        while (true) {
            do{
                i++;
            }while(arr[i]<arr[pivotIndex]);

            do{
                j--;
            }while(arr[j]>arr[pivotIndex]);

            if(i>=j) return j;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }

    }
    private static int partitionHigh(int [] arr, int low , int high){
        int pivotIndex = high;
        int k = low;
        int temp  = 0;
        for (int i = low; i < high; i++) {
            if(arr[i]<arr[pivotIndex]){
                temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                k++;
            }
        }
        temp = arr[k];
        arr[k] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        pivotIndex = k;
        return pivotIndex;
    }
    private static int partitionLow(int [] arr,int low, int high){
        int pivotIndex = low;
        int k = high;
        int temp = 0;
        for (int i = high; i >= low; i--) {
            if(arr[i]>arr[pivotIndex]){
                
                temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                k--;
            }
        }
        temp = arr[k];
        arr[k] = arr[pivotIndex];
        arr[pivotIndex] = temp;
        pivotIndex = k;
        return pivotIndex;
    } 
    private static void quickSort(int [] arr,int low,int high){
        if(low<high){
            int pivotIndex = hoarsePartition(arr, low, high);
            quickSort(arr, low, pivotIndex-1);
            quickSort(arr, pivotIndex+1, high);
        }
    }
    public static void main(String[] args) {
     Scanner cin = new Scanner(System.in);
    //  int arr [] = {5,2,8,3,1,6,4};
    
    int n = cin.nextInt();
    int arr [] = new int[n];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = cin.nextInt();
    }
     quickSort(arr, 0,arr.length-1 );
     System.out.println(Arrays.toString(arr));   
    }
}
