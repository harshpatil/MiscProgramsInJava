package main.string;

import java.util.HashMap;
import java.util.Map;

/*

    http://www.geeksforgeeks.org/check-given-string-rotation-palindrome/

    Given a string, check if it is a rotation of a palindrome.
    Example your function should return true for “aab” as it is a rotation of “aba”.

    Time Complexity : O(n*n)

 */
public class CheckIfAGivenStringIsARotationOfAPalindrome {

    public static void main(String[] args){
        String inputString = "baaaabbb";
//        String inputString = "aabccb";
        System.out.println(inputString + "is a rotated palindrome? " + isRotationOfPalindrome(inputString));
//        checkForRotationOfAPalindrome(inputString);
    }

    private static boolean isPalindrome(String str) {
        // Start from leftmost and rightmost corners of str
        int low = 0;
        int high = str.length() - 1;

        // Keep comparing characters while they are same
        while (low < high){
            if (str.charAt(low++) != str.charAt(high--)) {
                return false;
            }
        }
        return true;
    }

    // Function to check if a given string is a rotation of a
    // palindrome
    private static boolean isRotationOfPalindrome(String str) {

        // If string itself is palindrome
        if (isPalindrome(str)) {
            return true;
        }

        // Now try all rotations one by one
        for (int i = 0; i < str.length()-1; i++) {
            String str1 = str.substring(0, i+1);
            String str2 = str.substring(i+1);

            // Check if this rotation is palindrome
            if (isPalindrome(str2 + str1)) {
                return true;
            }
        }
        return false;
    }


    private static void checkForRotationOfAPalindrome(String inputString) {

        if((inputString.length()%2) == 1){
            oddLengthInput(inputString);
        } else {
            evenLengthInput(inputString);
        }
    }

    private static void evenLengthInput(String inputString) {

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

    private static void oddLengthInput(String inputString) {
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
    }
}
