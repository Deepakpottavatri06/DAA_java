
import java.util.*;
public class MinProdSubArr {

    private static int findMinProdSub(int [] arr){
       
        int countZero = 0;
        int countPositive = 0;
        int countNegative = 0;
        int negMax = Integer.MIN_VALUE;
        int posMin = Integer.MAX_VALUE;
        int prod = 1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0){
                countZero++;
                continue;
            }
            else if(arr[i]>0){
                if(arr[i]<posMin){
                    posMin=arr[i];
                }
                countPositive++;
            }
            else if(arr[i]<0 ){
                if(arr[i]>negMax){
                    negMax = arr[i];
                }
                countNegative++;
            }
            prod*=arr[i];
        }
        System.out.println(countNegative+" "+countPositive+" "+countZero);
        if(countZero==arr.length){
            return 0;
        }
        else if(countNegative==0 && (countZero!=0)){
            return 0;
        }
        else if(countZero==0 && countNegative==0){
            return posMin;
        }
        else if(countNegative%2==0 ){
            return prod/negMax;
        }
        return prod;
    }
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        String inp [] = cin.nextLine().split(",");
        int arr[] = new int[inp.length];
        for (int i = 0; i < inp.length; i++) {
            arr[i] = Integer.parseInt(inp[i]);
        }
        System.out.println(findMinProdSub(arr));
        cin.close();
    }
}
