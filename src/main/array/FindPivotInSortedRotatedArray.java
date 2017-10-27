package main.array;

/*
    http://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
    https://www.interviewcake.com/question/java/find-rotation-point?
 */
public class FindPivotInSortedRotatedArray {

    public static void main(String []args){

        int array[] = {86, 2, 22, 45, 55, 65, 75};
        int count = countRotations(array, 0, array.length-1);
        int count2 = countRotationsWithoutRecursion(array, 0, array.length-1);
        System.out.println("Array has been rotated " + count + " times");
        System.out.println("Pivot is present at position " + count);
        System.out.println("Pivot is present at position without recursion " + count2);
    }

    private static int countRotationsWithoutRecursion(int[] array, int low, int high) {

        if (high < low){
            return 0;
        }

        while(low<=high){

            int mid=(low+high)/2;
            if (mid < high && array[mid+1] < array[mid]){
                return (mid+1);
            }

            if (mid > low && array[mid] < array[mid - 1]){
                return mid;
            }

            if (array[high] > array[mid]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return 0;
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
