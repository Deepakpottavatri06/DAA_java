/*Total cost = 18 + 20 + 18 = 56
Total quantity = 6 + 3 + 9 = 18 */
import java.util.Scanner;

public class Knapsack {

    public static int knapsackRecur( int val[], int weight[], int n , int w){
        if(n==0 || w==0){
            return 0;
        }

        if(weight[n-1]>w){
            return knapsackRecur(val, weight, n-1, w);
        }
        else{
            return Math.max(val[n-1]+knapsackRecur(val, weight, n-1, w-weight[n-1]), knapsackRecur(val, weight, n-1, w));
        }
    }

    // static int knapsackRecurMemoize(int val[], int weight[], int n, int w, int dp[][]){
    //     if(n==0|| w==0){
    //         return 0;
    //     }

    //     if(weight[n-1]>w){
    //         dp[n][w] = Math.wknapsackRecurMemoize(val, weight, n, w, dp);
    //     }
    // }
    // public static int knapsackMemoize(int val [], int weight [], int n, int w){
    //     int dp[][] = new int[n+1][w+1];
    //     int result = knapsackRecurMemoize(val, weight,n,w,dp);
    //     return result;

    // }

    static int tabulation(int val[], int weight[],int n,int c){
        int dp[][] = new int[n+1][c+1];

        for (int i = 1; i < dp.length; i++) {
            for (int wt = 1; wt < dp[0].length; wt++) {
                if(wt>= weight[i-1]){
                    dp[i][wt] = Math.max(dp[i-1][wt], dp[i-1][wt-weight[i-1]]+val[i-1]);
                }
                else{
                    dp[i][wt] = dp[i-1][wt];
                }
            }
        }
        return dp[n][c];
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int c = cin.nextInt();
        int val[] = new int[n];
        int weight[] = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = cin.nextInt();
            weight[i] = cin.nextInt();
        }

        // System.out.println(knapsackRecur(val,weight,n,c));
        // System.out.println(knapsackMemoize(val, weight, n, c));
        System.out.println(tabulation(val,weight,n,c));

        cin.close();
        
    }
}
