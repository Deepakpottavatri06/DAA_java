/*With the growing trend of shorthand writing, 
people often replace parts of a word with their lengths to create short-forms. 
A valid short-form can be created by replacing non-overlapping and non-adjacent substrings with their respective lengths.

You are given a word as input. 
Your task is to generate all possible short-forms of the given word and return them in lexicographical order.

Input Format:
--------------
Line-1: A single string W representing the word.

Output Format:
---------------
A list of strings representing all possible short-forms of the word W in lexicographical order.

Constraints:
-------------
1 ≤ len(W) ≤ 10
The word W consists of lowercase English letters only.

Sample Input-1:
---------------
kmit

Sample Output-1:
----------------
[1m1t, 1m2, 1mi1, 1mit, 2i1, 2it, 3t, 4, k1i1, k1it, k2t, k3, km1t, km2, kmi1, kmit]


Sample Input-2:
---------------
cse

Sample Output-2:
----------------
[1s1, 1se, 2e, 3, c1e, c2, cs1, cse] */
import java.util.*;
public class GenerateAbbreviations {
    List<String> result = new ArrayList<>();

    public void helper(String inp, StringBuilder curr, int i, int J){
        // J - represents the substring abbreviated as len of sunstring
        // i - current index of character in inp string

        if(i==inp.length()){
            if(J!=0){
                curr.append(J);
            }
            result.add(curr.toString());
            return;
        }

        int len = curr.length();
        if(J!=0){
            curr.append(J);
        }
        curr.append(inp.charAt(i));
        // include the substring abbreviated as J(number) so far + character at the ith index in inp(string)
        helper(inp, curr, i+1, 0);
        curr.setLength(len); // resetting the curr stringBuilder up to the length
        // abbreviate the current character
        helper(inp, curr, i+1, J+1);
        
    }

    List<String> genAbb(String inp){
        StringBuilder s = new StringBuilder("");
        helper(inp,s,0,0);
        Collections.sort(result);
        return result;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String inp = cin.nextLine();
        System.out.println(new GenerateAbbreviations().genAbb(inp));
        cin.close();
    }
}


