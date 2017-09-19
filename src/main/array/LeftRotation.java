package main.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 *
 *  Print a singly line of  space-separated integers denoting the final state of the array after performing  left rotations.
 *
 *  Sample Input
     5 4
     1 2 3 4 5
     Sample Output
     5 1 2 3 4

 *  http://www.geeksforgeeks.org/program-for-array-rotation-continued-reversal-algorithm/
 */
public class LeftRotation {

    public static void main(String []args) throws Exception {

        int inputArray[] = {1, 2, 3, 4, 5, 6, 7};
        int leftShiftNumber = 2;
        int result[] = new int[inputArray.length];

        System.out.print("Input Array ::: ");
        printArray(inputArray);

        System.out.println("\nLeft shift number :: " + leftShiftNumber);

        int j=0;
        for(int i=leftShiftNumber%inputArray.length; i<inputArray.length; i++){
            result[j] = inputArray[i];
            j++;
        }

        for(int i=0; i<leftShiftNumber%inputArray.length; i++){
            result[j] = inputArray[i];
            j++;
        }

        System.out.print("Result Array ::: ");
        printArray(result);
    }

    private static void printArray(int[] array) {
        for(int i=0; i<array.length; i++){

            System.out.print(array[i] + " ");
        }
    }
}
