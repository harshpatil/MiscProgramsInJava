package main.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    http://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
    https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

    Time Complexity : O(2 * log n) => O(lon n)
 */
public class SearchAnElementInSortedRotatedArray {

    public static void main(String []args) throws Exception {

        int[] array = {16, 20, 22, 45, 55, 2, 8, 10, 15};
        int searchItem = 10;
        serachForElementUsingPivot(searchItem, array);
    }

    private static void serachForElementUsingPivot(int searchItem, int[] array){

        if(array[0] < array[array.length-1]){
            System.out.println("Array is not rotated");
            int result = binarySearch(array, 0, array.length-1, searchItem);
            if(result != -1){
                System.out.println(searchItem + " Found at position: " + result);
                return;
            }
        }
        else {
            int pivot = findPivot(array);
            if(searchItem == array[pivot]){
                System.out.println(searchItem + " Found at position: " + (pivot+1));
                return;
            }else if(searchItem <= array[array.length-1]){
                int result = binarySearch(array, pivot, array.length-1, searchItem);
                if(result != -1){
                    System.out.println(searchItem + " Found at position: " + result);
                    return;
                }
            } else {
                int result = binarySearch(array, 0, pivot-1, searchItem);
                if(result != -1){
                    System.out.println(searchItem + " Found at position: " + result);
                    return;
                }
            }
        }
        System.out.println(searchItem + " Not Found");
    }

    private static int binarySearch(int[] array, int low, int high, int searchElement){
        int result=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(searchElement == array[mid]){
                result = mid+1;
                break;
            }
            else if(searchElement < array[mid]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return result;
    }

    private static int findPivot(int[] array){
        int pivot=-1;
        int low=0;
        int high=array.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(array[mid]<array[mid-1]){
                pivot=mid-1;
                break;
            } else if(array[mid] > array[mid+1]){
                pivot=mid+1;
                break;
            } else if(array[mid] < array[high]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return pivot;
    }
}
