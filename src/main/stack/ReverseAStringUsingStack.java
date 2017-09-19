package main.stack;

import java.util.Stack;

/*
    http://www.geeksforgeeks.org/stack-set-3-reverse-string-using-stack/
 */
public class ReverseAStringUsingStack {

    public static void main(String[] args){

        String input = "GeeksQuiz";
        Stack<Character> stack = new Stack<>();

        System.out.print("Input String :: " + input);
        for (int i=0; i<input.length(); i++){
            stack.push(input.charAt(i));
        }

        System.out.print("\nReversed String :: ");
        for(int i=0; i<input.length(); i++){
            if(stack.size()!=0){
                System.out.print(stack.pop());
            } else {
                System.exit(0);
            }
        }
    }
}
