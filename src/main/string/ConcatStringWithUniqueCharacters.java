package main.string;


import java.util.LinkedHashMap;
import java.util.Map;

/*
    Interview Question
 */
public class ConcatStringWithUniqueCharacters {

    public static void main(String[] args){

        String s1 = "abdc23$%123";
        String s2 = "frged456*7adb43";

        System.out.println("Input String :: "+ s1 + "  " + s2);
        concatAndPrintUnique(s1,s2);
    }

    private static void concatAndPrintUnique(String s1, String s2) {

        Map<Character, Integer> map = new LinkedHashMap<>();
        for(int i=0; i<s1.length(); i++){
            if(map.containsKey(s1.charAt(i))){
                map.put(s1.charAt(i), map.get(s1.charAt(i))+1);
            }
            else {
                map.put(s1.charAt(i), 1);
            }
        }

        for(int i=0; i<s2.length(); i++){
            if(map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i), map.get(s2.charAt(i))+1);
            }
            else {
                map.put(s2.charAt(i), 1);
            }
        }


        StringBuilder result = new StringBuilder();
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                result.append(entry.getKey());
            }
        }

        System.out.println("Concatenated Unique String :: "+ result);
    }
}
