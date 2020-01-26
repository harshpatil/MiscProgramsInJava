package main.array;

/*
    http://www.geeksforgeeks.org/minimum-number-jumps-reach-endset-2on-solution/

    Given an array of integers where each element represents the max number of steps
    that can be made forward from that element. Write a function to return the
    minimum number of jumps to reach the end of the array (starting from the first
    element). If an element is 0, then cannot move through that element.

    Examples:
    Input :  {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9}
    Output :  3 (1-> 3 -> 8 -> 9)

    Time Complexity : O(n)
 */
public class MinimumNumberOfJumpsToReachEnd {

    public static void main(String[] args){

        int[] inputArray = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println("Minimum number of jumps to reach end is " + findMinNumberOfJumps(inputArray));

    }

    private static int findMinNumberOfJumps(int[] inputArray) {

        if(inputArray[0] == 0 || inputArray.length <= 1){
            return -1;
        }


        int maxReach = inputArray[0];
        int step = inputArray[0];
        int jump = 1;

        for(int i=1; i<inputArray.length; i++){

            // Check whether we reached end
            if(i == inputArray.length-1){
                return jump;
            }

            maxReach = Math.max(maxReach, i + inputArray[i]);
            step--;

            if(step == 0){
                jump++;
                if(i >= maxReach){
                    return -1;
                }
                step = maxReach - i;
            }
        }

        return -1;
    }
}


