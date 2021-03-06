package main.string;

import java.util.HashSet;
import java.util.Set;

/**
 *  Check if the given String has Unique characters. You are not allowed to use extra DS.
 *
 *  You should ask if String is ASCII or Unicode. if it is Unicode, storage size
 *  will increase.
 *
 *  Time Complexity O(N), where N is length of String
 *  You can argue that time complexity is O(1) because for loop will never iterate
 *  more than 128 times.
 */

public class IsGiverStringContainsAllUniqueChar {

    public static void main(String[] args){

        String[] words = {"abcde", "hello", "apple", "kite", "padle"};

        for(String word : words){
            System.out.println("word : " + word + ", isUnique : " + isUniqueUsingSet(word));
            System.out.println("word : " + word + ", isUnique : " + isUniqueUsingArray(word));
            System.out.println("word : " + word + ", isUnique : " + isUniqueWithNoExtraSpace(word));
        }
    }

    private static boolean isUniqueUsingSet(String word) {

        if(word.length()>26){
            return true;
        }

        Set<Character> hashSet = new HashSet<>();
        for(int i=0; i<word.length(); i++){
            if(hashSet.contains(word.charAt(i))){
                return false;
            }
            else {
                hashSet.add(word.charAt(i));
            }
        }
        return true;
    }

    private static boolean isUniqueUsingArray(String word){
        boolean[] charCheck = new boolean[128];
        for(int i=0; i<word.length(); i++){
            if(charCheck[word.charAt(i)]){
                return false;
            }
            charCheck[word.charAt(i)] = true;
        }
        return true;
    }

    private static boolean isUniqueWithNoExtraSpace(String word) {

        if(word.length()>26){
            return true;
        }
        int checker = 0;
        for(int i=0; i<word.length(); i++){
            int value = (word.charAt(i)-'a');
            int leftShift = 1<<value;
            if((checker&leftShift)>0){
                return false;
            }
            checker = checker | leftShift;
        }
        return true;
    }
}
