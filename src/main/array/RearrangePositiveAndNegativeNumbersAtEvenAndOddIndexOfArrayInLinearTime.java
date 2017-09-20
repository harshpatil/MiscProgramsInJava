package main.array;

/*
    An array contains both positive and negative numbers in random order.
    Rearrange the array elements so that positive and negative numbers are placed alternatively.
    Number of positive and negative numbers need not be equal.
    If there are more positive numbers they appear at the end of the array.
    If there are more negative numbers, they too appear in the end of the array.

    For example,
    if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
    then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]

    http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 */
public class RearrangePositiveAndNegativeNumbersAtEvenAndOddIndexOfArrayInLinearTime {

    public static void main(String[] args){

        int inputArray[] = {-1, 2, -3, 4, 5, 6, -7, 8, 9};

        System.out.print("Input Array :: ");
        printArray(inputArray);
        rearrangePositiveNegativeToEvenOddIndexRespectively(inputArray);
        System.out.print("\nResult Array :: ");
        printArray(inputArray);
    }

    private static void rearrangePositiveNegativeToEvenOddIndexRespectively(int[] inputArray) {

        int i=-1;
        int temp=0;
        for(int j=0; j<inputArray.length; j++){
            if(inputArray[j]<0){
                i++;
                temp = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j] = temp;
            }
        }

        int evenIndex = 0;
        int positiveIndex = i+1;

        while (positiveIndex < inputArray.length && evenIndex < positiveIndex && inputArray[evenIndex] < 0){

            temp = inputArray[evenIndex];
            inputArray[evenIndex] = inputArray[positiveIndex];
            inputArray[positiveIndex] =  temp;
            evenIndex = evenIndex + 2;
            positiveIndex = positiveIndex + 1;
        }
    }

    private static void printArray(int[] array) {

        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
