/*
 You are given an N×N grid that represents a maze. 
In this maze: Each cell contains either a 0 or 1.
 --1 indicates an open path where you can walk.
 --0 indicates a dead-end where you cannot pass.

You start at the top-left corner of the maze, i.e., position (0, 0).
Your target is to reach the bottom-right corner of the maze, i.e., position (N-1, N-1).
In the maze, you can move only right or down from each cell.

Objective: Determine if there exists a path from the start (0, 0) to the end (N-1, N-1) that passes only through cells marked 1. 
If such a path exists, return true; otherwise, return false.

Input Format:
-------------
Line-1: The first line contains an integer N, the size of the square grid.
Line 2 to N: The next N lines each contain N space-separated integers (either 0 or 1), representing the maze.

Output Format:
--------------
Line-1: Print true if a path exists from (0, 0) to (N-1, N-1), otherwise print false.

Constraints:
------------
* 1 ≤ N ≤ 100
* Each cell in the grid is either 0 or 1.

Sample Input-1:
---------------
4
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

Sample Output-1:
----------------
true

Explanation: There exists a path from (0, 0) to (3, 3).

Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false

Explanation: There is no valid path from (0, 0) to (3, 3).
 */

import java.util.Scanner;


public class Maze {

    public static boolean dfsPathFinder(int arr[][], int i , int j){
        if(i== arr.length-1 && j==arr[0].length-1 && arr[i][j]==1){
            return true;
        }

        if(i>=0 && i<arr.length && j>=0 && j<arr[0].length && arr[i][j]==1){
            if(dfsPathFinder(arr, i+1, j)){
                return true;
            }
            else if(dfsPathFinder(arr, i, j+1)){
                return true;
            }
            return false;
        }
        else{
            return false;
        }

    }

    public static boolean maze(int [][] arr, int row,int col){
        
        boolean result = false;
        result = dfsPathFinder(arr, 0, 0);
        return result;
    }
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);
        int row = cin.nextInt();
        int col = row;
        // cin.nextLine();
        int arr[][] = new int[row][col];
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = cin.nextInt();
            }
            // cin.nextLine();
        }
        System.out.println(maze(arr,row,col));
        cin.close();
    }
}
