import java.util.*;

public class MergeSort {
    private static void merge(int arr[], int low, int mid, int high) {

        int k = high - low + 1;
        int arr1[] = new int[k];
        int i = low;
        int j = mid + 1;
        k = 0;
        while ((i < mid + 1) && (j <= high)) {
            if (arr[i] > arr[j]) {
                arr1[k] = arr[j];
                j++;

            } else {
                arr1[k] = arr[i];
                i++;
            }
            k++;
        }
        while ((i < (mid + 1))) {
            arr1[k] = arr[i];
            i++;
            k++;
        }
        while (j <= high) {
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

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (high + low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i< n ; i++){
            arr[i] = cin.nextInt();
        }
        mergeSort(arr, 0, n-1);
        for(int i: arr){
            System.out.println(i+" ");
        }
    }
}
