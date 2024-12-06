/*Your are given the sizes of N-1 matrices as a list[] of size N, where the matrix are numbered from 0 to N-2 and the matrix size is defined as matrix-i size is list[i]*list[i+1].

Matrix multiplication follows associative rule. If you want to multiply 4 matrices, A,B,C and D.
You can perform multiplication in the following ways, ABCD, AB(CD), A(BC)D, ((AB)C)D, (AB)(CD)..etc.
To multiply two matrices of size m*n, n*p, you require m*n*p number of multiplications.

Your task is to return the minimum number of multiplications needed to multiply the N-1 matrices.

Input Format:
------------------
Line-1: An integer N
Line-2: N space separated integers, the list[]

Output Format:
--------------------
Print an integer, minimum multiplications needed.


Sample Input-1:
--------------------
4
10 30 5 60

Sample Output-1:
----------------------
4500

Explanation:
-----------------
posibilities are:
(AB)C => (10×30×5) + (10×5×60) => 1500 + 3000 = 4500 multiplications
A(BC) => (30×5×60) + (10×30×60) => 9000 + 18000 = 27000 multiplications


Sample Input-2:
--------------------
5
12 5 18 7 19

Sample Output-2:
----------------------
2435

Explanation:
-----------------
The best way is: A((BC)D) => (12*5*19) + (5*18*7) + (5*7*19)
=> 1140 + 630 + 665 = 2435 multiplications */
import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainRecursion {
    
    public static int multiChainRecur( int [] arr, int i , int j){
        if(i+1==j){
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int k=i+1; k<j ; k++){
            int count = multiChainRecur(arr, i, k) + multiChainRecur(arr, k, j) + arr[i]*arr[k]*arr[j];
            res = Math.min(res, count);
        }
        return res;
    }

    public static int multiChainRecurMemo( int [] arr, int i , int j, int [][] memo){
        if(i+1==j){
            return 0;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for(int k=i+1; k<j ; k++){
            int count = multiChainRecurMemo(arr, i, k,memo) + multiChainRecurMemo(arr, k, j,memo) + arr[i]*arr[k]*arr[j];
            res = Math.min(res, count);
        }
        memo[i][j] = res;
        return res;
    }
    
    public static int multiChainMemo(int [] arr, int i , int j){
        int dp[][] = new int[j+1][j+1];
        for (int k = 0; k < dp.length; k++) {
            Arrays.fill(dp[k], -1);
        }
        return multiChainRecurMemo(arr, i, j,dp);
    }

    public static int multiChainDP(int [] arr, int n){
        int dp[][] = new int[n][n];

        for (int len = 1; len < n - 1; len++) {
            for (int i = 1; i < n - len; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], cost);
                } 
            }

            // System.out.println(minCost);
        }

    return dp[1][n-1];


    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt(); 
        }

        // System.out.println(multiChainRecur(arr,0,n-1));
        // System.out.println(multiChainMemo(arr,0,n-1));
        System.out.println(multiChainDP(arr, n) );

        cin.close();
    }
}
