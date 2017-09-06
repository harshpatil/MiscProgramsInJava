package main.string;

import java.util.LinkedHashSet;

/**

    http://www.geeksforgeeks.org/remove-all-duplicates-from-the-input-string/

    Input: geeksforgeeks
    Output: geksfor

 * Created by HarshPatil on 9/3/17.
 */
public class RemoveAllDuplicatesFromAGivenString {

    public static void main(String[] args){
        String inputString = "geeksforgeeks";
        removeDuplicatesAndPrint(inputString);
    }

    private static void removeDuplicatesAndPrint(String inputString) {

        LinkedHashSet<Character> linkedHashSet = new LinkedHashSet<>();
        for(int i=0; i<inputString.length(); i++){
            linkedHashSet.add(inputString.charAt(i));
        }

        for (Character character : linkedHashSet){
            System.out.print(character.toString());
        }

        System.out.println("\n"+linkedHashSet.toString());
    }
}
