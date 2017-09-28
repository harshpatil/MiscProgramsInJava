package main.string;

import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

/*

    Given a number as string, remove recurring digits from the given string.
    The changes must be made in-place.
    Expected time complexity O(n) and auxiliary space O(1).

    Other approach is to use LinkedHashMap.
       Time Complexity O(n) & Space Complexity O(n)

    Examples:
        Input:  num[] = "1299888833"
        Output: num[] = "12983"

        Input:  num[] = "1299888833222"
        Output: num[] = "129832"

    http://www.geeksforgeeks.org/remove-recurring-digits-in-a-given-number/
 */
public class RemoveRecurringDigitsInAGivenNumber {

    public static void main(String[] args){
        
        String input = "1299888833";
        System.out.print("Input String :: " + input);
        removeRecurringDigit(input.toCharArray());
        removeRecurringDigitUsingLinkedHashMap(input);
    }

    private static void removeRecurringDigit(char[] input) {

        int j=0;
        for (int i=0; i<input.length; i++){
            input[j++] = input[i];
            while (i+1< input.length && input[i] == input[i+1]){
                i++;
            }
        }
        input[j]='\0';

        System.out.print("\nInput after removing duplicates :: ");
        for (int i=0; i<input.length; i++){
            if(input[i] == '\0'){
                return;
            }
            System.out.print(input[i]);
        }
    }

    private static void removeRecurringDigitUsingLinkedHashMap(String input) {

        Map<Character, Boolean> linkedHashMap = new LinkedHashMap<>();
        for (int i=0; i<input.length(); i++){
            if(!linkedHashMap.containsKey(input.charAt(i))){
                linkedHashMap.put(input.charAt(i), true);
            }
        }

        System.out.print("\nInput after removing duplicates Using Linked Hash Map :: ");
        for (Map.Entry<Character, Boolean> entry : linkedHashMap.entrySet()) {
            System.out.print(entry.getKey());
        }
    }
}
