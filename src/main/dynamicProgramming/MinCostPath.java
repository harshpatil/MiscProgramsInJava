package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/

    Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that
    returns cost of minimum cost path to reach (m, n) from (0, 0). Each cell of the matrix
    represents a cost to traverse through that cell. Total cost of a path to reach (m, n) is
    sum of all the costs on that path (including both source and destination). You can only
    traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j),
    cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. You may assume that all costs are
    positive integers.

    Time Complexity : O(mn)
 */
public class MinCostPath {

    public static void main(String[] args){

        int[][] cost = {{1, 2, 3},
                        {4, 8, 2},
                        {1, 5, 3}};

        // he path with minimum cost is highlighted in the following figure.
        // The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).

        System.out.println("Minimum cost to reach (2,2) is " + findMinCost(cost, 2,1));
    }

    private static int findMinCost(int[][] cost, int rowIndex, int columnIndex) {

        int subMatrix[][]=new int[rowIndex+1][columnIndex+1];
        subMatrix[0][0] = cost[0][0];

        /* Initialize first column of total cost(tc) array */
        for (int i = 1; i <= rowIndex; i++){
            subMatrix[i][0] = subMatrix[i-1][0] + cost[i][0];
        }


        /* Initialize first row of tc array */
        for (int j = 1; j <= columnIndex; j++){
            subMatrix[0][j] = subMatrix[0][j-1] + cost[0][j];
        }

        /* Construct rest of the tc array */
        for(int i=1; i<=rowIndex; i++){
            for(int j=1; j<=columnIndex; j++){
                subMatrix[i][j] = cost[i][j] + Math.min(subMatrix[i-1][j-1], Math.min(subMatrix[i-1][j], subMatrix[i][j-1]));
            }
        }
        return subMatrix[rowIndex][columnIndex];
    }
}
