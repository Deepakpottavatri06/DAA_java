import java.util.*;

/*
 You are given an m x n matrix of integers where:
	*Each row is sorted in non-decreasing order.
	*The first integer of each row is greater than the last integer of the previous row.

Given an integer target, your task is to determine if the target exists in the matrix. If it does, return the row and column indices where it is found. If it does not exist in the matrix, return -1.

You must implement the solution with a time complexity of O(log(m * n)) using a binary search approach.

Input Format:
-------------
Line-1: Two integers m and n, representing the number of rows and columns in the matrix.
Line-2 to m: The next m lines each contain n integers, representing the matrix elements.
Line m+1: The last line contains the integer k, the target value to search for in the matrix.

Output Format:
---------------
If the target exists, print the row and column indices of the target in the matrix.
If the target does not exist, print -1.

Constraints:
-------------
1 ≤ m, n ≤ 1000
-10^4 ≤ matrix[i][j], k ≤ 10^4

Sample Input-1:
---------------
3 4
1 3 5 7
10 11 16 20
23 30 34 60
3

Sample Output-1:
----------------
0 1

Explanation:
The target 3 is found in row 0 and column 1.


Sample Input-2:
---------------
3 4
1 3 5 7
10 11 16 20
23 30 34 60
13

Sample Output-2:
----------------
-1

Explanation:
The target 13 does not exist in the matrix, so the output is -1.

 */
public class SearchSortedMatrix {
    private static int binarySearchVertical(int [][] arr , int target){
        int low = 0;
        int high = arr.length-1;
        int col =arr[0].length-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(arr[mid][col]==target){
                return mid;
            }
            if(arr[mid][col]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        System.out.println("row : "+low);
        if (low < arr.length && arr[low][col] >= target) {
        return low;
        }
        return -1;
    }
    private  static int[] binarySearch(int [][] arr, int target){
        int row = binarySearchVertical(arr, target);
        int result [] = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(row==-1){
            return result;
        }   
        int low = 0;
        int high = arr[0].length-1;
        while (low<=high) {
            int mid = (low+high)/2;
            System.out.println(low + " " + mid + " " +high);
            if(arr[row][mid]==target){
                 result[0] = row;
                 result[1] = mid;
                 return result;
            }
            else if(arr[row][mid]<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;

    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int row = cin.nextInt();
        int col = cin.nextInt();
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = cin.nextInt();
            }
        }
        int target = cin.nextInt();
        // System.out.println(binarySearch(arr,target));
        int res [] = binarySearch(arr, target);
        if(res[1]==-1){
            System.out.println(res[1]);
        }
        else{
            System.out.println(res[0]+" "+res[1]);
        }
        cin.close();
    }
}
