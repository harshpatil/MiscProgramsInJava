package main.dynamicProgramming;

/*
    https://www.hackerrank.com/challenges/fibonacci-modified/problem
 */
public class FibonacciModified {

    public static void main(String[] args){
        int nthFiboNumber = 6;
        System.out.println(nthFiboNumber+ " modified fibonacci number is "+findNthFiboNumberUsingTabulation(nthFiboNumber));
    }

    private static int findNthFiboNumberUsingTabulation(int nthFiboNumber) {
        int[] lookup = new int[nthFiboNumber+1];
        lookup[0] = 0;
        lookup[1] = 1;
        for(int i=2; i<lookup.length; i++){
            lookup[i] = (lookup[i-1]*lookup[i-1]) + lookup[i-2];
        }
        return lookup[nthFiboNumber-1];
    }
}
