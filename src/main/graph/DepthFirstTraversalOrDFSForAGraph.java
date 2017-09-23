package main.graph;

/*
    Depth First Traversal (or Search) for a graph is similar to Depth First Traversal of a tree.
    The only catch here is, unlike trees, graphs may contain cycles, so we may come to the
    same node again. To avoid processing a node more than once, we use a boolean visited array.

     http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/

    http://www.geeksforgeeks.org/applications-of-depth-first-search/

    Applications of DFS
    Following are the problems that use DFS as a bulding block.

    1) For an unweighted graph, DFS traversal of the graph produces the minimum spanning
    tree and all pair shortest path tree.

    2) Detecting cycle in a graph
    A graph has cycle if and only if we see a back edge during DFS.
    So we can run DFS for the graph and check for back edges. (See this for details)

    3) Path Finding
    We can specialize the DFS algorithm to find a path between two given vertices u and z.
    i) Call DFS(G, u) with u as the start vertex.
    ii) Use a stack S to keep track of the path between the start vertex and the current vertex.
    iii) As soon as destination vertex z is encountered, return the path as the
    contents of the stack

    4) Topological Sorting
    Topological Sorting is mainly used for scheduling jobs from the given dependencies
    among jobs. In computer science, applications of this type arise in instruction
    scheduling, ordering of formula cell evaluation when recomputing formula values in
    spreadsheets, logic synthesis, determining the order of compilation tasks to perform
    in makefiles, data serialization, and resolving symbol dependencies in linkers [2].

    5) To test if a graph is bipartite
    We can augment either BFS or DFS when we first discover a new vertex, color it opposited
    its parents, and for each other edge, check it doesn’t link two vertices of the same color.
    The first vertex in any connected component can be red or black! See this for details.

    6) Finding Strongly Connected Components of a graph A directed graph is called strongly
     connected if there is a path from each vertex in the graph to every other vertex.

    7) Solving puzzles with only one solution, such as mazes.
    (DFS can be adapted to find all solutions to a maze by only including nodes on the
    current path in the visited set.)

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
