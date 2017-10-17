package main.string;

/*
    http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/

    Given a string, find the length of the longest substring without repeating characters.

    For example, the longest substrings without repeating characters for “ABDEFGABEF” are
    “BDEFGA” and “DEFGAB”, with length 6.

    For “BBBB” the longest substring is “B”, with length 1.

    For “GEEKSFORGEEKS”, there are two longest substrings with length 7.

 */
public class LengthOfTheLongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args){

        String inputString = "ABDEFGABEF";
//        String inputString = "GEEKSFORGEEKS";

        System.out.println(" In String " + inputString + "\" longest unique substring length is " + findLengthOfLongestUniqueSubstring(inputString));
    }

    private static int findLengthOfLongestUniqueSubstring(String inputString) {

        int[] visited = new int[256];
        int currentLength = 1;
        int maxLength = 1;
        int prevIndex;

        // initialize visited array to -1
        for(int i=0; i<visited.length; i++){
            visited[i] = -1;
        }

        // mark first element visited with the idex of it's occurrence
        visited[inputString.charAt(0)] = 0;

        // Start for second element
        for(int i=1; i<inputString.length(); i++){

            prevIndex = visited[inputString.charAt(i)];

            if(prevIndex == -1 || i-currentLength > prevIndex){
                currentLength++;
            }
            else {
                if(currentLength > maxLength){
                    maxLength = currentLength;
                }
                currentLength = i - prevIndex;
            }
            visited[inputString.charAt(i)] = i;
        }

        if(currentLength > maxLength){
            maxLength = currentLength;
        }
        return maxLength;
    }
}
