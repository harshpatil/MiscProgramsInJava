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

 * Created by HarshPatil on 1/21/17.
 */
public class LeftRotation {

    public static void main(String []args) throws Exception {

        System.out.println("Enter Array Size and how many elements to shift left, sperated by space ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println("Enter Array Elements separated by space ::: ");
        String arrayElements = bufferedReader.readLine();

        String[] sizeAndNumberArray = input.split(" ");
        int arraySize = Integer.parseInt(sizeAndNumberArray[0]);
        int leftShiftNumber = Integer.parseInt(sizeAndNumberArray[1]);

        String[] elements = arrayElements.split(" ");
        int []inputArray = new int[arraySize];


        int result[] = new int[arraySize];

        for(int i=0; i<arraySize; i++){

            inputArray[i] = Integer.parseInt(elements[i]);
        }

        int j=0;
        for(int i=leftShiftNumber%arraySize; i<arraySize; i++){

            result[j] = inputArray[i];
            j++;
        }

        for(int i=0; i<leftShiftNumber%arraySize; i++){

            result[j] = inputArray[i];
            j++;
        }

        System.out.print("Result Array ::: ");
        for(int i=0; i<result.length; i++){

            System.out.print(result[i] + " ");
        }

    }
}
