package main.graph;

/*
    http://www.geeksforgeeks.org/sum-dependencies-graph/

    Given a directed and connected graph with n nodes. If there is an edge
    from u to v then u depends on v. Our task was to find out the sum of
    dependencies for every node.


    Example:

    For the graph in diagram,
    A depends on C and D i.e. 2
    B depends on D i.e. 1
    C depends on D i.e. 1
    And D depends on none.
    Hence answer -> 0 + 1 + 1 + 2 = 4

 */
public class SumOfDependenciesInAGraph {

    public static void main(String[] args){

        int vertices = 4;
        Graph graph = new Graph(vertices);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);
        addEdge(graph, 2, 3);

        System.out.println("Sum of dependencies = " + findDependencySum(graph));
    }

    private static int findDependencySum(Graph graph) {
        int sum =0;

        for(int i=0; i<graph.v; i++){
            sum = sum + graph.adjListArray[i].size();
        }

        return sum;
    }

    private static void addEdge(Graph graph, int src, int dest){

        graph.adjListArray[src].add(dest);
    }
}
