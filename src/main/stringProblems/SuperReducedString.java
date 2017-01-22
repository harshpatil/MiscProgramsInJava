package main.stringProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * Steve has a string, , consisting of  lowercase English alphabetic letters. In one operation,
 * he can delete any pair of adjacent letters with same value. For example, string "aabcc" would
 * become either "aab" or "bcc" after  operation.
     Steve wants to reduce  as much as possible. To do this, he will repeat the above operation as many times
     as it can be performed. Help Steve out by finding and printing 's non-reducible form!
     Note: If the final string is empty, print Empty String .
     Input Format
     A single string, .
     Constraints
     *
     Output Format
     If the final string is empty, print Empty String; otherwise, print the final non-reducible string.
     Sample Input 0
     aaabccddd
     Sample Output 0
     abd
     Sample Case 0
     Steve can perform the following sequence of operations to get the final string:
     1. aaabccddd → abccddd
     2. abccddd → abddd
     3. abddd → abd
     Thus, we print abd.
     Sample Input 1
     baab
     Sample Output 1
     Empty String
     Explanation 1
     Steve can perform the following sequence of operations to get the final string:
     1. baab → bb
     2. bb → Empty String
     Thus, we print Empty String.
     Sample Input 2
     aa
     Sample Output 2
     Empty String
     Explanation 2
     Steve can perform the following sequence of operations to get the final string:
     1. aa → Empty String
     Thus, we print Empty String.
 *
 *
 * Created by HarshPatil on 1/20/17.
 */
public class SuperReducedString {

    public static void main(String args[]) throws Exception {

        System.out.println("Enter input String ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        if(input.length() < 1 || input.length() >100){

            System.out.println("Length of input string should be between 1 to 100");
            System.exit(0);
        }

        int length = input.length();
        for(int startIndex=0; startIndex<length-1;) {

            if (input.charAt(startIndex) == input.charAt(startIndex+1)) {
                input = input.substring(0, startIndex) + input.substring(startIndex + 2);
                length = input.length();
                startIndex=0;
            } else{
                startIndex++;
            }
        }
        if(input.length() == 0){
            System.out.println("Empty String");
        }else{
            System.out.print(input);
        }
    }
}
