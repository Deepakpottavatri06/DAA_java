import java.util.*;
public class GCD {
    public static void main(String[] args) {
        Scanner cin  =  new Scanner(System.in);
        int n = cin.nextInt();
        int [] arr = new  int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Gcd(arr[arr.length-1],arr[0]));
        cin.close();
    }
    private static int Gcd(int large , int small){
        if(small==0){
            return large;
        }
        return Gcd(small,large%small);
    }
}
