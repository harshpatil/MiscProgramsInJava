package main.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by HarshPatil on 4/2/17.
 */
public class SearchAnElementInSortedRotatedArray {

    static int array[] = {16, 20, 22, 45, 55, 2, 8, 10, 15};

    public static void main(String []args) throws Exception{

        System.out.println("Enter the element to be searched");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int searchString = Integer.parseInt(input);

        int first=0;
        int last=array.length-1;

        while (first<=last){
            int mid=(first+last)/2;
            if(array[mid] == searchString){
                System.out.println("Element "+searchString+ " found at position:"+mid);
                System.exit(0);
            }
            if(array[first] <= array[mid]){
                if(array[first] <= searchString && searchString <= array[mid]){
                    last = mid-1;
                } else {
                    first = mid+1;
                }
            } else {
                if(array[mid] <= searchString && searchString <= array[last]) {
                    first = mid+1;
                } else {
                    last = mid-1;
                }
            }
        }
        System.out.println("Element "+searchString+ " is not present in Array");
    }
}
