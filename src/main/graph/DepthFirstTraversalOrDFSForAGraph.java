package main.graph;

/*
    Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree.
    The only catch here is, unlike trees, graphs may contain cycles, so we may come to the
    same node again. To avoid processing a node more than once, we use a boolean visited array.

     http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 */
public class DepthFirstTraversalOrDFSForAGraph {

    public static void main(String[] args){

        int totalNumbeOfNodes = 4;
        Graph graph = new Graph(totalNumbeOfNodes);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 0);
        addEdge(graph, 2, 3);
        addEdge(graph, 3, 3);

        int startingNode = 2;
        System.out.print("DFS travesal of graph with starting Node " + startingNode + " :: ");
        boolean visited[] = new boolean[totalNumbeOfNodes];
        dfsTraversal(graph, 2, visited);
    }

    private static void dfsTraversal(Graph graph, int i, boolean[] visited) {

        System.out.print(i + " ");
        visited[i] = true;
        for (int edge : graph.adjListArray[i]){
            if(visited[edge]==false){
                dfsTraversal(graph, edge, visited);
            }
        }
    }

    private static void addEdge(Graph graph, int src, int dest){

        graph.adjListArray[src].add(dest);
    }
}
