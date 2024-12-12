
/*
 You are given a directed graph represented by vertices and edges. 
Your task is to implement Depth-First Search (DFS) traversal from a given starting vertex. 
The graph is represented using an adjacency list, and you need to traverse the graph starting from a specified vertex using an iterative approach (using a stack).

Input Format:
-------------
Line-1: An integer V, the number of vertices in the graph.
Line-2: An integer E, the number of edges in the graph.
Line3 to E: The next E lines each contain two integers source and destination, representing an edge from the source vertex to the destination vertex.
Line-E+1: The starting vertex S from which DFS traversal should begin.

Output Format:
--------------
Line-1" Print the vertices visited in DFS order starting from the given vertex S.

Constraints:
------------
*1 ≤ V ≤ 100
*0 ≤ E ≤ V * (V - 1)
*0 ≤ source, destination, S < V

Sample Input-1:
----------------
5
8
0 1
0 4
1 0
1 2
1 3
1 4
2 3
3 4
0

Sample Output-1:
----------------
0 1 2 3 4 


Sample Input-2:
----------------
7
9
0 1
0 2
1 3
2 3
3 4
3 5
4 6
5 6
6 1
2

Sample Output-2:
----------------
2 3 4 6 1 5 
 */

import java.util.*;
@SuppressWarnings("unchecked")
class Graph{
    List<Integer>[] adjList;
    Graph(int numVertices){
        adjList = (List<Integer>[]) new List[numVertices];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u , int v){
        adjList[u].add(v);
        // adjList[v].add(u);
    }

    public  void dfs(Integer start){
        Stack <Integer> q = new Stack<>();
        Set <Integer> visited = new HashSet<>();
        q.push(start);
        while (!q.isEmpty()) {
            Integer t = q.pop();
            if(visited.contains(t)) continue;
            System.out.print(t+" ");
            visited.add(t);
            for (int i = adjList[t].size()-1 ;  i>=0 ; i--) {
                if (!visited.contains(adjList[t].get(i))) {
                    q.push(adjList[t].get(i));
                }
            }
        }

    }
}
public class DFS {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int v = cin.nextInt();
        cin.nextLine();
        Graph g = new Graph(v);
        int e = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < e; i++) {
            int n1 = cin.nextInt();
            int n2 = cin.nextInt();
            g.addEdge(n1, n2);
        }
        int start = cin.nextInt();
        cin.nextLine();

        g.dfs(start);
        
        cin.close();
    }
}
