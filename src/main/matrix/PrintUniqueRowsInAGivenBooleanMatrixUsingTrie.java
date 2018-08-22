package main.matrix;

import java.util.HashSet;
import java.util.Set;

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

    http://www.geeksforgeeks.org/print-unique-rows/

    Time Complexity: O(row * col)
    Space Complexity: O(row)

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
        Set<String> set = new HashSet<>();
        for(int i=0; i<inputMatrix.length; i++){
            String s = "";
            for(int j=0; j<inputMatrix[0].length; j++){
                s = s+inputMatrix[i][j];
            }
            if(!set.contains(s)){
                set.add(s);
                System.out.println(s);
            }
        }
    }
}
