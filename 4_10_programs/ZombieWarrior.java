/*
 Due to side effects of vaccination in Europe, Few people turned as zombies.
And other people fight againest zombies called as warriors to save their lives.

You are given a list of integers strength[], represent the strength of the people.
all the people running in same line with same speed.
If the strength value is negative the person is a zombie running towards left,
If the strength value is positive the person is a warrior running towards right.
and the absolute value represents their strength.

If a zombie and a warrior meet, the person with smallest strength will die. 
If both have the same strength, both will die. 
Two persons moving in the same direction will never meet.

Your task is to find out the list of strengths of people who will be alive. 

Input Format:
-------------
space separated integers, list of strength[].

Output Format:
--------------
Print the list of strengths people who will be alive.


Sample Input-1:
---------------
4 9 -5

Sample Output-1:
----------------
4 9

Explanation:
------------
The 9 and -5 meet resulting in 9. The 4 and 9 never meet.


Sample Input-2:
---------------
-3 -2 2 3

Sample Output-2:
----------------
-3 -2 2 3

Explanation:
------------
The people with the strengths,
-3 and -2 moving left, 3 and 2 moving right. No one will die.


Sample Input-3:
---------------
8 3 -6

Sample Output-3:
----------------
8

Explanation:
------------
The people with the strengths,
3 and -6 meet, 3 will die, -6 is alive.
And 8 and -6 meet, -6 will die, 8 is alive.

 */

import java.util.*;

public class ZombieWarrior {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String n[] = cin.nextLine().split(" ");
        int arr[] = new int[n.length];
        for (int i = 0; i < n.length; i++) {
            arr[i] = Integer.parseInt(n[i]);
        }
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i =  arr.length-1; i>=0; i--) {
            if (arr[i] < 0) {
                stack.push(arr[i]);
            } else if (arr[i] > 0) {
                int temp = arr[i];
                boolean warriorSurvives = true;
                // System.out.println(temp);
                while (!stack.empty()) {
                    // System.out.println(stack.peek()+" "+temp);
                    if (temp < Math.abs(stack.peek())) {
                        // System.out.println("yes");
                        warriorSurvives = false;
                        break;
                    } else if (temp > Math.abs(stack.peek())) {
                        stack.pop();
                    } else {
                        stack.pop();
                        warriorSurvives = false;
                        break;

                    }
                }
                if (warriorSurvives)
                    result.add(0, temp); // maintaing order of warriors 
            }
        }
        int count = 0;
        while (!stack.empty()) {
            // System.out.println(stack.peek());
            //maintaining order of zombies
            result.add(count,stack.pop());
            count++;
        }
        for (Integer integer : result) {
            System.out.print(integer + " ");
        }
        cin.close();
    }
}
