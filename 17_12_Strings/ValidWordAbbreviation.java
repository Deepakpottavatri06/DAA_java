
/*The Valid shortcuts of a string "abcd", are as follows:
abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains only lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value


Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
 */
import java.util.*;
public class ValidWordAbbreviation {
    static boolean check(String word, String abbr){
        int i = 0;
        int j = 0;
        int n = word.length();
        int m = abbr.length();
        while (i<n) {
            int skip = 0;
            while((j<m) && Character.isDigit(abbr.charAt(j))){
                skip = skip*10 + Integer.parseInt(abbr.substring(j,j+1));
                j++;
            }
            i += skip;
            // System.out.println("the skip :"+skip+ " i and j "+i+" "+j);
            // System.out.println("word till i :"+ word.substring(0, i+1) + " the abbre : "+abbr.substring(0, j+1));
            if((i<n && j<m && word.charAt(i)!= abbr.charAt(j)) || (i>=n && j<m) || (i>n && j==m)){
                return false;
            }
            i++;
            j++;
        }
        return true;

    } 
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String word = cin.next();
        String abbr = cin.next();
        cin.nextLine();
        System.out.println(check(word,abbr));
        cin.close();    
    }
}
