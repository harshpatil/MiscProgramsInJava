package main.dynamicProgramming;

import java.util.Arrays;


/*
    http://www.geeksforgeeks.org/wildcard-pattern-matching/
    https://leetcode.com/problems/regular-expression-matching/description/

    Time complexity of above solution is O(m x n).
    Auxiliary space used is also O(m x n).
 */
public class RegularExpressionMatching {

    public static void main(String args[]) {
        String str = "aa";
        String[] patternArray = {"a", "aa", "a*"};

        for(int i=0; i<patternArray.length; i++){
            if (strMatch(str, patternArray[i], str.length(), patternArray[i].length())){
                System.out.println("Yes");
            }
            else {
                System.out.println("No");
            }
        }
    }

    private static boolean strMatch(String inputString, String pattern, int inputStringLength, int patternLength) {

        if (patternLength == 0){
            return (inputStringLength == 0);
        }

        // lookup table for storing results of
        // subproblems
        boolean[][] subMatrix = new boolean[inputStringLength + 1][patternLength + 1];

        // initailze lookup table to false
        for(int i = 0; i < inputStringLength + 1; i++){
            Arrays.fill(subMatrix[i], false);
        }

        // empty pattern can match with empty string
        subMatrix[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= patternLength; j++){
            if (pattern.charAt(j - 1) == '*')
                subMatrix[0][j] = subMatrix[0][j - 1];
        }

        // fill the table in bottom-up fashion
        for (int i = 1; i <= inputStringLength; i++) {
            for (int j = 1; j <= patternLength; j++) {
                // Two cases if we see a '*'
                // a) We ignore '*'' character and move
                //    to next  character in the pattern,
                //     i.e., '*' indicates an empty sequence.
                // b) '*' character matches with ith
                //     character in input
                if (pattern.charAt(j - 1) == '*'){
                    subMatrix[i][j] = subMatrix[i][j - 1] || subMatrix[i - 1][j];
                }

                // Current characters are considered as
                // matching in two cases
                // (a) current character of pattern is '?'
                // (b) characters actually match
                else if (pattern.charAt(j - 1) == '?' || inputString.charAt(i - 1) == pattern.charAt(j - 1)){
                    subMatrix[i][j] = subMatrix[i - 1][j - 1];
                }

                // If characters don't match
                else {
                    subMatrix[i][j] = false;
                }
            }
        }

        return subMatrix[inputStringLength][patternLength];
    }
}
