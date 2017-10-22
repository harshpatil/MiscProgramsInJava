package main.hashing;

import java.util.HashMap;
import java.util.Map;

/*
    http://www.geeksforgeeks.org/check-if-two-arrays-are-permutations-of-each-other/

    Given two unsorted arrays of same size, write a function that returns true if two arrays
    are permutations of each other, otherwise false.

    Examples:
    Input: arr1[] = {2, 1, 3, 5, 4, 3, 2}
           arr2[] = {3, 2, 2, 4, 5, 3, 1}
    Output: Yes

    Input: arr1[] = {2, 1, 3, 5,}
           arr2[] = {3, 2, 2, 4}
    Output: No

    Time Complexity : O(n)

 */
public class CheckIfTwoArraysArePermutationsOfEachOther {

    public static void main(String[] args){

//        int arr1[] = {2, 1, 3, 5};
//        int arr2[] = {3, 2, 2, 4};

        int arr1[] = {2, 1, 3, 5, 4, 3, 2};
        int arr2[] = {3, 2, 2, 4, 5, 3, 1};
        if (checkPermutations(arr1, arr2)){
            System.out.println("Given arrays are permutations of each other");
        }
        else{
            System.out.println("Given arrays are NOT permutations of each other");
        }
    }

    private static boolean checkPermutations(int[] arr1, int[] arr2) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr1.length; i++){
            if(map.containsKey(arr1[i])){
                int count = map.get(arr1[i]);
                count++;
                map.put(arr1[i], count);
            }
            else {
                map.put(arr1[i], 1);
            }
        }

        for(int i=0; i<arr2.length; i++){
            if(map.containsKey(arr2[i])){
                int count = map.get(arr2[i]);
                if(count == 0){
                    return false;
                }
                count--;
                map.put(arr2[i], count);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
