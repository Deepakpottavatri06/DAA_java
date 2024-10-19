

import java.util.*;
public class BestTimeStockBuy {
    private static void helper(int [] arr){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if(min>arr[i]) min = arr[i];
            max = Math.max(max, arr[i]-min);
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String [] inp = cin.nextLine().split(" ");
        int n  = inp.length;
        int arr[] = new int[n];
        for (int i = 0; i < inp.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        helper(arr);
        cin.close();
    }
}
