package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 */
public class LevenshteinDistance {

    public static void main(String []args){

        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println("Cost of changing "+ str1 + " to " + str2 + " ::: "
                        + findEditDistance(str1, str2, str1.length(), str2.length()));
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
}
