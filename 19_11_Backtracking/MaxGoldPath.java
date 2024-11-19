/*The Kolar Gold Fields (KGF) is in the form of a m*n grid,
Each field, contains some amount of Gold in it.
 
You can mine the gold in the KGF in the following way.
	- You can start at any position in the grid, never visit a cell with no gold.
	- each time you visit a cell, you will grab all the gold in it.
	- You can move one step to the left, right, up or down.
	- You can't visit the same cell more than once.
	- You can stop at any cell.
	
Your task is to find the maximum amount of gold you can collect.

Input Format:
-------------
Line-1: Two integers M and N size of the KGF grid.
Next M lines: N space separated integers, gold in each row of the grid.

Output Format:
--------------
Print an integer, maximum amount of gold.


Sample Input-1:
---------------
3 3
3 6 0
5 8 7
0 9 0

Sample Output-1:
----------------
24

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 9 -> 8 -> 7.

Sample Input-2:
---------------
5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20

Sample Output-2:
----------------
28

Explanation:
-------------
You can grab the gold in KGF grid as follows:
You can obtain like as follows: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
*/
import java.util.*;

public class MaxGoldPath {
    public static int helper(int [][] grid, int i, int j, int currgold){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return currgold;
        }

        int temp = grid[i][j];
        currgold += temp;
        int maxgold = currgold;
        grid[i][j] = 0;
        maxgold = Math.max(maxgold,helper(grid, i+1, j, currgold));
        maxgold = Math.max(maxgold,helper(grid, i-1, j, currgold));
        maxgold = Math.max(maxgold,helper(grid, i, j+1, currgold));
        maxgold = Math.max(maxgold,helper(grid, i, j-1, currgold));

        return maxgold;
    }

    public static int maximumGolduu(int [][] grid, int row, int col){
        int maxgold = 0;
        for (int i = 0; i < row ; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]!=0){
                    int gold = helper(grid,i,j,0);
                    maxgold = Math.max(maxgold, gold);
                }
            }
        }

        return maxgold;
    }
    public static void main(String[] args) {
        Scanner cin =  new Scanner(System.in);
        int row = cin.nextInt();
        int col = cin.nextInt();
        cin.nextLine();
        int grid [][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                grid[i][j] = cin.nextInt();
            }
        }
        System.out.println(maximumGolduu(grid,row,col));
    }
}
