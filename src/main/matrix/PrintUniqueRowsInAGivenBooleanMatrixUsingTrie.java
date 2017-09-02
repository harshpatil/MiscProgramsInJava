package main.matrix;

/**
    Given a binary matrix, print all unique rows of the given matrix.

     Input:
         {0, 1, 0, 0, 1}
         {1, 0, 1, 1, 0}
         {0, 1, 0, 0, 1}
         {1, 1, 1, 0, 0}

    Output:
         0 1 0 0 1
         1 0 1 1 0
         1 1 1 0 0

 * Created by HarshPatil on 9/2/17.
 */
public class PrintUniqueRowsInAGivenBooleanMatrixUsingTrie {

    public static void main(String []args){

        int[][] inputMatrix = {{0, 1, 0, 0, 1},
                               {1, 0, 1, 1, 0},
                               {0, 1, 0, 0, 1},
                               {1, 0, 1, 0, 0}};

        printUniqueRows(inputMatrix);
    }

    private static void printUniqueRows(int[][] inputMatrix) {

    }
}
