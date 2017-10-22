package main.string;

/*
    http://www.geeksforgeeks.org/urlify-given-string-replace-spaces/

    Time Complexity: O(n)
    Space Complexity: O(1)
 */
public class URLifyAGivenAtring_ReplaceSpacesWith_Percentage20 {

    public static void main(String[] args){

        char[] input = new String("Mr John Smith    ").toCharArray();
        System.out.print("Input String ::: "+ new String(input));
        replaceSpaceWithGivenValue(input);
    }

    private static void replaceSpaceWithGivenValue(char[] input) {

        int trueLength = new String(input).trim().length();

        int numberOfSpaces = 0;
        for(int i=0; i<trueLength; i++){
            if(input[i] == ' '){
                numberOfSpaces++;
            }
        }

        int indexToInsert = trueLength + 2*numberOfSpaces-1;
        for(int i=trueLength-1; i>=0; i--){
            if(input[i]==' '){
                input[indexToInsert-2]='%';
                input[indexToInsert-1]='2';
                input[indexToInsert]='0';
                indexToInsert = indexToInsert - 3;
            }else{
                input[indexToInsert--]=input[i];
            }
        }

        System.out.print("\nURLified String ::: "+ new String(input));
    }
}
