package main.string;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by HarshPatil on 4/13/17.
 */
public class GivenAStringFindItsFirstNonRepeatingCharacter {
    /*
    Logic: 1) Create a LinkedHashMap (As it is ordered) and add read char
           2) Check if next element is present in map, if present, increase count in map
           3) Iterate through linkedHashMap and print first key whose value is == 1
    */

    static String input = "geeks for geeks";

    public static void main(String []args){

        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i=0; i<input.length(); i++){
            if(map.containsKey(Character.toLowerCase(input.charAt(i)))){
                int count = map.get(Character.toLowerCase(input.charAt(i)));
                count = count+1;
                map.put(Character.toLowerCase(input.charAt(i)), count);
            } else {
                map.put(Character.toLowerCase(input.charAt(i)), 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                System.out.println("First non repeating character is :: "+ entry.getKey());
                System.exit(0);
            }
        }
    }
}
