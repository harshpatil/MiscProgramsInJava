package main.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:
 * It is a concatenation of one or more words consisting of English letters.
 * All letters in the first word are lowercase.
 * For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
     Given , print the number of words in  on a new line.
     Input Format
     A single line containing string .
     Constraints
     *
     Output Format
     Print the number of words in string .
     Sample Input
     saveChangesInTheEditor
     Sample Output
     5
     Explanation
     String  contains five words:
     1. save
     2. Changes
     3. In
     4. The
     5. Editor
     Thus, we print  on a new line.
 * Created by HarshPatil on 1/20/17.
 */
public class CamelCase {

    public static void main(String []args) throws Exception {

        System.out.println("Enter input String ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        if(input.length()<1 || input.length()>100000){

            System.out.println("Length of input string should be between 1 to 100");
            System.exit(0);
        }

        int count = 1;
        for(int i=0; i<input.length(); i++){

            Character character = input.charAt(i);
            if(character.isUpperCase(character)){
                count++;
            }
        }

        System.out.println(count);
    }
}
