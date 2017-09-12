package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/dynamic-programming-set-1/
 */
public class NthFibonacciNumberUsingDynamicProgramming {

    static int nthFiboNumber = 40;
    static int[] lookup = new int[nthFiboNumber+1];

    public static void main(String[] args){
        NthFibonacciNumberUsingDynamicProgramming nthFibonacciNumber = new NthFibonacciNumberUsingDynamicProgramming();
        nthFibonacciNumber.initializeLookup();
        System.out.println(nthFibonacciNumber.nthFiboNumber + "th Fibonacci number using Memoization :: "+ findNthFiboNumberUsingMemoization(nthFibonacciNumber.nthFiboNumber));
        System.out.println(nthFibonacciNumber.nthFiboNumber + "th Fibonacci number using Tabulation :: "+ findNthFiboNumberUsingTabulation(nthFibonacciNumber.nthFiboNumber));

    }

    private static int findNthFiboNumberUsingMemoization(int nthFiboNumber) {
        if(lookup[nthFiboNumber] == -1){
            if(nthFiboNumber <= 1){
                lookup[nthFiboNumber] = nthFiboNumber;
            } else {
                lookup[nthFiboNumber] = findNthFiboNumberUsingMemoization(nthFiboNumber-1) + findNthFiboNumberUsingMemoization(nthFiboNumber -2);
            }
        }
        return lookup[nthFiboNumber];
    }

    private static void initializeLookup() {

        for (int i=0; i<lookup.length; i++){
            lookup[i] = -1;
        }
    }

    private static int findNthFiboNumberUsingTabulation(int nthFiboNumber) {
        int[] lookup = new int[nthFiboNumber+1];
        lookup[0] = 0;
        lookup[1] = 1;
        for(int i=2; i<lookup.length; i++){
            lookup[i] = lookup[i-1] + lookup[i-2];
        }
        return lookup[nthFiboNumber];
    }
}
