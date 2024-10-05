/*
 Aruna as a type writer, typing a document in her laptop. Suddenly her system got
hacked and whatever she types as words are displaying in reverse and with simple 
braces. She types only lowercase letters.

Inorder to get the actual words, Aruna has to reverse each word starting with the
word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: A string, represents an encoded word.

Output Format:
--------------
Line-1: A string, return the original string.


Sample Input-1:
---------------
{pqrs}

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
{uoy{are}woh}

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then {uoyerawoh} will be reversed.
 */
import java.util.*;
public class RevervseStrings {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='}'){
                String temp = "";
                while (!stack.empty() && stack.peek()!='{') {
                    temp+=stack.pop();
                }
                stack.pop();
                for (int j = 0; j < temp.length(); j++) {
                    stack.push(temp.charAt(j));
                }
            }
            if(str.charAt(i)!='}') stack.push(str.charAt(i));
        }
        while (!stack.empty()) {
            result = stack.pop() + result;
        }

        System.out.println(result);
        
    }
}
