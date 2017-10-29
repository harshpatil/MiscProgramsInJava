package main.array;

import java.util.Arrays;

/*
    Standard interview question

    Logic : 1) Sort the given Array
            2) start 2 pointers one from each end
            3) Add first and last element, if sum is equal to input number, print
            4) if sum is lesser than input, increment starting pointer
            5) if sum in greater than input, increment ending pointer
            6) Repeat steps from 3 till first pointer <= second pointer
               If sum =! input, then there aren't 2 such elements whose sum is equal to input int

           Time complexity : O(n) if Array is sorted
                             O(n*Logn) if Array is not sorted

 */
public class TwoIntegersWhoseSumIsEqualToInput {

    static int array[] = {2, 5, 6, 8, 9, 10, 1, 7};

    public static void main(String []args) throws Exception {

        int inputSum = 11;
        Arrays.sort(array);
        int i=0;
        int j=array.length-1;
        while(i<=j){
            if((array[i] + array[j]) == inputSum){
                System.out.println("2 numbers with sum=" + inputSum + " are :: " + array[i] + " & " + array[j]);
                System.exit(0);
            }else if((array[i] + array[j]) > inputSum){
                j=j-1;
            }else if((array[i] + array[j]) < inputSum){
                i=i+1;
            }
        }
        System.out.println("Did not find 2 integers with sum="+inputSum);
    }
}
