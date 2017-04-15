package main.stringProblems;

import java.util.*;

/**
 * Created by HarshPatil on 4/14/17.
 */
public class CheckIfFrequencyOfAllCharactersCanBecomeSameByOneRemoval {

    /*
       LOGIC : 1) Create an integer array with index as ASCII value of char & occurrence as value
               2) Create a map such that occurance as key and list of char as value
               3) If map size become more than 2, then it's not possible
               4) If difference between any two non zero frequency is more than 1, it's not possible

           Time Complexity = O(n)
     */

    static String input = "xyyz";

    public static void main(String []args){
        int[] array = computeFrequencies();
        checkForFrequencymismatch(array);
    }

    private static void checkForFrequencymismatch(int[] array) {
        HashMap<Integer,List<Character>> frequencyMap = new HashMap<>();
        int firstUniqueFreqency=0;
        for(int i=0; i<array.length; i++){
            int val = array[i];
            if(val!=0){
                firstUniqueFreqency = firstUniqueFreqency==0 ?val:firstUniqueFreqency;
                if( Math.abs(firstUniqueFreqency-val)>1){
                    System.out.println("::::: NO :::::");
                    System.out.println("Frequency of all char will not become same by removal of 1 element");
                    System.exit(0);
                }
                if(!frequencyMap.containsKey(val)){
                    ArrayList<Character> characterList = new ArrayList<>();
                    characterList.add((char)(i));
                    frequencyMap.put(val,characterList);
                }else{
                    ArrayList<Character> characterList = (ArrayList<Character>) frequencyMap.get(val);
                    characterList.add((char)(i));
                }
                if(frequencyMap.size()>2){
                    System.out.println("::::: NO :::::");
                    System.out.println("Frequency of all char will not become same by removal of 1 element");
                    System.exit(0);
                }
            }
        }
        Iterator<Map.Entry<Integer,List<Character>>> it = frequencyMap.entrySet().iterator();
        char charToRemove;
        while(it.hasNext()){
            Map.Entry<Integer,List<Character>> entry = it.next();
            List<Character> chList = entry.getValue();
            if(chList.size()==1){
                charToRemove = chList.get(0);
                System.out.println("::::: YES :::::");
                System.out.println("Character to be remove "+charToRemove);
                System.exit(0);

            }
        }
        System.out.println("::::: YES :::::");
        System.out.println("Frequency of all the char is same. No need to remove any");
    }

    private static int[] computeFrequencies() {
        int array[] = new int[127];
        for(int i=0; i<input.length(); i++){
            array[input.charAt(i)]++;
        }
        return array;
    }
}
