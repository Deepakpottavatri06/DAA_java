import java.util.*;

public class RearrangeNum {
    public static void main(String[] args) {
        Scanner cin  =  new Scanner(System.in);
        int n =  cin.nextInt();
        int arr []  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        rearrangeNumber(arr,0,n-1);        
        for (int k : arr) {
            System.out.print(k+" ");
        }
        cin.close();
    }
    private static void rearrangeNumber(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            rearrangeNumber(arr, low, mid);
            rearrangeNumber(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    private static void merge(int arr[], int low, int mid, int high) {
        int k = 0;
        int arr1[] = new int[high-low+1];
        int i = low;
        int j = mid + 1;
        while((i<mid+1)&&arr[i]<0){
            arr1[k] = arr[i];
            i++;
            k++;
        }
        while((j<=high)&&(arr[j]<0)){
            arr1[k] = arr[j];
            j++;
            k++;
        }
        while((i<mid+1)){
            arr1[k] = arr[i];
            i++;
            k++;
        }
        while((j<=high)){
            arr1[k] = arr[j];
            j++;
            k++;
        }
        int ind = low;
        for (int t = 0; t < k; t++) {
            arr[ind] = arr1[t];
            ind++;
        }

    }
}
