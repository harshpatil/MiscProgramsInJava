package main.stringProblems;

import java.util.HashMap;
import java.util.Map;

/**

    http://www.geeksforgeeks.org/check-given-string-rotation-palindrome/

    Given a string, check if it is a rotation of a palindrome.
    Example your function should return true for “aab” as it is a rotation of “aba”.

 * Created by HarshPatil on 9/3/17.
 */
public class CheckIfAGivenStringIsARotationOfAPalindrome {

    public static void main(String[] args){
        String inputString = "bbaaaabb";
        checkForRotationOfAPalindrome(inputString);
    }

    private static void checkForRotationOfAPalindrome(String inputString) {

        if((inputString.length()%2) == 1){
            Map<Character, Integer> charToOccurenceMap = new HashMap<>();
            for(int i=0; i<inputString.length(); i++){
                if(!charToOccurenceMap.containsKey(inputString.charAt(i))){
                    charToOccurenceMap.put(inputString.charAt(i), 1);
                } else {
                    int count = charToOccurenceMap.get(inputString.charAt(i));
                    count++;
                    charToOccurenceMap.put(inputString.charAt(i), count);
                }
            }

            for(int i=0; i<inputString.length(); i++){
                if(charToOccurenceMap.get(inputString.charAt(i))%2 == 1){
                    int index = i+(charToOccurenceMap.get(inputString.charAt(i))/2);
                    int right = (index+1)%inputString.length();
                    int left = (index+inputString.length()-1)%inputString.length();
                    int n = inputString.length()/2;
                    while(n>=0){
                        if(inputString.charAt(left) == inputString.charAt(right)){
                            left = (left+inputString.length()-1)%inputString.length();
                            right = (right+1)%inputString.length();
                            n--;
                        } else {
                            System.out.println(inputString + " is not a rotated palindrome");
                            System.exit(0);
                        }
                    }
                    System.out.println(inputString + " is a rotated palindrome");
                    System.exit(0);
                }
            }
        } else {
            for (int i=1; i<inputString.length(); i++){
                if(inputString.charAt(i-1) == inputString.charAt(i)){
                    int left = (i+inputString.length()-2)%inputString.length();
                    int right = (i+1)%inputString.length();
                    int n = inputString.length()/2;
                    while (n>=0){
                        if(inputString.charAt(left) == inputString.charAt(right)){
                            left = (left+inputString.length()-1)%inputString.length();
                            right = (right+1)%inputString.length();
                            n--;
                        } else {
                            System.out.println(inputString + " is not a rotated palindrome");
                            System.exit(0);
                        }
                    }
                    System.out.println(inputString + " is a rotated palindrome");
                    System.exit(0);
                }
            }
        }
    }
}
