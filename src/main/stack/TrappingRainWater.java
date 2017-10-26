package main.stack;

/*
    Given n non-negative integers representing an elevation map where the width of
    each bar is 1, compute how much water it is able to trap after raining.

    For example,
    Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

    Time Complexity : O(n)
    Space Complexity :

    https://leetcode.com/problems/trapping-rain-water/description/
    http://www.geeksforgeeks.org/trapping-rain-water/
 */
public class TrappingRainWater {

    public static void main(String[] args){
        int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Total Amount of Water which can be stored = "+ findMaxWaterTrappingCapacity(input));
    }

    private static int findMaxWaterTrappingCapacity(int[] input) {

        int answer = 0;
        int leftMax = 0;
        int rightMax = 0;
        int leftPointer = 0;
        int rightPointer = input.length-1;

        while(leftPointer <= rightPointer){
            if(input[leftPointer] < input[rightPointer]){
                if(input[leftPointer] > leftMax){
                    leftMax = input[leftPointer];
                }
                else {
                    answer = answer + leftMax - input[leftPointer];
                    leftPointer++;
                }
            }
            else {
                if(input[rightPointer] > rightMax){
                    rightMax = input[rightPointer];
                }
                else {
                    answer = answer + rightMax - input[rightPointer];
                    rightPointer--;
                }
            }
        }
        return answer;
    }
}
