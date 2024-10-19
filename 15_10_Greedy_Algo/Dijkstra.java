 /*
  Given a directed graph represented by an adjacency matrix, where each entry graph[i][j] 
represents the weight of the edge from vertex i to vertex j. If graph[i][j] is 0, 
it means there is no direct edge between i and j.

Your task is to determine the shortest paths from a given source vertex to
all other vertices using Dijkstra’s algorithm.

Input Format:
-------------
Line-1: An integer N, representing the number of vertices in the graph.
Next-N lines: Each line contains N space-separated integers representing the adjacency matrix graph.
Last-line: An integer src, representing the source vertex.

Output Format:
--------------
A line that says: "Vertex 		Distance from Source".
Followed by N lines, each containing the vertex number and its shortest distance from the source.

Constraints:
------------
*1 <= N <= 100
*0 <= graph[i][j] <= 1000
*0 <= src < N
*All weights are non-negative integers.

Sample Input-1:
---------------
5
0 6 5 0 13
6 0 12 9 5
5 12 0 0 0
0 9 0 0 7
13 5 0 7 0
2

Sample Output-1:
----------------
Vertex           Distance from Source
0                5
1                11
2                0
3                20
4                16

Sample Input-2:
---------------
9
0 4 0 0 0 0 0 8 0
4 0 8 0 0 0 0 11 0
0 8 0 7 0 4 0 0 2
0 0 7 0 9 14 0 0 0
0 0 0 9 0 10 0 0 0
0 0 4 14 10 0 2 0 0
0 0 0 0 0 2 0 1 6
8 11 0 0 0 0 1 0 7
0 0 2 0 0 0 6 7 0
5

Sample Output-2:
----------------
Vertex           Distance from Source
0                11
1                12
2                4
3                11
4                10
5                0
6                2
7                3
8                6
  */
import java.util.*;

public class Dijkstra {
    private static void shortestDistance(int adjMat[][],int v,int source) {
        PriorityQueue<List<Integer>> minQueue = new PriorityQueue<>(
        new Comparator<List<Integer>>() {
        @Override
        public int compare(List<Integer> a , List<Integer> b) {
            return Integer.compare(a.get(1),b.get(1));
        }
    });
    Set<Integer> visited = new HashSet<>();
    Map<Integer,Integer> map = new HashMap<>();
    for (int i = 0; i < v; i++) {
        map.put(i,(i==source)?0:Integer.MAX_VALUE);
    }
    minQueue.add(Arrays.asList(source,0));
    while(!minQueue.isEmpty()){
        int row = minQueue.peek().get(0);
        int w = minQueue.peek().get(1);
        minQueue.poll();
        visited.add(row);
        for (int i = 0; i < v; i++) {
            if(adjMat[row][i]!=0){
                if(map.get(i)>(w+adjMat[row][i])){
                    map.put(i, w+adjMat[row][i]);
                    if(!visited.contains(i)){
                        minQueue.add(Arrays.asList(i,map.get(i)));
                    }
                }
            
            }
        }

    }

    System.out.println("Vertex           Distance from Source");
    for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
        System.out.println(entry.getKey()+"                "+entry.getValue());
    }

    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int adjMat[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adjMat[i][j] = cin.nextInt();
            }
        }
        int source = cin.nextInt();
        shortestDistance(adjMat,n,source);
        cin.close();
    }
}
