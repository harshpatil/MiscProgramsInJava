package main.string;

/*
    Given a binary string, count number of substrings that start and end with 1.

    For example, if the input string is “00100101”,
    then there are three substrings “1001”, “100101” and “101”.

    We can find count in O(n) using a single traversal of input string. Following are steps.
        a) Count the number of 1’s. Let the count of 1’s be n.
        b) Return n(n-1)/2

    The idea is to count total number of possible pairs of 1’s.

    http://www.geeksforgeeks.org/given-binary-string-count-number-substrings-start-end-1/

 */
public class CountNumberOfSubstringsThatStartAndEndWith1 {

    public static void main(String[] args){

        String inputString = "00100101";

        System.out.println("Substrings starting and ending with 1 ::: " + countSubstringsStartAndEndWith1(inputString));
    }

    private static int countSubstringsStartAndEndWith1(String inputString) {

        int n=0;
        for(int i=0; i<inputString.length(); i++){
            if(inputString.charAt(i) == '1'){
                n++;
            }
        }
        return (n*(n-1)/2);

    }
}
