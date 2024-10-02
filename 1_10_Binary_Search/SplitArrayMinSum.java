
/*
 You are given an integer array nums and an integer k. 
Your task is to split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.

A subarray is a contiguous part of the array. You need to return the minimized largest sum of the split.

Input Format:
--------------
Line-1: Integers representing the elements of the array nums, separated by commas.
Line-2: An integer k, representing the number of subarrays to split nums into.

Output Format:
---------------
Line-1: Print a single integer representing the minimized largest sum after splitting the array into k subarrays.

Constraints:
-------------
1 ≤ nums.length ≤ 1000
0 ≤ nums[i] ≤ 10^6
1 ≤ k ≤ min(50, nums.length)

Sample Input-1:
---------------
7,2,5,10,8
2

Sample Output-1:
----------------
18

Explanation:
There are four ways to split nums into two subarrays. The best way is to split it into [7, 2, 5] and [10, 8], where the largest sum among the two subarrays is only 18.


Sample Input-2:
---------------
1,2,3,4,5
2

Sample Output-2:
----------------
9

Explanation:
The best way to split nums into two subarrays is [1, 2, 3] and [4, 5], where the largest sum is 9.
 */

 import java.util.*;
public class SplitArrayMinSum {

    private static int binarySearch(int [] arr,int low, int high,int k){
        while (low<high) {
            int mid = (low+high)/2;
            // System.out.println(low+" "+mid+" "+high);
            int subArrays = findSubArr(arr, 0, arr.length-1, mid);
            // System.out.println(" subarr "+subArrays);
            if(subArrays<=k){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }
    private static int findSubArr(int [] arr, int low, int high,int target){
        int sum = 0;
        int count = 1;
        for (int i = low; i < high+1; i++) {
            sum+=arr[i];
            if(sum>target){
                // System.out.println("the sum :"+ (sum-arr[i]));
                sum=arr[i];
                count++;
            }
        }
        
        // System.out.println(count);
        return count;
    }
    
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String inp [] = cin.nextLine().split(",");
        int arr[] = new int[inp.length];
        for (int i = 0; i < inp.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        int k = cin.nextInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int sum = Arrays.stream(arr).sum();
        System.out.println(binarySearch(arr,max,sum,k));
        cin.close();
        
    }
}
