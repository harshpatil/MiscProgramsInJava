package main.stringProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by HarshPatil on 1/24/17.
 */
public class PrintStairCase {

    public static void main(String []args) throws Exception {

        System.out.println("Enter Number of steps ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int stairHeight = Integer.parseInt(input);

        for(int i=0; i<stairHeight; i++){

            for(int j=0; j<=stairHeight; j++){
                System.out.print(j<stairHeight-i?" ":"#");
            }
            System.out.println("");
        }
    }
}
