package main.array;

/*
    http://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 */
public class FindPivotInSortedRotatedArray {

    public static void main(String []args){

        int array[] = {86, 2, 22, 45, 55, 65, 75};
        int count = countRotations(array, 0, array.length-1);
        System.out.println("Array has been rotated " + count + " times");
        System.out.println("Pivot is present at position " + count);
    }

    private static int countRotations(int arr[], int low, int high) {

        if (high < low){
            return 0;
        }

        if (high == low){
            return high;
        }

        int mid=(low+high)/2;
        if (mid < high && arr[mid+1] < arr[mid]){
            return (mid+1);
        }

        if (mid > low && arr[mid] < arr[mid - 1]){
            return mid;
        }

        if (arr[high] > arr[mid]){
            return countRotations(arr, low, mid-1);
        }

        return countRotations(arr, mid+1, high);
    }
}
