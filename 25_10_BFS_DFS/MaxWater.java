
/*
 Jadav Payeng, "The Forest Man of India", 
started planting the seeds in a M*N grid land.
Each cell in the grid land is planted with a seed.
After few days, some seeds grow into saplings indicates with '1',
and the rest are dead seeds indicates with '0'.

One or more saplings are connected either horizontally, vertically or diagonally with each other, form a sapling-group. 
There may be zero more sapling-groups in the grid land.

Jadav Payeng wants to know the biggest sapling-group in that grid land.

You are given the M * N grid, filled with 0's and 1's.
You are task is to help Jadav Payeng to find the number of saplings in 
the largest sapling-group.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated integers .

Output Format:
--------------
Print an integer, the number of saplings in the 
largest sapling-group in the given grid-land.

Sample Input-1:
---------------
5 4
0 0 1 1
0 0 1 0
0 1 1 0
0 1 0 0
1 1 0 0

Sample Output-1:
----------------
8


Sample Input-2:
---------------
5 5
0 1 1 1 1
0 0 0 0 1
1 1 0 0 0
1 1 0 1 1
0 0 0 1 0

Sample Output-2:
----------------
5

 */
import java.util.*;
public class MaxWater {
    private static int helper(int [][]arr, int i, int j){
        int area = 0;    
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(Arrays.asList(i,j));
        arr[i][j]=-1;
        int [][] directions = {
            {1,0},{-1,0},{0,1},{0,-1} // vertical or horizaontal
            ,{1,1},{1,-1},{-1,1},{-1,-1} // diagonals
        };

        while (!queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            int r = temp.get(0);
            int c = temp.get(1);
            area++;

            for (int [] d : directions) {
                int row = r+d[0];
                int col = c+d[1];
                if(row>=0 && row<arr.length &&
                col>=0 && col<arr[0].length && arr[row][col]==1){
                    arr[row][col] = -1;
                    queue.add(Arrays.asList(row,col));
                }
            }
            
        }   
       
        return area;

    }

    private static int findArea(int [][]arr,int row,int col){
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j]==1){
                    // System.out.println("in if");
                    max = Math.max(max, helper(arr,i,j));
                }   
            }
        }

        return max;
    }
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);
        int row = cin.nextInt();
        int col = cin.nextInt();
        // cin.nextLine();
        int arr[][] = new int[row][col];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = cin.nextInt();
            }
            // cin.nextLine();
        }
        System.out.println(findArea(arr,row,col));
        cin.close();

    }
    
}
