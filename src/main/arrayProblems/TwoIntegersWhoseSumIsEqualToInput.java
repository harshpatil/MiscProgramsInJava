package main.arrayProblems;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by HarshPatil on 3/31/17.
 */
public class TwoIntegersWhoseSumIsEqualToInput {

    static int array[] = {2, 5, 6, 8, 9, 10, 1, 7};

    public static void main(String []args) throws Exception {

        System.out.println("Enter an integer");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int inputSum = Integer.parseInt(input);

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
