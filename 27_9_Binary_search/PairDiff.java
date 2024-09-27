import java.util.*;

public class PairDiff {
    private static int binarySearch(int [] arr,int req,int low, int high){
        if(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==req){
                return mid;
            }
            else if(arr[mid]>req){
                return binarySearch(arr, req, low, mid-1);    
            }
            else{
                return binarySearch(arr, req, mid+1, high);
            }
        }
        return -1;
    }
    private static void pairDiff(int [] arr, int k){
        for (int i = 0; i < arr.length; i++) {
            int second = arr[i]+k;
            
            if(binarySearch(arr, second, 0, arr.length-1)!=-1){
                System.out.print(arr[i]+" "+second);
                System.out.println(); 
            }
        }
    }
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        int n = cin.nextInt();
        int arr [] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        int k = cin.nextInt();
        pairDiff(arr,k);
        cin.close();

    }
}
