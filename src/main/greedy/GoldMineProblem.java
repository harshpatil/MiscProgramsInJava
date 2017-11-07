package main.greedy;

import static sun.swing.MenuItemLayoutHelper.max;

/*

    http://www.geeksforgeeks.org/gold-mine-problem/

    Given a gold mine of n*m dimensions. Each field in this mine contains a positive
    integer which is the amount of gold in tons. Initially the miner is at first column
    but can be at any row. He can move only (right->,right up /,right down\) that is
    from a given cell, the miner can move to the cell diagonally up towards the right
    or right or diagonally down towards the right. Find out maximum amount of gold he
    can collect.

    Examples:

        Input : mat[][] = {{1, 3, 3},
                           {2, 1, 4},
                          {0, 6, 4}};
        Output : 12
        {(1,0)->(2,1)->(2,2)}

        Input: mat[][] = { {1, 3, 1, 5},
                           {2, 2, 4, 1},
                           {5, 0, 2, 3},
                           {0, 6, 1, 2}};
        Output : 16
        (2,0) -> (1,1) -> (1,2) -> (0,3) OR
        (2,0) -> (3,1) -> (2,2) -> (2,3)

        Input : mat[][] = {{10, 33, 13, 15},
                          {22, 21, 04, 1},
                          {5, 0, 2, 3},
                          {0, 6, 14, 2}};
        Output : 83

    Time Complexity : O(n) i.e number of columns
 */
public class GoldMineProblem {

    public static void main(String[] args){

        int[][] input = { {1, 3, 1, 5},
                          {2, 2, 4, 1},
                          {5, 0, 2, 3},
                          {0, 6, 1, 2}};

        findOutMaxGoldCollectable(input);
    }

    private static void findOutMaxGoldCollectable(int[][] input) {

        int sum = 0;
        int current = input[0][0];
        int row=0;
        for(int i=1; i<input.length; i++){
            if(current < input[i][0]){
                current = input[i][0];
                row = i;
            }
        }

        sum = current;
        for(int j=1; j<input[0].length; j++) {
            if (row > 0 && row < input.length - 1) {
                row = findMax(input, row, j);
                sum = sum + input[row][j];
            }
            else if (row == 0) {
                row = findMaxInTwo(input, row, row+1, j);
                sum = sum + input[row][j];
            }
            else if (row == input.length - 1) {
                row = findMaxInTwo(input, row, row-1, j);
                sum = sum + input[row][j];
            }
        }

        System.out.println("Maximum gold which can be collected = " + sum);
    }

    private static int findMax(int[][] input, int row, int j) {

        if(input[row][j] > input[row - 1][j]){
            if(input[row][j] > input[row + 1][j]){
                return row;
            } else {
                return row+1;
            }
        } else {
            if(input[row - 1][j] > input[row + 1][j]){
                return row-1;
            } else {
                return row+1;
            }
        }
    }

    private static int findMaxInTwo(int[][] input, int row, int row2, int j) {

        if(input[row][j] > input[row2][j]){
            return row;
        } else {
            return row2;
        }
    }
}
