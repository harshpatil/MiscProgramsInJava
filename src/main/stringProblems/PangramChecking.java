package main.stringProblems;

import java.util.HashSet;
import java.util.Set;

/**

    http://www.geeksforgeeks.org/pangram-checking/

    Given a string check if it is Pangram or not.
    A pangram is a sentence containing every letter in the English Alphabet.

    Examples :
    The quick brown fox jumps over the lazy dog ” is a Pangram [Contains all the characters from ‘a’ to ‘z’]
    “The quick brown fox jumps over the dog” is not a Pangram [Doesn’t contains all the characters from ‘a’ to ‘z’, as ‘l’, ‘z’, ‘y’ are missing]

 * Created by HarshPatil on 9/3/17.
 */
public class PangramChecking {

    public static void main(String[] args){

        String inputString = "The quick brown fox jumps over the lazy dog";
        checkPanagram(inputString);
    }

    private static void checkPanagram(String inputString) {

        String lowerCaseInput = inputString.toLowerCase().replaceAll(" ", "");
        char[] inputStringCharArray = lowerCaseInput.toCharArray();
        Set set = new HashSet();
        for(char ch: inputStringCharArray){
            set.add(ch);
        }

        if(set.size() == 26){
            System.out.println(inputString + " ::: is Panagram");
        } else {
            System.out.println(inputString + " ::: is not a Panagram");
        }
    }

}
