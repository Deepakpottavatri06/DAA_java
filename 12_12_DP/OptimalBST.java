/*You are given N nodes of a Binary search tree.
To search a node in the binary serach tree, it will cost some freq.
You are given the N nodes as keys[] in sorted order, and the search costs of N nodes
 as freq[], where freq[i] is the cost to search keys[i] element in the BST.

The cost to search a BST node is the level of that node multiplied by its freq. The level of the root is 1.

Your task is to findout the minimum cost of a BST is defines as the total cost of all the BST nodes.
You can form the BST with any element as the root node.

Input Format:
------------------
Line-1: An integer N, number of nodes.
Line-2: N space separate integers, node vals[].
Line-3: N space separate integers, node cost[].

Output Format:
-------------------
Print an integer, minimum search cost of BST.


Sample Input-1:
--------------------
3
10 20 30
23 32 14

Sample Output-1:
----------------------
106

Explanation:
----------------
The BST is: 
		20
		/\
	  10  30

Sample Input-2:
--------------------
4
8 10 12 20
26 34 8 50

Sample Output-2:
----------------------
210

Explanation:
----------------
The BST is: 
		10
		/\
	  8  20
		/
	 12
 */
import java.util.*;
public class OptimalBST {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int freq [] = new int[n];
        int keys [] = new int[n];
         for (int i = 0; i < keys.length; i++) {
            keys[i] = cin.nextInt();
        }
        for (int i = 0; i < freq.length; i++) {
            freq[i] = cin.nextInt();
        }
        System.out.println(helper(freq,0,n-1));
        cin.close();
    }
    static int helper(int [] freq , int i , int j){
        if(j<i){
            return 0;
        }
        if(j==i){
            return freq[i];
        }
         int sum = sumFreq(freq,i,j);
         int min = Integer.MAX_VALUE;
         for (int k = i; k <= j; k++) {
            min = Math.min(helper(freq,i, k-1)+helper(freq,k+1,j),min);  
         }

         System.out.println(" sum and min :"+sum+" "+min);
         return sum + min;
    }
    static int sumFreq(int [] freq, int i, int j){
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += freq[k];
        }
        return sum;
    }
}
