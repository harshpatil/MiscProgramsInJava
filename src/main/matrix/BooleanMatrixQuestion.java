package main.matrix;

/**
 *
    Given a boolean matrix mat[M][N] of size M X N,
    modify it such that if a matrix cell mat[i][j] is 1 (or true)
    then make all the cells of ith row and jth column as 1.

     Example 1
     The matrix
     1 0
     0 0
     should be changed to following
     1 1
     1 0

     Example 2
     The matrix
     0 0 0
     0 0 1
     should be changed to following
     0 0 1
     1 1 1

     Example 3
     The matrix
     1 0 0 1
     0 0 1 0
     0 0 0 0
     should be changed to following
     1 1 1 1
     1 1 1 1
     1 0 1 1

    http://www.geeksforgeeks.org/a-boolean-matrix-question/

 * Created by HarshPatil on 8/28/17.
 */
public class BooleanMatrixQuestion {

    public static void main(String []args){

        int inputMatrix[ ][ ] = { {0, 0, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 0},};

        System.out.println("Given Matrix");
        printMatrix(inputMatrix, 3, 4);

        modifyMatrix(inputMatrix, 3, 4);

        System.out.println("Matrix after modification");
        printMatrix(inputMatrix, 3, 4);
    }

    private static void modifyMatrix(int[][] inputMatrix, int row, int column) {

        int[] rowArray = new int[row];
        int[] columnArray = new int[column];

        for(int i=0; i<row; i++){
            rowArray[i] = 0;
        }

        for(int i=0; i<column; i++){
            columnArray[i] = 0;
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(inputMatrix[i][j] == 1){
                    rowArray[i] = 1;
                    columnArray[j] = 1;
                }
            }
        }

        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(rowArray[i] == 1 || columnArray[j] == 1){
                    inputMatrix[i][j] = 1;
                }
            }
        }
    }

    private static void printMatrix(int[][] inputMatrix, int row, int column) {
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                System.out.print(inputMatrix[i][j]+ " ");
            }
            System.out.println();
        }
    }

}
