/*
 You are given a string s consisting of n characters, where each character is either 'X' or 'O'.

A move is defined as selecting three consecutive characters in s and converting them all to 'O'. 
If a move is applied to a character that is already 'O', it remains 'O'.

Your task is to determine the minimum number of moves required to convert all characters in the string s to 'O'.

Input Format:
--------------
Line-1: A single string s, consisting of characters 'X' and 'O'.

Output Format:
---------------
Line-2: Return a single integer, representing the minimum number of moves required to convert all characters of the string to 'O'.

Constraints:
------------
3 ≤ s.length ≤ 1000
s[i] is either 'X' or 'O'.


Sample Input-1:
---------------
XXX

Sample Output-1:
----------------
1

Explanation:
In one move, the substring "XXX" is selected, and all the characters are converted to 'O'.
So, the result is 1.


Sample Input-2:
---------------
XXOX

Sample Output-2:
----------------
2

Explanation:
We first select the first three characters "XXO" and convert them to "OOO".
Then, we select the last three characters "OOX" and convert them to "OOO".
So, the result is 2.


Sample Input-3:
---------------
OOOO

Sample Output-3:
----------------
0

Explanation:
All characters are already 'O', so no move is needed.
Thus, the result is 0.
 */

import java.util.*;

public class MinMoves {
    private static int findMoves(String inp) {
        int result = 0;
        StringBuffer sb = new StringBuffer(inp);
        int len = sb.length();
        int i = 0;
        int j = Math.min(2,len-1);
        System.out.println(len);
        while (i < len) {
            boolean flag = false;
            for (int j2 = i; j2 < j+1; j2++) {
                if (sb.substring(j2, j2 + 1).equals("X")) {
                    sb.replace(j2, j2 + 1, "O");
                    flag = true;
                }
            }
            //System.out.println(sb.substring(i,j+1));
            if(flag){
                result+=1;
            }
            j = Math.min(len-1, j+3); 
            i +=3;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String inp = cin.nextLine();
        System.out.println(findMoves(inp));
        cin.close();
    }
}
