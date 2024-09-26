import java.util.*;
public class LongestCP {

    private static String smallestString(String [] arr ){
        int min = arr[0].length();
        String x = arr[0];
        for (int i = 0; i < arr.length; i++) {
            int len = arr[i].length();
            if(len<min){
                min = len;
                x = arr[i];
            }
        }
        return x;
    }

    private static String binarySearch(String [] arr){  
        String small = smallestString(arr);
        String result = "";
        int low = 0;
        int high = small.length()-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(isCommon(arr, mid,small)){
                result = small.substring(0,mid+1);
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return result;
    }
    private static boolean isCommon(String [] arr, int mid,String small){
        String pre = small.substring(0,mid+1);
        for (int i = 0; i < arr.length; i++) {
            if(!arr[i].startsWith(pre)){
                return false;
            }
        }
        System.out.println("prefix "+ pre);
        return true;
    }
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        String arr[] = cin.nextLine().split(" ");
        String small  = binarySearch(arr);
        System.out.println(small);

        cin.close();

    }
}
