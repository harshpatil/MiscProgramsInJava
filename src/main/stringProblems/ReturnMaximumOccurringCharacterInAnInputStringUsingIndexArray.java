package main.stringProblems;

/**
    http://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
 *
 * Created by HarshPatil on 9/5/17.
 */
public class ReturnMaximumOccurringCharacterInAnInputStringUsingIndexArray {

    public static void main(String []args){

        String input = "test";

        int[] indexArray = new int[26];
        String inputString = input.toLowerCase();
        for(int i=0; i<inputString.length(); i++){
            indexArray[inputString.charAt(i) - 'a']++;
        }

        int min=-1;
        char element = ' ';
        for(int i=0; i<inputString.length(); i++){
            if(indexArray[i] > min){
                min = indexArray[i];
                element = inputString.charAt(i);
            }
        }

        System.out.println("Maximum Occuring character :: "+ element);
    }
}
