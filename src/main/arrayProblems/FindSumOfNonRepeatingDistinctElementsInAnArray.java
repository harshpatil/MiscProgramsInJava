package main.arrayProblems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Supplier;

/**
 * Created by HarshPatil on 4/14/17.
 */
public class FindSumOfNonRepeatingDistinctElementsInAnArray {

    /*
    LOGIC : 1) Create a hashSet
            2) Add unique elements to set
            3) iterate through set and add all the elements

          Time Complexity : O(n)
     */

    static int array[] = {12, 10, 9, 45, 2, 10, 10, 45,10};
//    static int array[] = {1, 10, 9, 4, 2, 10, 10, 45, 4};

    public static void main(String []args){

        Set<Integer> hashSet = new HashSet<>();

        for(int i=0; i<array.length; i++){
            if(!hashSet.contains(array[i])){
                hashSet.add(array[i]);
            }
        }

        int sum=0;
        for (int i: hashSet) {
            sum = sum + i;
        }
        System.out.println("Sum of all unique elements = "+sum);
    }
}
