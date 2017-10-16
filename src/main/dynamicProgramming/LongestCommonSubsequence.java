package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/longest-common-subsequence/

    Time Complexity of the above implementation is O(mn) which is much better
    than the worst case time complexity of Naive Recursive implementation.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args){

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        System.out.println("Longest common subsequence in "+ str1 + " and " + str2 + " ::: "
                + longestCommonSunsequence(str1, str2, str1.length(), str2.length()));

    }

    private static int longestCommonSunsequence(String str1, String str2, int str1Length, int str2Length) {

        int[][] subMatrix = new int[str1Length+1][str2Length+1];

        for(int i=0; i<subMatrix.length; i++){
            for(int j=0; j<subMatrix[0].length; j++){

                if(i==0 || j==0){
                    subMatrix[i][j] = 0;
                }
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    subMatrix[i][j] = 1 + subMatrix[i-1][j-1];
                }
                else {
                    subMatrix[i][j] = Math.max(subMatrix[i-1][j], subMatrix[i][j-1]);
                }
            }
        }

        return subMatrix[str1Length][str2Length];
    }
}
