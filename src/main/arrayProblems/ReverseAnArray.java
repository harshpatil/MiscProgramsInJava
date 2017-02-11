package main.arrayProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *  The first line contains an integer, N (the number of integers in A).
    The second line contains N space-separated integers describing A.

    Sample Input
     4
     1 4 3 2

    Sample Output
     2 3 4 1

 *
 * Created by HarshPatil on 1/23/17.
 */
public class ReverseAnArray {

    public static void main(String []args) throws Exception {

        System.out.println("Enter number of array elements ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int totalNumberOfElements = Integer.parseInt(input);

        System.out.println("Enter "+ totalNumberOfElements + " numbers separated by space");
        String arrayElements = bufferedReader.readLine();

        int inputArray[] = new int[totalNumberOfElements];
        String []elements = arrayElements.split(" ");
        for(int i=0; i<totalNumberOfElements; i++){
            inputArray[i] = Integer.parseInt(elements[i]);
        }

        System.out.println("Reverse of input array");
        for(int i=inputArray.length-1; i>-1; i--){
            System.out.print(inputArray[i] + " ");
        }
    }
}
