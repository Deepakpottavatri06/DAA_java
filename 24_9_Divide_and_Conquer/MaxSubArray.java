/*
 You are playing a game. There are N boxes placed in a row (0-indexed), 
every box has some points. You need to play the game with the following rules:
	- Initially your score is  '0' points.
	- Suppose the box has P points in it.
	  if p>0 you will gain P points, if p<0 you will loose P points.
	- You are allowed to choose any number of consecutive boxes, atleast 1 box.
	
You are given the points in the N boxes as points[]. 
Your target is to maximize your score, and return the highest score possible. 

Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, points[].

Output Format:
--------------
An integer, print the highest score.


Sample Input-1:
---------------
9
-3 1 -2 4 -2 2 3 -5 4

Sample Output-1:
----------------
7

Explanation:
------------
By selecting consecutive boxes are [4,-2,2,3] has the highest score is 7


Sample Input-2:
---------------
2
1 -2

Sample Output-2:
----------------
1

Explanation:
------------
By picking the box is [1] has the highest score is 7
 */

import java.util.*;
public class MaxSubArray {
    // pending
    private static int maxSubArray(int [] arr, int low , int high){
        if(low<high){
            int mid = (low+high)/2;

            int leftMaxScore = maxSubArray(arr,low,mid);
            int rightMaxScore = maxSubArray(arr,mid+1,high);
            int acrossMiddleScore = findAcrossSum(arr,low,mid,high);

          return Math.max(Math.max(rightMaxScore, leftMaxScore), acrossMiddleScore);
        }
        return arr[low];
    }
    private static int findAcrossSum(int [] arr, int low , int mid , int high){
        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >=low; i--) {
          sum+=arr[i];
          if(sum>leftMax){
            leftMax = sum;
          }
        }
        int rightMax = Integer.MIN_VALUE;
        sum = 0;
        for (int i = mid+1; i <= high; i++) {
            sum+=arr[i];
            if(sum>rightMax){
              rightMax=sum;
            }
        }

        return leftMax+rightMax;
    }
  public static void main(String[] args) {
      Scanner cin = new Scanner(System.in);
      int n = cin.nextInt();
      int [] arr = new int[n];
      for (int i = 0; i < n; i++) {
          arr[i] = cin.nextInt();
      }
      int maxSum = maxSubArray(arr, 0, n-1);
      System.out.println(maxSum);
      cin.close();
  }   
}
