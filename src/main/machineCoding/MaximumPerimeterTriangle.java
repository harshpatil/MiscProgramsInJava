package main.machineCoding;

import java.util.Arrays;

/*
    MZ coding test

    https://www.hackerrank.com/challenges/maximum-perimeter-triangle/problem

    If there are several valid triangles having the maximum perimeter:

    1. Choose the one with the longest maximum side (i.e., the largest value for the longest
        side of any valid triangle having the maximum perimeter).
    2. If more than one such triangle meets the first criterion, choose the one with
        the longest minimum side (i.e., the largest value for the shortest side of any
        valid triangle having the maximum perimeter).
    3. If more than one such triangle meets the second criterion, print any one of the
        qualifying triangles.
    4. If no non-degenerate triangle exists, print -1.
 */
public class MaximumPerimeterTriangle {

    public static void main(String[] args){

        int totalNumberOfSticks = 5;
        int[] stickLengthArray = {1, 1, 1, 3, 3};
//        int[] stickLengthArray = {1, 2, 3};
        findLargestDeGenerateTriangle(stickLengthArray);
    }

    private static void findLargestDeGenerateTriangle(int[] stickLengthArray) {

        Arrays.sort(stickLengthArray);
        for(int i=stickLengthArray.length-1; i>=2; i--){
            if((stickLengthArray[i-2] + stickLengthArray[i-1]) > stickLengthArray[i]){
                System.out.print(stickLengthArray[i-2]+ " " + stickLengthArray[i-1] + " " + stickLengthArray[i]);
                return;
            }
        }
        System.out.print(-1);
    }
}
