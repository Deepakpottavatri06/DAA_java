/*You are entering into a maze N*N grid consist of(0's and 1's)
Initially you will start from (0,0) position in the maze, 
Your target is to reach the end position (N-1, N-1).

Among the four directions available(top, down, left, right),
you can move in two directions only, right and down.

In the maze, '0' indicates dead end and '1' indicates open way. 
You can travel through only open way.
For Example:-
Given Maze of size N=4 , starting position is (0, 0),
1 0 0 0
1 1 0 1
0 1 0 0
1 1 1 1

You can reach the (3, 3) position in the following way.
1 0 0 0
1 1 0 0
0 1 0 0
0 1 1 1

Return true, if you can reach the end position(N-1, N-1).
otherwise return false.

Input Format:
-------------
Line-1 -> An integer N, size of square board.
Next N lines -> N space separated integers 

Output Format:
--------------
Print a boolean value.

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


Sample Input-2:
---------------
4
1 1 0 0
1 0 0 1
0 1 1 0
1 0 0 1

Sample Output-2:
----------------
false */

import java.util.*;
public class Maze {

    public static boolean maze(int [][]arr,int row,int col){
        if((arr.length-1)== row && (arr[0].length-1==col) && arr[row][col]==1){
            System.out.println("reached distination :"+row+" "+col);
            return true;
        }

        for(int i[] : new int[][]{{0,1},{1,0}}){
            if(isSafe(arr,row,col)){
                System.out.println("current i, j : "+(row)+" "+(col));
                arr[row][col] = 0;
                if(maze(arr, row+i[0], col+i[1])){
                    return true;
                }
                arr[row][col] = 1;
            }
        }
        return false;
    }
    public static boolean isSafe(int [][]arr, int r, int c){
        return (r<arr.length && r>=0 && c>=0 && c<arr[0].length && arr[r][c]==1);
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
        System.out.println(maze(arr,0,0));
        cin.close();
    }
}
