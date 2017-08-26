package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by HarshPatil on 10/28/16.
 */
public class IOInJava {

    public static void main(String args[]) throws IOException{

        System.out.println("Enter input ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        System.out.println("You entered ::: " + input);

        System.out.println("Enter input ::: ");
        Scanner scanner = new Scanner(System.in);
        String scannerInput = scanner.nextLine();
        System.out.println("You entered ::: " + scannerInput);

        System.out.println("Enter input ::: ");
        Scanner scanner2 = new Scanner(System.in);
        while (scanner2.hasNext()){
            String scannerIn = scanner2.next();
            System.out.println("You entered ::: " + scannerIn);
            // This always gets stuck here. Look into it.
        }
        scanner.close();
    }
}
