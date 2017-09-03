package main.matrix;

/**
 *
    Given a 2D array, print it in zigzag form.

     Input :
         1    2   3   4   5
         6    7   8   9   10
         11   12  13  14  15
         16  17  18  19   20
     Output :
        1 2 3 4 5 10 9 8 7 6 11 12 13 14 15 20 19 18 17 16

     Input :
         10    24   32
         50    6    17
         99    10   11
     Output :
        10 24 32 17 6 50 99 10 11


        http://www.geeksforgeeks.org/print-given-matrix-zigzag-form/

 * Created by HarshPatil on 9/2/17.
 */
public class PrintAGivenMatrixInZigzagForm {

    public static void main(String []args){
        int[][] inputMatrix = {{1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11, 12, 13, 14, 15},
                                {16, 17, 18, 19, 20}};

        printMatrixInZigzagWay(inputMatrix);
    }

    private static void printMatrixInZigzagWay(int[][] inputMatrix) {

        int row = inputMatrix.length;
        int column = inputMatrix[0].length;

        int evenRow = 0;
        int oddRow = 1;

        while(evenRow<row || oddRow <row){

            for(int i=0; i<column; i++){
                System.out.print(inputMatrix[evenRow][i] + " ");
            }
            evenRow = evenRow + 2;

            for(int i=column-1; i>=0; i--){
                System.out.print(inputMatrix[oddRow][i] + " ");
            }
            oddRow = oddRow + 2;
        }
    }
}
