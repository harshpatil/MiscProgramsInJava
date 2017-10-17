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

        System.out.println("Minimum cost to reach (2,2) is " + findMinCost(cost, 2,2));
    }

    private static int findMinCost(int[][] cost, int rowIndex, int columnIndex) {

        int totalCost = cost[0][0];

        for(int i=0; i<rowIndex; i++){
            for(int j=0; j<columnIndex; j++){
                totalCost = totalCost + Math.min(cost[i+1][j], Math.min(cost[i][j+1], cost[i+1][j+1]));
            }
        }
        return totalCost;
    }
}
