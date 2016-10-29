package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HarshPatil on 10/28/16.
 */
public class IOInJava {

    public static void main(String args[]) throws IOException{

        System.out.println("Input number ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println("You entered ::: " + input);
    }
}
