package main.array;

/*

    http://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/

    Given two sorted arrays of size m and n respectively, you are tasked with
    finding the element that would be at the k’th position of the final sorted
    array.

    Examples:

    Input : Array 1 - 2 3 6 7 9
            Array 2 - 1 4 8 10
            k = 5
    Output : 6
    Explanation: The final sorted array would be -
    1, 2, 3, 4, 6, 7, 8, 9, 10
    The 5th element of this array is 6.
    Input : Array 1 - 100 112 256 349 770
            Array 2 - 72 86 113 119 265 445 892
            k = 7
    Output : 256
    Explanation: Final sorted array is -
    72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
    7th element of this array is 256.
 */
public class KthElementOfTwoSortedArrays {

    public static void main(String[] args){

        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(k + "th element in two sorted arrays is " + findKthElementIn2SortedArrays(arr1, arr2, k));
    }

    private static int findKthElementIn2SortedArrays(int[] arr1, int[] arr2, int k) {

        int[] result = new int[arr1.length + arr2.length];
        int i=0;
        int j=0;
        int r=0;
        while (i<arr1.length && j<arr2.length){

            if(arr1[i] < arr2[j]){
                result[r] = arr1[i];
                r++;
                i++;
            } else {
                result[r] = arr2[j];
                r++;
                j++;
            }
        }

        while (i<arr1.length){
            result[r] = arr1[i];
            r++;
            i++;
        }

        while (j<arr2.length){
            result[r] = arr2[j];
            r++;
            j++;
        }

        return result[k-1];
    }
}
