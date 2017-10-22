package main.string;

import java.util.regex.Pattern;

/*

    Example: Let the input string be “i like this program very much”.
    The function should change the string to “much very program this like i”

    Input  : s = "geeks quiz practice code"
    Output : s = "code practice quiz geeks"

    Input  : s = "getting good at coding needs a lot of practice"
    Output : s = "practice of lot a needs coding at good getting"

    http://www.geeksforgeeks.org/reverse-words-in-a-given-string/

 */
public class ReverseWordsInAGivenString {

    public static void main(String[] args){

        String inputString = "I am building passion for Algorithms";
        reverseAndPrint(inputString);
    }

    private static void reverseAndPrint(String inputString) {

//        Pattern pattern = Pattern.compile(" ");
//        String[] temp = pattern.split(inputString);

        // use above one or
        String[] temp = inputString.split(" ");
        String result = "";

        for(int i=temp.length-1; i>-1; i--){
            result = result + temp[i] + " ";
        }

        System.out.println("Reverse of ::: \n" + inputString + "\n" + result);
    }
}
