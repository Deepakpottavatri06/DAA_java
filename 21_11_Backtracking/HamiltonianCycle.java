/*N cities are connected through roads, the cities are numbered from 0 to N-1. 
The roadmaps are given as a grid of size N*N, roadmap[][], 
the grid contains 0 and 1 as values grid[i][j]=0, indicates no road 
between i to j cities, grid[i][j]=1, indicates a road between i and j cities.

You are given an integer N, and the roadmap[][]of size N*N.
Your task is to find that there exists a loop in the roadmap, such that 
there exists a route consists of all the cities eaxctly once and the 
last city in the route should be connected to first city of the same route directly.

If you found such route print the route, otherwise print "No Solution"

Input Format:
-------------
Line-1: An integer N, size of the chess board.
Next N lines: N space separated integers, 0 or 1.

Output Format:
--------------
Print any possible route or "No Solution".

Sample Input-1:
---------------
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 1
0 1 1 1 0

Sample Output-1:
----------------
0  1  2  4  3  0

Sample Input-2:
---------------
5
0 1 0 1 0
1 0 1 1 1
0 1 0 0 1
1 1 0 0 0
0 1 1 0 0

Sample Output-2:
----------------
No Solution
 */
import java.util.*;

class HamiltonianCycle
{
	static int V;
    boolean helper(int [][] graph, int [] path, int pos){
        if(pos>=path.length){
            if(graph[path[pos-1]][0]==1){
                return true;
            }
            return false;
        }

        for (int i = 1; i < V; i++) {
            if(!isSafe(graph,path,i,pos)){
                continue;
            }
            path[pos] = i; // i = node
            if(helper(graph, path, pos+1)) return true;
            path[pos] = -1;
        }

        return false;
    }
    boolean isSafe(int [][] graph,int [] path, int node, int pos){
        if(graph[path[pos-1]][node]!=1){
            return false;
        }

        for (int i = 0; i < pos; i++) {
            if(path[i]==node){
                return false;
            }
        }
        return true;
    }
	void hamCycle(int graph[][]){
		//Write your code here
        int path[] = new int[V];
        Arrays.fill(path,-1);     
        path[0] = 0;
        if(helper(graph,path,1)){
            for (int i = 0; i < path.length; i++) {
                System.out.print(path[i]+"  ");
            }
            System.out.print(path[0]);
            return;
        }
        
        System.out.println("No Solution");
        return ;
        
	}
    
    //Your utility functions goes here
    
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		V = sc.nextInt();
		int graph[][]=new int[V][V];

		for(int i=0;i<V;i++)
			for(int j=0;j<V;j++)
				graph[i][j]=sc.nextInt();

		HamiltonianCycle obj = new HamiltonianCycle();
		obj.hamCycle(graph);
        sc.close();
	}
}