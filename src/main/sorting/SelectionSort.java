package main.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by HarshPatil on 12/18/16.
 */
public class SelectionSort {

    public static void main(String args[]) throws Exception {

        System.out.println("Enter total number of elements");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String totalElements = bufferedReader.readLine();
        int arrayLength = Integer.parseInt(totalElements);

        int inputArray[] = new int[arrayLength];
        System.out.println("Enter "+ arrayLength + " integers");
        for(int i=0; i<arrayLength; i++){

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            inputArray[i] = Integer.parseInt(bufferedReader.readLine());
        }

        System.out.print("Input Array ::: {");
        for(int i=0; i<arrayLength; i++){

            System.out.print(inputArray[i]);
            if(i!=arrayLength-1){
                System.out.print(",");
            }
        }
        System.out.print("}\n");

        selectionSort(arrayLength, inputArray);

        System.out.print("Sorted Array ::: {");
        for(int i=0; i<arrayLength; i++){

            System.out.print(inputArray[i]);
            if(i!=arrayLength-1){
                System.out.print(",");
            }
        }
        System.out.print("}");
    }

    public static void selectionSort(int arrayLength, int[] inputArray){

        for(int i=0; i<arrayLength-1; i++){

            int min = i;
            for(int j=i; j<arrayLength; j++){

                if(inputArray[min] > inputArray[j]){

                    min = j;
                }
            }
            int temp = inputArray[i];
            inputArray[i] = inputArray[min];
            inputArray[min] = temp;
        }
    }
}
