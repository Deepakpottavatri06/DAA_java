import java.util.*;

public class MaxWaterDFS {
    private static int dfsHelper(int [][]arr, int i, int j){
        int area = 0;    
        Stack<List<Integer>> stack = new Stack<>();
        stack.add(Arrays.asList(i,j));
        arr[i][j]=-1;
        int [][] directions = {
            {1,0},{-1,0},{0,1},{0,-1} // vertical or horizaontal
            ,{1,1},{1,-1},{-1,1},{-1,-1} // diagonals
        };

        while (!stack.isEmpty()) {
            List<Integer> temp = stack.pop();
            int r = temp.get(0);
            int c = temp.get(1);
            area++;

            for (int [] d : directions) {
                int row = r+d[0];
                int col = c+d[1];
                if(row>=0 && row<arr.length &&
                col>=0 && col<arr[0].length && arr[row][col]==1){
                    arr[row][col] = -1;
                    stack.push(Arrays.asList(row,col));
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
                    max = Math.max(max, dfsHelper(arr,i,j));
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
