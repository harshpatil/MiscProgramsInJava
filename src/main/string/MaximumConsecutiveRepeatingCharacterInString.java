package main.string;

/*
    http://www.geeksforgeeks.org/maximum-consecutive-repeating-character-string/

    Given a string, the task is to find maximum consecutive repeating character in string.

    Note : We do not need to consider overall count, but the count of repeating that
    appear at one place.

    Examples:

    Input : str = "geeekk"
    Output : e

    Input : str = "aaaabbcbbb"
    Output : a

 */
public class MaximumConsecutiveRepeatingCharacterInString {

    public static void main(String[] args){

//        String inputString = "geeekk";
        String inputString = "bbaacccde";
//        String inputString = "aaaabbaaccde";
        System.out.println("Maximum Consecutive Repeating Character In " + inputString + " is " + findMaximumConsecutiveChar(inputString));
    }

    private static char findMaximumConsecutiveChar(String inputString) {

        char result = inputString.charAt(0);
        int count = 0;
        int currentCount = 1;

        for(int i=0; i<inputString.length(); i++){

            if(i<inputString.length()-1 && inputString.charAt(i) == inputString.charAt(i+1)){
                currentCount++;
            }
            else {
                if(currentCount>count){
                    result = inputString.charAt(i);
                    count = currentCount;
                }
                currentCount = 1;
            }
        }
        return result;
    }
}
