package main.string;

import java.util.HashMap;
import java.util.Map;

/**

    Write a function to check whether two given strings are anagram of each other or not.
    An anagram of a string is another string that contains same characters,
    only the order of characters can be different.

    For example, “abcd” and “dabc” are anagram of each other.

    http://www.geeksforgeeks.org/check-whether-two-strings-are-anagram-of-each-other/

 * Created by HarshPatil on 9/3/17.
 */
public class CheckWhetherTwoStringsAreAnagramOfEachOther {

    public static void main(String []args){

        String firstString = "Triangle";
        String secondString = "Integral";
        checkAnagram(firstString, secondString);
    }

    private static void checkAnagram(String string1, String string2) {

        Map<Character, Integer> mapOfCharToOccurance = new HashMap<>();

        String firstString = string1.toLowerCase();
        String secondString = string2.toLowerCase();

        if(firstString.length() != secondString.length()){
            System.out.println(firstString + " & " + secondString + " are not anagram");
            System.exit(0);
        }

        for(int i=0; i<firstString.length(); i++){
            if(mapOfCharToOccurance.containsKey(firstString.charAt(i))){
                int count = mapOfCharToOccurance.get(firstString.charAt(i));
                count++;
                mapOfCharToOccurance.put(firstString.charAt(i), count);
            } else {
                mapOfCharToOccurance.put(firstString.charAt(i), 1);
            }
        }

        for(int i=0; i<secondString.length(); i++){
            if(mapOfCharToOccurance.containsKey(secondString.charAt(i))){
                int count = mapOfCharToOccurance.get(firstString.charAt(i));
                count--;
                mapOfCharToOccurance.put(firstString.charAt(i), count);
            } else {
                System.out.println(firstString + " & " + secondString + " are not anagram");
                System.exit(0);
            }
        }

        for(int occurence : mapOfCharToOccurance.values()){
            if(occurence != 0){
                System.out.println(firstString + " & " + secondString + " are not anagram");
                System.exit(0);
            }
        }
        System.out.println(firstString + " & " + secondString + " are anagram");

    }
}
