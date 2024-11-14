/*
 You are a wedding decorator responsible for decorating a wall of size M * N using two different colored balloons. 
The balloons can either be blue or white. 
The blue-colored balloons form distinct shapes, where each shape consists of blue balloons connected in one of the four cardinal directions (up, down, left, or right). 
White balloons serve as separators between blue balloon shapes.

Blue-colored balloons are represented by the digit 1, while white-colored balloons are represented by the digit 0 in a 2D matrix. 
Your task is to count the number of distinct shapes formed by the blue balloons on the wall.

Two shapes are considered distinct if one shape cannot be exactly transformed into the other by shifting (translation).

Input Format:
-------------
Line-1: Two space-separated integers M and N, representing the size of the wall (M rows and N columns).
Line-2 to M: The next M lines each contain N space-separated integers, either 0 or 1, where 1 represents a blue balloon and 0 represents a white balloon.

Output Format:
---------------
Line-1: An integer representing the number of distinct shapes formed by blue balloons.

Constraints:
------------
*1 ≤ M, N ≤ 50
*The matrix consists only of 0s and 1s.

Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1

Explanation:
------------
In the given input, two shapes are formed by blue balloons. However, both shapes are identical in form, so the output is 1.

Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

Explanation:
-------------
There are four distinct shapes formed by the blue balloons.

 */
import java.util.*;

public class DistinctIslands {

    public static String bfsHelper(int [][]arr, int i, int j){
        Map<List<Integer>,String> map = new LinkedHashMap<>();
        String result = "";
        map.put(Arrays.asList(1,0),"d");
        map.put(Arrays.asList(-1,0),"u");
        map.put(Arrays.asList(0,1),"r");
        map.put(Arrays.asList(0,-1),"l");
        // int count = 0;
        // result+=count;
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(Arrays.asList(i,j));
        arr[i][j] = -1;
        while (!queue.isEmpty()) {
            List<Integer> temp = queue.poll();
            int r = temp.get(0);
            int c = temp.get(1);

            for (Map.Entry<List<Integer>,String> entry : map.entrySet()) {
                int row = r+entry.getKey().get(0);
                int col = c+entry.getKey().get(1);  
                if(row>=0 && row<arr.length &&
                col>=0 && col<arr[0].length && arr[row][col]==1){
                    arr[row][col] = -1;
                    result+= entry.getValue();
                    queue.add(Arrays.asList(row,col));
                }
            }
            // count++;
            // result+=count;
            result+="b";
            // to maintain uniqueness
        }
        System.out.println("result :" +result);
        return result;
       

    }

    public static int distinctIslands(int [][] arr, int row, int col){
        Set <String>islands = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(arr[i][j]==1){
                    islands.add(bfsHelper(arr,i,j));
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
