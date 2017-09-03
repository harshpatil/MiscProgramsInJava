package main.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HarshPatil on 10/28/16.
 */
public class FibonacciNumber {

    public static void main(String args[]) throws IOException{

        System.out.println("Enter number to display first X fibonacci numbers");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        if(input.matches("[a-z]+") || input.matches("[A-Z]+")){
            System.out.println("Invalid input");
            return;
        } else {
            int number = Integer.parseInt(input);

            if(number == 1){
                System.out.println("Your Fibonacci series ::: 0");
            }else if(number == 2){
                System.out.println("Your Fibonacci series ::: " + "0 1");
            } else if(number > 2){
                int firstNumber = 0;
                int secondNumber = 1;
                System.out.print("Your Fibonacci series ::: 0 1");
                int nextNumber;
                int i = 2;
                while (i<number){
                    nextNumber = firstNumber + secondNumber;
                    firstNumber = secondNumber;
                    secondNumber = nextNumber;
                    System.out.print(" "+nextNumber);
                    i++;
                }
            }
        }
    }
}
