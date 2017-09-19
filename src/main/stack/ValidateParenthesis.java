package main.stack;

import java.util.Stack;

/*
    Given an expression string exp , write a program to examine
    whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.

    For example, the program should print true for exp = “[()]{}{[()()]()}”
    and false for exp = “[(])”

    http://www.geeksforgeeks.org/?p=6547
 */
public class ValidateParenthesis {

    static String input = "{[](){}}";

    public static void main(String []args){

        Stack<Character> stack = new Stack<>();
        int stringLength = input.length();

        for(int i=0;i<stringLength; i++){
            if (input.charAt(i) == '{' || input.charAt(i) == '[' || input.charAt(i) == '('){
                stack.push(input.charAt(i));
            } else if(input.charAt(i) == '}'){
                char top = stack.pop();
                if(top == '{'){
                    continue;
                } else {
                    System.out.println("Incorrect expression");
                    System.exit(0);
                }
            }else if(input.charAt(i) == ']'){
                char top = stack.pop();
                if(top == '['){
                    continue;
                } else {
                    System.out.println("Incorrect expression");
                    System.exit(0);
                }
            }else if(input.charAt(i) == ')'){
                char top = stack.pop();
                if(top == '('){
                    continue;
                } else {
                    System.out.println("Incorrect expression");
                    System.exit(0);
                }
            }
        }
        if(stack.empty() == true){
            System.out.println("Correct expression");
        } else {
            System.out.println("Incorrect expression");
        }

    }
}
