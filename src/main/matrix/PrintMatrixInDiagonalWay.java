package main.matrix;

/**
    Given a 2D matrix, print all elements of the given matrix in diagonal order.
    For example, consider the following 5 X 4 input matrix

     Input :
     1     2     3     4
     5     6     7     8
     9    10    11    12
     13    14    15    16
     17    18    19    20

    Output :
     1
     5     2
     9     6     3
     13    10     7     4
     17    14    11     8
     18    15    12
     19    16
     20

    http://www.geeksforgeeks.org/zigzag-or-diagonal-traversal-of-matrix/
 *
 * Created by HarshPatil on 9/2/17.
 */
public class PrintMatrixInDiagonalWay {

    public static void main(String []args){

        int[][] inputMatrix = {{1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12},
                                {13, 14, 15, 16},
                                {17, 18, 19, 20}};

        printMatrixDiagonally(inputMatrix);
    }

    private static void printMatrixDiagonally(int[][] inputMatrix) {

        int row = inputMatrix.length;
        int column = inputMatrix[0].length;

        for(int k=0; k<row; k++){
            System.out.print(inputMatrix[k][0] + " ");

            int i=k-1; // set row index for next point in diagonal
            int j=1; // set column index for next point in diagonal

            while(isValid(i, j, row, column)){
                System.out.print(inputMatrix[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }

        for (int k = 1; k < column; k++) {
            System.out.print(inputMatrix[row-1][k] + " ");

            int i = row-2; // set row index for next point in diagonal
            int j = k + 1; // set column index for next point in diagonal

            /* Print Diagonally upward */
            while (isValid(i, j, row, column)) {
                System.out.print(inputMatrix[i][j] + " ");
                i--;
                j++;
            }
            System.out.println("");
        }
    }

    private static boolean isValid(int i, int j, int row, int column) {
        return (!(i>=row || i<0 || j<0 || j>=column));
    }
}
