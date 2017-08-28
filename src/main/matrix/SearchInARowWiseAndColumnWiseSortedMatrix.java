package main.matrix;

/**
 *
     Input : mat[4][4] = { {10, 20, 30, 40},
     {15, 25, 35, 45},
     {27, 29, 37, 48},
     {32, 33, 39, 50}};
     x = 29
     Output : Found at (2, 1)

     Input : mat[4][4] = { {10, 20, 30, 40},
     {15, 25, 35, 45},
     {27, 29, 37, 48},
     {32, 33, 39, 50}};
     x = 100
     Output : Element not found

    Complexity : O(n) [Linear Time]
 */
public class SearchInARowWiseAndColumnWiseSortedMatrix {

    public static void main(String []args){
        int[][] inputMatrix = { {10, 20, 30, 40},
                                {15, 25, 35, 45},
                                {27, 29, 37, 48},
                                {32, 33, 39, 50} };

        int searchItem = 35;
        search(inputMatrix, searchItem);
    }

    public static void search(int[][] inputMatrix, int searchItem){
        int matrixLength = inputMatrix.length;
        int i=0;
        int j=matrixLength-1;
        while (i<matrixLength && j>-1){
            if(inputMatrix[i][j] == searchItem){
                System.out.println(searchItem + " Found at :: matrix[" + i +"]["+ j + "]");
                System.exit(0);
            }
            if(inputMatrix[i][j] > searchItem){
                j--;
            } else if(inputMatrix[i][j] < searchItem){
                i++;
            }
        }
        System.out.println(searchItem + " not found");
    }
}
