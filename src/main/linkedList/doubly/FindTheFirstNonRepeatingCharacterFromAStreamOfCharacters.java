package main.linkedList.doubly;

import java.util.ArrayList;
import java.util.List;

/*
    http://www.geeksforgeeks.org/find-first-non-repeating-character-stream-characters/

    Given a stream of characters, find the first non-repeating character from stream.
    You need to tell the first non-repeating character in O(1) time at any moment.

    The idea is to use a DLL (Doubly Linked List) to efficiently get the first non-repeating character
    from a stream. The DLL contains all non-repeating characters in order, i.e., the head of DLL contains
    first non-repeating character, the second node contains the second non-repeating and so on.
    We also maintain two arrays: one array is to maintain characters that are already visited two
    or more times, we call it repeated[], the other array is array of pointers to linked list nodes,
    we call it inDLL[]. The size of both arrays is equal to alphabet size which is typically 256.

    Create an empty DLL. Also create two arrays inDLL[] and repeated[] of size 256. inDLL is an array
    of pointers to DLL nodes. repeated[] is a boolean array, repeated[x] is true if x is repeated two
    or more times, otherwise false. inDLL[x] contains pointer to a DLL node if character x is present
    in DLL, otherwise NULL.

    Initialize all entries of inDLL[] as NULL and repeated[] as false.
    To get the first non-repeating character, return character at head of DLL.
    Following are steps to process a new character ‘x’ in stream.
    If repeated[x] is true, ignore this character (x is already repeated two or more times in the stream)
    If repeated[x] is false and inDLL[x] is NULL (x is seen first time). Append x to DLL and store
    address of new DLL node in inDLL[x].
    If repeated[x] is false and inDLL[x] is not NULL (x is seen second time). Get DLL node of x using
    inDLL[x] and remove the node. Also, mark inDLL[x] as NULL and repeated[x] as true.
    Note that appending a new node to DLL is O(1) operation if we maintain tail pointer. Removing a
    node from DLL is also O(1). So both operations, addition of new character and finding first
    non-repeating character take O(1) time.

 */
public class FindTheFirstNonRepeatingCharacterFromAStreamOfCharacters {

    public static void main(String[] args){

        String input = "geeksforgeeksandgeeksquizfor";
        printFirstNonRepeatingChar(input);
    }

    private static void printFirstNonRepeatingChar(String input) {

        List<Character> list = new ArrayList<>();
        boolean[] repeated = new boolean[256];

        for(int i=0; i<input.length(); i++){

            char x = input.charAt(i);
            if(!repeated[x]){
                if(!list.contains(x)){
                    list.add((Character)x);
                } else {
                    list.remove((Character) x);
                    repeated[x] = true;
                }
            }

            if(list.size() !=0){
                System.out.println("First non repeating char so far ::: " + list.get(0));
            }
        }

    }
}
