package main.machineCoding;

/**
 *
 * Find the longest path in given Matrix
 * Constraint --> You can move to neighbouring position only if the difference is 1
 *
 */
public class LongestPathInA2DArray {

    public static void main(String[] args){
        int matrix[][] = {{1,2,5},
                          {4,3,6},
                          {9,7,8}};

        System.out.println("Length of the longest path is " + finLongestPathLength(matrix));
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
