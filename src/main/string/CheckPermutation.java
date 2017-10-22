package main.string;

import java.util.Arrays;

/*
    Check if given 2 strings are permutation of each other

    Time Complexity : O(n) without using sort
 */
public class CheckPermutation {

    public static void main(String[] args){

        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for(String[] pair : pairs){
            System.out.println(pair[0]+" "+pair[1]+" is permutation : "+isPermutationUsingSort(pair[0], pair[1]));
            System.out.println(pair[0]+" "+pair[1]+" is permutation : "+isPermutationWithoutUsingSorting(pair[0], pair[1]));
        }
    }

    private static boolean isPermutationUsingSort(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }

        char[] s1Array = s1.toCharArray();
        Arrays.sort(s1Array);

        char[] s2Array = s2.toCharArray();
        Arrays.sort(s2Array);

        if(new String(s1Array).equals(new String(s2Array))){
            return true;
        }
        return false;

    }

    private static boolean isPermutationWithoutUsingSorting(String s1, String s2) {

        if(s1.length() != s2.length()){
            return false;
        }

        int[] asciArray = new int[128];
        for(int i=0; i<s1.length(); i++){
            asciArray[s1.charAt(i)]++;
        }

        for(int i=0; i<s2.length(); i++){
            asciArray[s2.charAt(i)]--;
            if(asciArray[s2.charAt(i)]<0){
                return false;
            }
        }
        return true;
    }

}
