package main.stringProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HarshPatil on 4/13/17.
 */
public class FindTheFirstRepeatedCharacterInAString {

    /*
    Given a string, find the first repeated character in it.
    We need to find the character that occurs more than once
    and whose index of first occurrence is smallest.

    Logic: 1) Create a map and add read char
           2) Check if next element is present in map
     */

    static String input = "Hello Wold";

    public static void main(String []args){

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<input.length(); i++){
            if(map.containsKey(Character.toLowerCase(input.charAt(i)))){
                System.out.println("First repeated character is :: "+input.charAt(i));
                System.exit(0);
            }else {
                map.put(Character.toLowerCase(input.charAt(i)), 1);
            }
        }
        System.out.println("There are no repeated characters in given String");
    }
}
