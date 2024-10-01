import java.util.*;
/*
 Koko loves to eat bananas. There are n piles of bananas, where the i-th pile has piles[i] bananas. 
The guards have gone, and Koko can decide her own banana eating speed k (bananas per hour). 
Each hour, she chooses any pile of bananas and eats k bananas from that pile. 
If the pile has less than k bananas, she eats all of them instead and does not eat any more bananas during that hour.

Koko likes to finish eating all the bananas within h hours. 

Your task is to find the minimum integer value of k such that she can eat all the bananas within h hours.

Input Format:
-------------
Line-1: Two integers n and h, where n is the number of piles and h is the maximum number of hours Koko has to eat all the bananas.
Line-2: n space-separated integers, representing the number of bananas in each pile.

Output Format:
--------------
Return the minimum eating speed k such that Koko can eat all the bananas within h hours.

Constraints:
------------
1 ≤ n ≤ 10^4
1 ≤ piles[i] ≤ 10^9
1 ≤ h ≤ 10^9


Sample Input-1:
---------------
4 8
3 6 7 11

Sample Output-1:
----------------
4

Explanation:
Koko can eat at a speed of k = 4 bananas per hour:
	In the first hour, she eats 3 bananas from pile 1 (completing the pile).
	In the second hour, she eats 4 bananas from pile 2, leaving 2 bananas.
	In the third hour, she eats the remaining 2 bananas from pile 2.
	In the fourth and fifth hours, she eats the pile 3 and 4. Total time: 4 + 2 + 1 + 1 = 8 hours.

Sample Input-2:
---------------
5 7
30 11 23 4 20

Sample Output-2:
----------------
30

Explanation:
Koko can finish all bananas at a speed of k = 30. She eats each pile in an hour.


Sample Input-3:
---------------
5 6
30 11 23 4 20

Sample Output-3:
23

Explanation:
Koko can eat all bananas in 6 hours with a speed of k = 23.
 */

public class KokoEatingBanana {
    private static int binarySearch(int [] arr,int h,int max){
        int low = 1;
        int high = max;
        
        while(low<high){
            int mid = (low+high)/2;
            int hours = findHours(arr,mid);
            if(hours<=h){
                high = mid;
                // If hours spent is less the h or equal to h , then number of bananas it can eat per hour is more. So , 
                // minimise the value by taking  high = mid
            }
            else if(hours>h){
                low = mid+1;
            }
            
        }
        return low;
    }

    private static int findHours(int [] arr, int h){
        int count = 0;
        for (int i : arr) {
            if(i%h!=0){
                count+= ((i/h)+1);
            }
            else{
                count += (i/h);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        // int [] arr = {3, 6, 7, 11};
        // int h = 8;
        Scanner cin  = new Scanner(System.in);

        int n = cin.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        int h = cin.nextInt();
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n;i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.println(binarySearch(arr, h , max));
        cin.close();      
    }    
}
