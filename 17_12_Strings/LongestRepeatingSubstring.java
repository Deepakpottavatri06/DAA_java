/*Charlie Brown is working with strings,
He is a given a string S. He wants to find out the maximum substring 'MaxSub'.

MaxSub is a substring which appears atleast twice in S with Maximum length. 

Your task is to help Charlie Brown to find the Maximum Substring MaxSub,
and print the length of MaxSub. If there is MaxSub, return 0.

Input Format:
-------------
A string S.

Output Format:
--------------
Print an integer, length of MaxSub

Sample Input-1:
---------------
babababba

Sample Output-1:
----------------
5

Explanation: 
------------
The Maximum substring is 'babab' , which occurs 2 times.

Sample Input-2:
---------------
abbbbba

Sample Output-2:
----------------
4

Explanation: 
------------
The Maximum substring is 'bbbb' , which occurs 2 times.

Sample Input-3:
---------------
vignesh

Sample Output-3:
----------------
0 */
import java.util.*;

public class LongestRepeatingSubstring {

    static int LRS(String word){
        int max = 0;
        int m = word.length();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j <= m; j++) {
                String temp = word.substring(i, j);
                if(set.contains(temp)){
                    max = Math.max(max,temp.length());
                }
                else{
                    set.add(temp);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String word = cin.nextLine();
        System.out.println(LRS(word));
        cin.close();
    }
}
