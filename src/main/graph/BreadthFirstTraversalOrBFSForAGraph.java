package main.graph;

import java.util.LinkedList;
import java.util.Queue;

/*
    Breadth First Traversal (or Search) for a graph is similar to Breadth First Traversal
    of a tree (See method 2 of this post). The only catch here is, unlike trees,
    graphs may contain cycles, so we may come to the same node again.
    To avoid processing a node more than once, we use a boolean visited array.

    For simplicity, it is assumed that all vertices are reachable from the starting vertex.

    http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 */
public class BreadthFirstTraversalOrBFSForAGraph {

    public static void main(String[] args){

        int totalNodes = 4;
        Graph graph = new Graph(totalNodes);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 0);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 3);

        int startingNode = 2;
        System.out.print("BFS traversal of graph with starting node "+ startingNode +" ::: ");
        printGraphUsingBFS(graph, startingNode, totalNodes);
    }

    private static void printGraphUsingBFS(Graph graph, int startingNode, int totalNodes) {

        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[totalNodes];
        queue.add(startingNode);
        while (!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp + " ");
            visited[temp] = true;

            for (int adjNode : graph.adjListArray[temp]){
                if(!visited[adjNode]){
                    queue.add(adjNode);
                }
            }
        }
    }

    private static void addEdge(Graph graph, int src, int dest){

        graph.adjListArray[src].add(dest);
    }
}
