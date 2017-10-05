package main.array;

/*
    http://www.geeksforgeeks.org/find-second-largest-element-array/

    Given an array of integers, our task is to write a program that efficiently
    finds the second largest element present in the array.

    Input : arr[] = {12, 35, 1, 10, 34, 1}
    Output : The second largest element is 34.

    Input : arr[] = {10, 5, 10}
    Output : The second largest element is 5.

    Input : arr[] = {10, 10, 10}
    Output : The second largest does not exist.

 */
public class FindSecondLargestElementInAnArray {

    public static void main(String[] args){

//        int[] inputArray = {10, 5, 10};
//        int[] inputArray = {10, 10, 10};
        int[] inputArray = {12, 35, 1, 10, 34, 1};

        int n = findSecondLargest(inputArray);
        if(n==-1){
            System.out.println("There is no second largest element");
            return;
        }
        System.out.println("Second largest element is given array is " + n);
    }

    private static int findSecondLargest(int[] inputArray) {

        int first = -1;
        int second = -1;

        for(int i=0; i<inputArray.length; i++){

            if(inputArray[i] > first){
                second = first;
                first = inputArray[i];
            }
            else if(inputArray[i] < first && inputArray[i] > second){
                second = inputArray[i];
            }
        }
        if(first == second){
            return -1;
        }
        return second;
    }
}
