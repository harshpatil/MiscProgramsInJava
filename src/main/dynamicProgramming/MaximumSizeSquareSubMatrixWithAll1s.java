package main.dynamicProgramming;

/**

     Given a binary matrix, find out the maximum size square sub-matrix with all 1s.
     For example, consider the below binary matrix.

        INPUT:  1 0 0 1 0
                0 1 1 1 0
                1 1 1 1 0
                0 1 1 1 0

        OUTPUT: 1 1 1
                1 1 1
                1 1 1

        Refer to --> http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaximumSizeSquareSubMatrixWithAll1s {

    public static void main(String []args){

        int[][] inputMatrix =  {{0, 1, 1, 0, 1},
                                {1, 1, 0, 1, 0},
                                {0, 1, 1, 1, 0},
                                {1, 1, 1, 1, 0},
                                {1, 1, 1, 1, 1},
                                {0, 0, 0, 0, 0}};

        printMaxSubSquareMatrix(inputMatrix);
    }

    private static void printMaxSubSquareMatrix(int[][] inputMatrix) {

        int row = inputMatrix.length;
        int column = inputMatrix[0].length;
        int subMatrix[][] = new int[row][column];

        // copy first column as is
        for(int i=0; i<column; i++){
            subMatrix[0][i] = inputMatrix[0][i];
        }

        // copy first row as is
        for (int i=0; i<row; i++){
            subMatrix[i][0] = inputMatrix[i][0];
        }

        for (int i=1; i<row; i++){
            for(int j=1; j<column; j++){
                if(inputMatrix[i][j] == 1){
                    subMatrix[i][j] = Math.min(subMatrix[i-1][j], Math.min(subMatrix[i-1][j-1], subMatrix[i][j-1])) + 1;
                } else {
                    subMatrix[i][j] = 0;
                }
            }
        }

        System.out.println("Sub matrix with weight ::: ");
        for(int i=0; i<row; i++){
            for (int j=0;j <column; j++){
                System.out.print(subMatrix[i][j] + " ");
            }
            System.out.println();
        }

        // Find the maximum entry and it's co-ordinates
        int maxEntry = subMatrix[0][0];
        int maxRowIndex = 0;
        int maxColumnIndex = 0;
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(subMatrix[i][j] > maxEntry) {
                    maxEntry = subMatrix[i][j];
                    maxRowIndex = i;
                    maxColumnIndex = j;
                }
            }
        }

        System.out.println("\nMaximum size square matrix is :: ");
        for(int i=maxRowIndex; i>maxRowIndex-maxEntry; i--){
            for (int j=maxColumnIndex; j>maxColumnIndex-maxEntry; j--){
                System.out.print(inputMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
