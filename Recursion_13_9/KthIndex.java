import java.util.*;

public class KthIndex {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int k = cin.nextInt();
        int kth = kthIndex(n,  k);
        System.out.println(kth);
    }
    private static int kthIndex(int n,int k){
        if(n==1){
            return 0;
        }
        int mid =  (int)Math.pow(2, n-2); // half elements
        if(k>mid){
            return 1 - kthIndex(n-1, k-mid);
        }
        return kthIndex(n-1, k);
    }
}
