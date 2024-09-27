import java.util.Scanner;

public class SmallestComEle {
    private static int binarySearch(int [] arr,int req,int low, int high){
        if(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==req){
                return mid;
            }
            else if(arr[mid]>req){
                return binarySearch(arr, req, low, mid-1);    
            }
            else{
                return binarySearch(arr, req, mid+1, high);
            }
        }
        return -1;
    }
    private static int smallestCommonElement(int [][]arr){
        int first [] = arr[0];
        int result = -1;
        int lastEle = first[first.length-1];
        outer : for (int i = 0; i < first.length; i++) {
            boolean flag = true;
            for(int j = 1; j<arr.length ; j++){
                if(lastEle<arr[j][0]) break outer;
                if(binarySearch(arr[j],first[i], 0, arr[j].length-1)==-1){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result = first[i];
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int row = cin.nextInt();
        int col = cin.nextInt();
        int [] [] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = cin.nextInt();
            }
        }
        int smallestCE = smallestCommonElement(arr);
        System.out.println("smallest "+smallestCE);
        cin.close();
    }
    
}
/*
 4
5
1 2 3 4 5
2 4 5 6 7
3 5 8 9 10
2 3 4 5 7
 */