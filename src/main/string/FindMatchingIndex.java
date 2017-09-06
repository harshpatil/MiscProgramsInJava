package main.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by HarshPatil on 2/10/17.
 */
public class FindMatchingIndex {


    public static void main(String args[]) throws Exception {

        System.out.print("Enter input String ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int result = findMatchingIndex(input);
        System.out.println("Last matching index ::: " + result);
    }

    private static int findMatchingIndex(String input) {

        int index=-1;
        Stack stack = new Stack();
        for(int i=0;i<input.length();i++){
            char a = input.charAt(i);
            if(Character.isUpperCase(a)){
                stack.push(a);
            }else if(!stack.isEmpty()){
                char element = (char) stack.pop();
                if(element==Character.toUpperCase(a)){
                    index=i;
                }
            }else{
                break;
            }

        }
        return index;
    }
}
