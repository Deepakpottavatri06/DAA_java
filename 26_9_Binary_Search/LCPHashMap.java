

import java.util.*;
public class LCPHashMap {
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
    private static String longestCommonPrefix(String [] arr){
        String smallest = smallestString(arr);
        String result = "";
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < smallest.length(); i++) {
            map.put(smallest.charAt(i), 0);
            for (int j = 0; j < arr.length; j++) {
                map.put(arr[j].charAt(i), map.getOrDefault(arr[j].charAt(i), 0)+1);
            }
            if(map.get(smallest.charAt(i))==arr.length){
                result = result + smallest.charAt(i);
            }
            else{
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner cin  = new Scanner(System.in);
        String arr[] = cin.nextLine().split(" ");
        String small  = longestCommonPrefix(arr);
        System.out.println(small);

        cin.close();

    }
}
