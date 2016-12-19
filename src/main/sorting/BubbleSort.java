package main.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by HarshPatil on 12/17/16.
 */
public class BubbleSort {

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

        bubbleSort(arrayLength, inputArray);

        System.out.print("Sorted Array ::: {");
        for(int i=0; i<arrayLength; i++){

            System.out.print(inputArray[i]);
            if(i!=arrayLength-1){
                System.out.print(",");
            }
        }
        System.out.print("}");
    }

    public static void bubbleSort(int arrayLength, int[] inputArray){

        for(int i=0; i<arrayLength-1; i++){

            boolean flag = false;
            for(int j=0; j<arrayLength-i-1; j++){

                if(inputArray[j] > inputArray [j+1]){

                    int temp = inputArray[j+1];
                    inputArray[j+1] = inputArray[j];
                    inputArray[j] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                break;
            }
        }
    }
}
