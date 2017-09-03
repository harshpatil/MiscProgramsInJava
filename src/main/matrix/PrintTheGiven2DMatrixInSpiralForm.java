package main.matrix;

/**
 *
         Input:
         1    2   3   4
         5    6   7   8
         9   10  11  12
         13  14  15  16
         Output:
         1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10


         Input:
         1   2   3   4  5   6
         7   8   9  10  11  12
         13  14  15 16  17  18
         Output:
         1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11

        http://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 *
 * Created by HarshPatil on 8/28/17.
 */
public class PrintTheGiven2DMatrixInSpiralForm {

    public static void main(String []args){

        int row = 3;
        int column = 6;
        int[][] inputMatrix = { {1,  2,  3,  4,  5,  6},
                                {7,  8,  9,  10, 11, 12},
                                {13, 14, 15, 16, 17, 18}
                                };
        printMatrixInSpiralFormat(row, column, inputMatrix);
    }

    public static void printMatrixInSpiralFormat(int row, int column, int[][] inputMatrix) {

        int k=0; // starting row index
        int l=0; // starting column index

        //row - ending row index
        //column - ending column index

        while (k<row && l<column){

            for(int i=l; i<column; i++){
                System.out.print(inputMatrix[k][i] + " ");
            }
            k++;

            for(int i=k; i<row; i++){
                System.out.print(inputMatrix[i][column-1] + " ");
            }
            column--;

            if(k<row){
                for (int i=column-1; i >= l; i--) {
                    System.out.print(inputMatrix[row-1][i] + " ");
                }
                row--;
            }

            if(l<column){
                for (int i=row-1; i >= k; i--) {
                    System.out.print(inputMatrix[i][l] + " ");
                }
                l++;
            }
        }

    }
}
