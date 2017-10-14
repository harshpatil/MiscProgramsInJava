package main.string;

/*
    http://www.geeksforgeeks.org/divide-a-string-in-n-equal-parts/

    Question:
    Write a program to print N equal parts of a given string.

    Solution:
    1) Get the size of the string using string function strlen() (present in string.h)
    2) Get size of a part.


         part_size = string_length/n
    3) Loop through the input string. In loop, if index becomes multiple of part_size
       then put a part separator(“\n”)

 */
public class DivideAStringInNEqualParts {

    public static void main(String[] args){

        String inputString = "a_simple_divide_string_quest";
        int numberOfParts = 4;
        System.out.println("Input String :: " + inputString);
        divideStringInEqualParts(inputString, numberOfParts);
    }

    private static void divideStringInEqualParts(String inputString, int numberOfParts) {

        if(inputString.length() % numberOfParts != 0){
            System.out.println(inputString + " is not divisible into " + numberOfParts + " equal parts");
            return;
        }

        for(int i=0; i<inputString.length(); i++){
            if(i % (inputString.length()/numberOfParts)==0){
                System.out.println();
            }
            System.out.print(inputString.charAt(i));
        }
    }
}
