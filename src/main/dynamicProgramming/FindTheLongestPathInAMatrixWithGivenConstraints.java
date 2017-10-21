package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/find-the-longest-path-in-a-matrix-with-given-constraints/

    Given a n*n matrix where all numbers are distinct, find the maximum length path
    (starting from any cell) such that all cells along the path are in increasing order
    with a difference of 1.

    We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j)
    or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent cells have
    a difference of 1.

    Example:
    Input:  mat[][] = {{1, 2, 9}
                       {5, 3, 8}
                       {4, 6, 7}}
    Output: 4
    The longest path is 6-7-8-9.

    Time complexity : O(n*n).

    This was asked in UBER telephonic round

 */
public class FindTheLongestPathInAMatrixWithGivenConstraints {

    public static void main(String[] args){

        int[][] inputMatrix = {{1, 2, 9},
                               {5, 3, 8},
                               {4, 6, 7}};

        System.out.println("Length of the longest path is " + finLongestPathLength(inputMatrix));
    }

    private static int finLongestPathLength(int[][] inputMatrix) {

        int result=0;

        int[][] subMatrix = new int[inputMatrix.length][inputMatrix[0].length];
        for(int i=0; i<subMatrix.length; i++){
            for(int j=0; j<subMatrix[0].length; j++){
                subMatrix[i][j] = -1;
            }
        }

        for(int i=0; i<inputMatrix.length; i++){
            for (int j=0; j<inputMatrix[0].length; j++){
                if(subMatrix[i][j] == -1){
                    subMatrix[i][j] = findTotalLength(i,j,inputMatrix, subMatrix);
                }
                result = Math.max(result, subMatrix[i][j]);
            }
        }
        return result;
    }

    private static int findTotalLength(int i, int j, int[][] inputMatrix, int[][] subMatrix) {

        // If this subproblem is already solved
        if(subMatrix[i][j] != -1){
            return subMatrix[i][j];
        }

        if (i>0 && (inputMatrix[i][j]+1 == inputMatrix[i-1][j]))
            return subMatrix[i][j] = 1 + findTotalLength(i-1,j,inputMatrix,subMatrix);

        if (i<inputMatrix.length-1 && (inputMatrix[i][j] +1 == inputMatrix[i+1][j]))
            return subMatrix[i][j] = 1 + findTotalLength(i+1,j,inputMatrix,subMatrix);

        if (j>0 && (inputMatrix[i][j] +1 == inputMatrix[i][j-1]))
            return subMatrix[i][j] = 1 + findTotalLength(i,j-1,inputMatrix,subMatrix);

        if (j<inputMatrix[0].length-1 && ((inputMatrix[i][j] +1) == inputMatrix[i][j+1]))
            return subMatrix[i][j] = 1 + findTotalLength(i,j+1,inputMatrix,subMatrix);

        // If none of the adjacent fours is one greater
        return subMatrix[i][j] = 1;
    }
}
