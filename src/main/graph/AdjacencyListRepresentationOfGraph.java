package main.graph;

/*

    Adjacency List:
        An array of linked lists is used. Size of the array is equal to number of vertices.
        Let the array be array[]. An entry array[i] represents the linked list of vertices
        adjacent to the ith vertex. This representation can also be used to represent a
        weighted graph. The weights of edges can be stored in nodes of linked lists.

        0 ----- 1\
        |      /| \
        |     / |  \
        |    /  |   \
        |   /   |   2
        |  /    |  /
        | /     | /
        4 ----- 3/

    Pros: Saves space O(|V|+|E|) .
    In the worst case, there can be C(V, 2) number of edges in a graph thus
    consuming O(V^2) space. Adding a vertex is easier.

    Cons: Queries like whether there is an edge from vertex u to vertex v are not
    efficient and can be done O(V).

    http://www.geeksforgeeks.org/graph-and-its-representations/

 */
public class AdjacencyListRepresentationOfGraph {

    public static void main(String[] args){

        int vertices = 5;
        Graph graph = new Graph(vertices);
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 4);
        addEdge(graph, 4, 3);
        addEdge(graph, 4, 1);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 3, 2);

        System.out.println("Printing Graph's adjacency List");
        printGraph(graph);
    }

    public static void addEdge(Graph graph, int src, int dest) {

        graph.adjListArray[src].add(dest);
        graph.adjListArray[dest].add(src);
    }

    private static void printGraph(Graph graph) {

        for (int i=0; i<graph.v; i++){
            System.out.print("Vertex "+ i + " ");
            System.out.print("Head");
            for(Integer edge : graph.adjListArray[i]){
                System.out.print(" -> "+ edge);
            }
            System.out.println();
        }
    }
}
