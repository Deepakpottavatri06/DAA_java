/*
 * KMIT exam department is preparing seating arrangements for upcoming exams. 
They want to randomize the seating plan by reversing every group of m consecutive students in a specified range of the list. 
You have been tasked with developing a program that generates the seating arrangement by reversing groups of m students in a subarray of student IDs, where the IDs range from 1 to n.

Your program should take the following inputs:
n: The total number of students (represented by numbers from 1 to n).
m: The size of the groups to be reversed.
i, j: The start and end indices of the subarray within which the reversal of groups should take place.

Constraints:
-------------
If m is larger than the size of the specified subarray (i to j), the list should remain unchanged.
If i >= j, the list should remain unchanged.
Time Complexity:
O(n): The list is traversed to reverse each group, resulting in a linear time complexity proportional to the number of elements n.
Space Complexity:
O(1): The program operates in place, modifying the list without using additional space for storage.

Input Format:
-------------
Line-1: An Integer n, The number of students (size of the main list, from 1 to n).
Line-2: An Integer m, The size of the groups of students to reverse.
Line-3: An Integer i, The starting index of the subarray in which the reversal should start.
Line-4: An Integer j, The ending index of the subarray in which the reversal should end.

Output Format:
---------------
Line-1: Print the modified list after reversing every m consecutive students in the specified subarray.


Sample Input-1:
----------------
10 //n
3 //m
1 //i
9 //j

Sample Output-1:
-----------------
[1, 4, 3, 2, 7, 6, 5, 10, 9, 8]

Explanation: The subarray from index 1 to 9 has 9 elements. The group size m is 3, so every 3 consecutive elements are reversed:
Subarray: [2, 3, 4, 5, 6, 7, 8, 9, 10]
Reverse [2, 3, 4] -> [4, 3, 2]
Reverse [5, 6, 7] -> [7, 6, 5]
Reverse [8, 9, 10] -> [10, 9, 8]
Final output: [1, 4, 3, 2, 7, 6, 5, 10, 9, 8]

Sample Input-2:
----------------
10 //n
3 //m
7 //i
2 //j

Sample Output-2:
----------------
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

Explanation: The start index i (7) is greater than the end index j (2).
According to the problem constraints: If i >= j, the list should remain unchanged.
 */

import java.util.Scanner;

public class ReverseGroupSol {
    
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        int n,m,i,j;
        n = cin.nextInt();
        m = cin.nextInt();
        i = cin.nextInt();
        j = cin.nextInt();
        cin.close();
        int arr [] = new int[n];
        for (int k = 0; k < arr.length; k++) {
            arr[k] = k+1;
        }
        class ReverseGroup{
            public void revgrp(int start,int end){
                if (start > j) {
                    return;
                }
                
                end = Math.min(end, j);
                int tempI = start;
                int tempJ = end;
                while (tempI < tempJ) {
                    int temp = arr[tempI];
                    arr[tempI] = arr[tempJ];
                    arr[tempJ] = temp;
                    tempI++;
                    tempJ--;
                }
                System.out.println();
                revgrp(start+m, end+m);
            }
        }
        ReverseGroup rg =  new ReverseGroup();
        rg.revgrp(i, i+m-1);
        for (int k = 0; k < arr.length; k++) {
            System.out.print(arr[k] + " ");
        }

    }

}
