package main.stack;

import java.util.Stack;

/*
    http://www.geeksforgeeks.org/length-of-the-longest-valid-substring/
 */
public class LengthOfTheLongestValidSubstring {

    public static void main(String[] args){

        String inputString = "((()()";
        System.out.println("Length of Longest valid substring in "+ inputString + " is " +findMaximumLengthValidSubstring(inputString));

        inputString = "()(()))))";
        System.out.println("Length of Longest valid substring in "+ inputString + " is " + findMaximumLengthValidSubstring(inputString));

    }

    private static int findMaximumLengthValidSubstring(String inputString) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int result=0;

        for(int i=0; i<inputString.length(); i++){
            if(inputString.charAt(i) == '('){
                stack.push(i);
            }
            else {
                stack.pop();
                if(!stack.empty()){
                    result = Math.max(result, i-stack.peek());
                }
                else {
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
