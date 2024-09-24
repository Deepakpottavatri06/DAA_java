
import java.util.*;
public class MajorityEle {
    public static void main(String[] args) {
        int arr [] = {2,2,2,1,1};
        // TC : O(n)
        // SC : O(n)
        // Map<Integer,Integer> m  = new HashMap<>();
        // for(int i : arr){
        //     m.put(i,m.getOrDefault(i, 0)+1);
        // }
        // int size = arr.length/2;
        // for(Map.Entry<Integer,Integer> entry : m.entrySet()){
        //     if(entry.getValue()>size){
        //         System.out.println(entry.getKey());
        //     }
        // }

        //premise : majority element is  always present
        // TC: O(n)
        // SC : O(1)
        // int candidate = -1;
        // int count = 0;
        // for(int i : arr){
        //     if(count == 0){
        //         candidate = i;
        //     }
        //     count += (i==candidate)? 1 : -1;
        // }
        // System.out.println(candidate);


        // Divide and conquer method 
        System.out.println(majorityElement(arr,0,arr.length-1));
    }
    private static int count(int arr[],int low,int high, int target){
        int count  = 0;
        for(int i  = low ; i <= high ; i++){
            count += (arr[i]==target)? 1 : 0;
        }
        return count;
    }
    private static int majorityElement(int arr[] , int low , int high){
        if(low==high){
            return arr[low];
        }
        int mid = (low+high)/2;
        int left = majorityElement(arr, low, mid);
        int right  =  majorityElement(arr, mid+1, high);
        if(left == right ){
            return left;
        }
        int leftCount = count(arr,low,high,left);
        int rightCount = count(arr, low, high, right);
        return (leftCount > rightCount) ? left : right;
    }
}
