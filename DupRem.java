import java.util.*;

public class DupRem{
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);
        int n = cin.nextInt();
        int arr [] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }
        cin.close();
        int prev = arr[0];
        for(int i = 1; i < n ; i++){
            if(prev == arr[i]){
                prev = arr[i];
                arr[i]=-1;
            }
            else{
                prev = arr[i];
            }
        }

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}