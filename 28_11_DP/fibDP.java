
import java.util.*;
public class fibDP {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        if(n<=1){
            System.out.println(n);
            cin.close();
            return;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2;i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
        cin.close();
    }
}
