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
import java.util.Arrays;
import java.util.Scanner;

public class OBSTDP {
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
        System.out.println(helper(freq,n));
        cin.close();
    }
    static int helper(int [] freq, int n){
        int dp[][] = new int[n][n]; 
        for(int i = 0 ; i< n ;i++){
            dp[i][i] = freq[i];
        }
        int prefixSum [] = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefixSum[i+1] = prefixSum[i] + freq[i];
        }
        for (int len = 2; len <= n  ; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len -1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = 
                    (k > i ? dp[i][k - 1] : 0) + 
                    (k < j ? dp[k + 1][j] : 0) +
                    prefixSum[j+1] - prefixSum[i];
                    dp[i][j] = Math.min(dp[i][j], cost);
                } 
                System.out.println(Arrays.deepToString(dp));
            }
        }
        return dp[0][n-1];
        
    }
    

}
