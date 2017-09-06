package main.string;

/**

     Given a string, write a c function to check if it is palindrome or not.
     A string is said to be palindrome if reverse of the string is same as string.

     Example, “abba” is palindrome, but “abbc” is not palindrome.

     http://www.geeksforgeeks.org/c-program-check-given-string-palindrome/

 * Created by HarshPatil on 9/3/17.
 */
public class CheckIfAGivenStringIsPalindrome {

    public static void main(String []args){

        String inputString = "abba";
        checkPalindrome(inputString);
    }

    private static void checkPalindrome(String inputString) {

        int i=0;
        int j=inputString.length()-1;

        while(i<=j){
            if(inputString.charAt(i) != inputString.charAt(j)){
                System.out.println(inputString + " is not a Palindrome");
                System.exit(0);
            }
            i++;
            j--;
        }
        System.out.println(inputString + " is a Palindrome");
    }
}
