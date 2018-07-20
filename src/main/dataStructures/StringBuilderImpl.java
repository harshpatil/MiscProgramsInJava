package main.dataStructures;

/**
 * Implement your own string builder
 */
public class StringBuilderImpl {

    public static void main(String[] args) throws Exception {

        String word1 = "firstWord";
        char[] charArray = new char[word1.length()];
        charArray = storeFirstString(charArray, word1);

        String word2 = "secondWord";
        charArray = concatenate(charArray, word1, word2);
        System.out.println("Concatenated String :::: ");
        for(int i=0; i<charArray.length; i++){
            System.out.print(charArray[i]);
        }

        String word3 = "thirdWord";
        charArray = concatenate(charArray, word1+word2, word3);
        System.out.println("\nConcatenated 3rd String :::: ");
        for(int i=0; i<charArray.length; i++){
            System.out.print(charArray[i]);
        }
    }

    private static char[] storeFirstString(char[] charArray, String word){
        for(int i=0; i<word.length(); i++){
            charArray[i] = word.charAt(i);
        }
        return charArray;
    }

    private static char[] concatenate(char[] charArray, String word1, String word2){
        charArray = new char[(word1.length()+word2.length())];
        for(int i=0;i<word1.length(); i++){
            charArray[i] = word1.charAt(i);
        }
        int j=0;
        for(int i=word1.length();i<charArray.length; i++){
            charArray[i] = word2.charAt(j);
            j++;
        }
        return charArray;
    }
}
