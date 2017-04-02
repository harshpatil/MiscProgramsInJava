package main.arrayProblems;

/**
 * Created by HarshPatil on 4/2/17.
 */
public class FindPivotInSortedRotatedArray {

    static int array[] = {22, 45, 55, 65, 75, 86, 2};

    public static void main(String []args){

        int first = 0;
        int last = array.length-1;

        while (first<=last){
            int mid = (first+last)/2;

            if(array[first] <= array[last]){
                System.out.println("Array is not rotated");
                System.exit(0);
            }
            else if (array[mid] > array[mid+1] && mid < array.length-1) {
                System.out.println("Pivot is present at position:" + mid);
                System.exit(0);
            } else if (array[first] <= array[mid]) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
    }
}
