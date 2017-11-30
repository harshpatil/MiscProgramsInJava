package main.array;

/*
    Inversion Count for an array indicates – how far (or close) the array is from being sorted.
    If array is already sorted then inversion count is 0. If array is sorted in reverse order
    that inversion count is the maximum.

    Formally speaking,
        two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j

    Example:
    The sequence 2, 4, 1, 3, 5 has 3 inversions (2, 1), (4, 1), (4, 3).

    http://www.geeksforgeeks.org/counting-inversions/

 */
public class CountInversionsInAnArray {

    public static void main(String[] args){

        // With brute force
        int[] input = {2, 4, 1, 3, 5};
        findInversionCount(input);

        // Write function with better complexity

    }

    private static void findInversionCount(int[] input) {

        int count=0;
        for(int i=0; i<input.length; i++){
            for(int j=i+1; j<input.length; j++){
                if(input[i] > input[j]){
                    count++;
                }
            }
        }

        System.out.println("Number of inversions = " + count);
    }
}
