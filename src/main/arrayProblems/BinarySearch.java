package main.arrayProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by HarshPatil on 4/2/17.
 */
public class BinarySearch {

    static int array[] = {2, 8, 10, 15, 16, 20, 22, 45, 55};

    public static void main(String []args) throws Exception {

        System.out.println("Enter element to be searched");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int searchNumber = Integer.parseInt(input);

        int first=0;
        int last=array.length-1;

        while (first<=last){
            int mid = (first+last)/2;
            if (array[mid] == searchNumber){
                System.out.println("Element "+searchNumber+" found at position:"+mid);
                System.exit(0);
            } else if(array[mid] > searchNumber){
                last = mid-1;
            } else if(array[mid] < searchNumber){
                first = mid+1;
            }
        }
        System.out.println(searchNumber+ " is not present in array");
    }
}
