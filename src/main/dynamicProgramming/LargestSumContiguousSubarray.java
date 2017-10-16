package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/

    Find the sum of contiguous subarray within a one-dimensional array of numbers which has
    the largest sum.

    Kadane’s Algorithm:
    Initialize:
    max_so_far = 0
    max_ending_here = 0

    Loop for each element of the array
      (a) max_ending_here = max_ending_here + a[i]
      (b) if(max_ending_here < 0)
                max_ending_here = 0
      (c) if(max_so_far < max_ending_here)
                max_so_far = max_ending_here
    return max_so_far

 */
public class LargestSumContiguousSubarray {

    public static void main(String[] args){

        int[] inputArray = {-2, -3, 4, -1, -2, 1, 5, -3};

        System.out.println("Maximum sum of subarray is ::: " + findMaxSumSubArray(inputArray));
    }

    private static int findMaxSumSubArray(int[] inputArray) {

        int current = 0;
        int sum = -1;

        for(int i=0; i<inputArray.length; i++){

            current = current + inputArray[i];

            if(current < 0){
                current = 0;
            }
            if(sum < current){
                sum = current;
            }
        }
        return sum;
    }
}
