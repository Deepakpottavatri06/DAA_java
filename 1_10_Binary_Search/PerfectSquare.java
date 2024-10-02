
/*
 You are given a positive integer n, and your task is to determine whether it is a perfect square. 
A number is considered a perfect square if there exists an integer x such that x * x = n.

You must solve this problem in O(log(n)) time complexity using the binary search algorithm. 

NOTE:You are not allowed to use any built-in library functions to check if the number is a perfect square.

Input Format:
-------------
Line-1: A single integer n.

Output Format:
---------------
Line-1: Print true if the number n is a perfect square, otherwise print false.


Constraints:
-------------
The integer n will always be a positive integer (1 ≤ n ≤ 10^9).
The solution must have a time complexity of O(log(n)).


Sample Input-1:
---------------
25

Sample Output-1:
----------------
true

Explanation:
5 * 5 = 25, so 25 is a perfect square.


Sample Input-2:
---------------
9

Sample Output-2:
----------------
true

Explanation:
3 * 3 = 9, so 9 is a perfect square.


Sample Input-3:
---------------
8

Sample Output-3:
----------------
false

Explanation:
There is no integer x such that x * x = 8.


Sample Input-4:
---------------
125

Sample Output-4:
----------------
false

Explanation:
There is no integer x such that x * x = 125.

 */
public class PerfectSquare {

    private static boolean binarySearch(long low , long high){
        long required = high;
        while (low<high) {
            long mid = (low+high)/2;
            long square = (mid*mid);
            System.out.println(low + " "+ mid + " "+high);
            if(square==required){
                return true;
            }
            if(square>required){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return (low*low == required)? true : false;
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(1, 25));
    }
}
