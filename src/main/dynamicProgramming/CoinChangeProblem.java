package main.dynamicProgramming;

/*
    https://www.hackerrank.com/challenges/coin-change/problem
    https://www.interviewcake.com/question/java/coin

    You have m types of coins available in infinite quantities where the value of each coin
    is given in the array C = {C0, C1, C2 ... Cm-1}. Can you determine the number of ways of
    making change for n units using the given types of coins?

    For example, if m=4, and C=[8,3,1,2], we can make change for n=3 units in
    three ways: {1,1,1}, {1,2}, and {3}.

    Time Complexity : O(array size * number of ways)
         In worst case it is O(n*n)

 */
public class CoinChangeProblem {

    public static void main(String[] args){

        int[] inputArray = {1, 2, 3};
        int n = 4;
        System.out.println("Number of ways to get change for " + n + " is " + findWays(inputArray, n));
    }

    private static int findWays(int[] inputArray, int n) {

        int[] numberOfWays = new int[n+1];
        numberOfWays[0]=1;
        for(int cent : inputArray){
            for(int i=cent; i<=n; i++){
                int remainder = i - cent;
                numberOfWays[i] = numberOfWays[i] + numberOfWays[remainder];
            }
        }
        return numberOfWays[n];
    }
}
