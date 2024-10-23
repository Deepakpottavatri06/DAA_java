/*
 You are given a connected, undirected, and weighted graph with V vertices and E edges. 
Your task is to implement Kruskal's Algorithm to find the Minimum Spanning Tree (MST) of the given graph. 
The graph is represented using an edge list, where each edge connects two vertices with a specific weight.

Kruskal’s Algorithm is a greedy algorithm that sorts all the edges in non-decreasing order of their weight and picks the smallest edge, as long as it doesn’t form a cycle with the already included edges in the MST. The algorithm stops when exactly V-1 edges have been added to the MST.

Input Format:
--------------
Line-1: Two integers V and E, where V is the number of vertices and E is the number of edges.
Line-2 to E: Three integers each: u, v, and w, where u is the source vertex, v is the destination vertex, and w is the weight of the edge connecting u and v.

Output Format:
---------------
Line-1: An integer, the Minimum Cost of the spanning tree.

Constraints:
------------
*2 ≤ V ≤ 100
*1 ≤ E ≤ V(V-1)/2
*The graph is connected and undirected.
*Weights of the edges are positive integers.

Sample Input-1:
---------------
4 5
0 1 10
0 2 6
0 3 5
1 3 15
2 3 4

Sample Output-1:
----------------
19

Sample Input-2:
---------------
3 3
0 1 1
1 2 2
0 2 3

Sample Output-2:
----------------
3

 */
import java.util.*;
class Edge {
    int src , dest , weight;
    Edge(int src,int dest,int weight){
        this.src= src;
        this.dest = dest;
        this.weight = weight;
    }
}
class Subset{
    int parent , rank;
    Subset(int parent , int rank){
        this.parent = parent;
        this.rank = rank;
    }
}
public class KruskalMST {
    private static int kMst(List<Edge> edges,int v){
        Collections.sort(edges,new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });
        int iterEdge = 0;
        int noOfEdges = 0;
        Subset [] subsets = new Subset[v];
        Edge Result [] = new Edge[v];
        for (int i = 0; i < v; i++) {
            subsets[i] = new Subset(i, 0);
        }
        
        while (noOfEdges < v-1) {
            Edge nextEdge = edges.get(iterEdge);
            int x = find(subsets, nextEdge.src);
            int y = find(subsets, nextEdge.dest);
            if(x!=y){
                Result[noOfEdges] = nextEdge;
                noOfEdges++;
                union(subsets, x, y);
            }
            iterEdge++;
        }
        int result = 0;
        for (int i = 0; i < v-1; i++) {
            // System.out.println(Result[i].src + " - "+Result[i].dest+"--"+Result[i].weight);
            result+=Result[i].weight;
        }
        return result;

    }
    private static int find(Subset [] subsets , int node){
        if(subsets[node].parent!=node){
            return find(subsets, subsets[node].parent);
        }
        return node;
    }

    private static void union(Subset [] subsets , int node1 , int node2){
        int parent1 = find(subsets, node1);
        int parent2 = find(subsets, node2);

        if(parent1!=parent2){
            if(subsets[parent1].rank > subsets[parent2].rank){
                subsets[parent2].parent = parent1;
            }
            else if(subsets[parent2].rank > subsets[parent1].rank){
                subsets[parent1].parent = parent2;
            }
            else{
                subsets[parent2].parent = parent1;
                subsets[parent1].rank++;
            }
        }
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int v = cin.nextInt();
        int e = cin.nextInt();
        cin.nextLine();
        List<Edge> l = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            String []inp = cin.nextLine().split(" ");
            int src = Integer.parseInt(inp[0]);
            int dest = Integer.parseInt(inp[1]);
            int weight = Integer.parseInt(inp[2]);
            l.add(new Edge(src, dest, weight));
        }

        System.out.println(kMst(l,v));

        cin.close();
    }
}
