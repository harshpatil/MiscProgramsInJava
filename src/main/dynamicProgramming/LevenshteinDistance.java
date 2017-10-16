package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/

    Time Complexity: O(m x n)
    Auxiliary Space: O(m x n)

 */
public class LevenshteinDistance {

    public static void main(String []args){

        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println("Cost of changing "+ str1 + " to " + str2 + " ::: "
                        + findEditDistance(str1, str2, str1.length(), str2.length()));

        System.out.println("\nOperations in converting  "+ str1 + " to " + str2 + " ::: ");
        printEditDistance(str1, str2, str1.length(), str2.length());
    }

    private static int findEditDistance(String str1, String str2, int str1length, int str2length) {

        int[][] subMatrix = new int[str1length+1][str2length+1];

        for (int i=0; i<subMatrix.length; i++){
            for (int j=0; j<subMatrix[0].length; j++){

                if(i==0){
                    subMatrix[i][j] = j;
                }
                else if(j==0){
                    subMatrix[i][j] = i;
                }
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    subMatrix[i][j] = Math.min(subMatrix[i-1][j-1], Math.min(subMatrix[i-1][j], subMatrix[i][j-1]));
                }
                else {
                    subMatrix[i][j] = 1 + Math.min(subMatrix[i-1][j-1], Math.min(subMatrix[i-1][j], subMatrix[i][j-1]));
                }
            }
        }
        return subMatrix[str1length][str2length];
    }

    private static void printEditDistance(String str1, String str2, int str1length, int str2length) {

        int[][] subMatrix = new int[str1length+1][str2length+1];

        for (int i=0; i<subMatrix.length; i++){
            for (int j=0; j<subMatrix[0].length; j++){

                if(i==0){
                    subMatrix[i][j] = j;
                }
                else if(j==0){
                    subMatrix[i][j] = i;
                }
                else if(str1.charAt(i-1) == str2.charAt(j-1)){
                    subMatrix[i][j] = Math.min(subMatrix[i-1][j-1], Math.min(subMatrix[i-1][j], subMatrix[i][j-1]));
                }
                else {
                    subMatrix[i][j] = 1 + Math.min(subMatrix[i-1][j-1], Math.min(subMatrix[i-1][j], subMatrix[i][j-1]));
                }
            }
        }

        // Below code is used for printing operations
        int i=str1length;
        int j=str2length;

        while (i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                i--;
                j--;
            }
            else if(subMatrix[i][j] == subMatrix[i-1][j-1] + 1){
                System.out.println("Replace '" + str2.charAt(j-1) + "' in "+ str2 +" with '" + str1.charAt(i-1) + "'");
                i--;
                j--;
            }
            else if(subMatrix[i][j] == subMatrix[i-1][j] + 1){
                System.out.println("Delete '"+ str1.charAt(i-1)+ "' in " +  str1);
                i--;
            }
            else if(subMatrix[i][j] == subMatrix[i][j-1] + 1){
                System.out.println("Delete '"+ str2.charAt(j-1)+ "' in " +  str2);
                j--;
            }
        }
    }
}
