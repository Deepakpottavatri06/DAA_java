/*
 Pranav has a puzzle board filled with square boxes in the form of a grid.
Some cells in the grid may be empty. '0' - indicates empty, '1' - indicates a box. 

The puzzle board has some patterns formed with boxes in it, 
the patterns may be repeated. The patterns are formed with boxes (1's) only, 
that are connected horizontally and vertically but not diagonally.

Pranav wants to find out the number of unique patterns in the board.

You are given the board in the form of a grid M*N, filled wth 0's and 1's.
Your task is to help Pranav to find the number of unique patterns in the puzzle board.

Input Format:
-------------
Line-1: Two integers M and N, the number of rows and columns in the grid-land.
Next M lines: contains N space-separated characters ['0','1'].

Output Format:
--------------
Print an integer, the number of unique patterns in the puzzle board.


Sample Input-1:
---------------
5 5
0 1 0 1 1
1 1 1 0 1
0 1 0 1 0
1 0 1 1 1
1 1 0 1 0

Sample Output-1:
----------------
3

Explanation-1:
------------
The unique patterns are as follows:
  1			 1 1		1 
1 1 1		   1  	,	1 1
  1		,	
   
   
Sample Input-2:
---------------
6 6
1 1 0 0 1 1
1 0 1 1 0 1
0 1 0 1 0 0
1 1 0 0 0 1
0 0 1 0 1 1
1 1 0 1 0 0

Sample Output-2:
----------------
5

Explanation-2:
------------
The unique patterns are as follows:
1 1		1 1		    1			1 1 	1
1   	  1         1 1 			

 */

import java.util.*;
public class DistinctIslandsDFS {

    public static String dfsHelper(int [][] arr, int i, int j){
        String result = "";
        int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} };
        // String[] dirLabels = {"d", "u", "r", "l"}; // down, up, right, left
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(Arrays.asList(i,j,0,0));
        arr[i][j] = -1;

        while (!stack.empty()) {
            List<Integer> temp = stack.pop();
            int r = temp.get(0);
            int c = temp.get(1);
            int relativeRow = temp.get(2); 
            int relativeCol = temp.get(3);
            result=result+ relativeRow + relativeCol;
              
           for (int k = 0; k < directions.length; k++) {
                 int row = r+directions[k][0];
                 int col = c+directions[k][1];
                 if(row>=0 && row<arr.length &&
                    col>=0 && col<arr[0].length && arr[row][col]==1){
                    arr[row][col]=-1;
                    stack.push(Arrays.asList(row,col,relativeRow + directions[k][0],relativeCol+directions[k][1]));
                }
           }

        }
        System.out.println("result :" +result);
        return result;
       
    }
    public static int distinctIslands(int [][] arr, int row, int col){
        Set <String>islands = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j]==1){
                    islands.add(dfsHelper(arr,i,j));
                }
            }
        }

        return islands.size();
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
        System.out.println(distinctIslands(arr,row,col));
        cin.close();
    }
}
