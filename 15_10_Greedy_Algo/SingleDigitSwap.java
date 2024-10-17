/*
 You are given an integer num. Your task is to maximize its value by swapping at most two digits once. 
Write a program to return the maximum possible value after performing the swap.

If no swap can increase the value, return the original number.

Input Format:
--------------
Line-1: An integer num, where 0 <= num <= 10^8.

Output Format:
--------------
Line-1: Return an integer representing the maximum value obtained after swapping two digits at most once.

Sample Input-1:
---------------
2736

Sample Output-1:
----------------
7236

Explanation:
------------
Swap the digit 2 with 7, resulting in the number 7236, which is the maximum possible value.

Sample Input-2:
---------------
9973

Sample Output-2:
----------------
9973

Explanation:
------------
No swap can make the number larger, so return the original number.
 */
    import java.util.*;

    public class SingleDigitSwap {
        public static void helper(String inp){
            char arr [] = inp.toCharArray();
            int n = arr.length;
            // int maxRight[] = new int[n];
            // maxRight[n-1] = n-1;
            // for (int i = n-2 ;i>=0 ; i--) {
            //     if(arr[i]<=arr[maxRight[i+1]]){
            //         maxRight[i] = maxRight[i+1];
            //     }
            //     else{
            //         maxRight[i] = i;
            //     }
            // }

            // // for (int i = 0; i < maxRight.length; i++) {
            // //     System.out.print(arr[maxRight[i]]);
            // // }

            // for (int i = 0; i < n; i++) {
            //     if(arr[i]<arr[maxRight[i]]){
            //         char temp = arr[i];
            //         arr[i] = arr[maxRight[i]];
            //         arr[maxRight[i]] = temp;
            //         break;
            //     }
            // }

            // System.out.println(new String(arr));
            String result = inp;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    if(Long.parseLong(result)<Long.parseLong(new String(arr))){
                        result = new String(arr);
                        // System.out.println(result);
                    }
                    temp = arr[i];
           
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }

            System.out.println(result);


        }
        public static void main(String[] args) {
            Scanner cin = new Scanner(System.in);
            String inp = cin.next();
            helper(inp);
            cin.close();
        }
    }
