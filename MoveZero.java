import java.util.*;
public class MoveZero {
    public static void main(String[] args) {
        Scanner cin  =  new Scanner(System.in);
        int n =  cin.nextInt();
        int arr []  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = cin.nextInt();
        }

        int j = n-1;
        while(arr[j]==0){
            j--;
        }
        int i = n-1;
        while (i!=-1) {
            if(arr[i]==0 && (j > i)){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            while (arr[j]==0) {
                j--;
            }
            i--;
        }
        for (int k : arr) {
            System.out.print(k+" ");
        }
        
    }
}
