
import java.util.*;
public class FixedPoint {
    private static int fixedPoint(int arr[]){
        int lowInd = -1;
        int low = 0;
        int high = arr.length-1;
        while (low<high) {
            int mid = (low+high)/2;
            if(arr[mid]==mid){
                lowInd = mid;
                high = mid;
            }
            else if(arr[mid]>mid){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return (arr[low]==low)? low : lowInd;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        int ind = fixedPoint(arr);
        System.out.println("Lowest index "+ind);
        cin.close();
    }
}
