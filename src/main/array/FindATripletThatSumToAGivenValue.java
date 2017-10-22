package main.array;

import java.util.Arrays;

/*
    http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/

    Given an array and a value, find if there is a triplet in array whose
    sum is equal to the given value. If there is such a triplet present in array,
    then print the triplet and return true. Else return false.

    For example,
    if the given array is {12, 3, 4, 1, 6, 9}
    and given sum is 24,
    then there is a triplet (12, 3 and 9)
    present in array whose sum is 24.

    Time Complexity: O(n*n)
 */
public class FindATripletThatSumToAGivenValue {

    public static void main(String[] args){

        int[] inputArray = {12,3,4,1,6,9};
        int sum = 24;
        searchTripletWhoseSumIsEqualToGivenValue(inputArray, sum);
    }

    private static void searchTripletWhoseSumIsEqualToGivenValue(int[] inputArray, int sum) {

        Arrays.sort(inputArray);
        for(int i=0; i<inputArray.length-1; i++){
            int fixedElement = inputArray[i];
            int startIndex = i+1;
            int lastIndex = inputArray.length-1;
            while (startIndex<=lastIndex){
                int tempSum = fixedElement + inputArray[startIndex] + inputArray[lastIndex];
                if(tempSum == sum){
                    System.out.print("Triplets whose sum is " + sum + " are " + fixedElement + "," + inputArray[startIndex] + "," + inputArray[lastIndex]);
                    System.exit(0);
                }
                else if(tempSum > sum){
                    lastIndex--;
                }
                else if(tempSum<sum){
                    startIndex++;
                }
            }
        }
        System.out.print("There are no triplets whose sum is = " + sum);
    }
}
