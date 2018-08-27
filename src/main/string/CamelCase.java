package main.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.Character.isUpperCase;

/**
 * Alice wrote a sequence of words in CamelCase as a string of letters, , having the following properties:
 * It is a concatenation of one or more words consisting of English letters.
 * All letters in the first word are lowercase.
 * For each of the subsequent words, the first letter is uppercase and rest of the letters are lowercase.
     Given , print the number of words in  on a new line.
     Input Format
     A singly line containing string .
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

        String input = "saveChangesInTheEditor";

        int count = 0;
        for(int i=0; i<input.length(); i++){
            if(isUpperCase(input.charAt(i))){
                count++;
            }
        }

        System.out.println(count);
    }
}
