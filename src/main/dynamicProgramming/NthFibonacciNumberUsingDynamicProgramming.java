package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/dynamic-programming-set-1/
 */
public class
{

    static int nthFiboNumber = 40;
    static int[] lookup = new int[100];

    public static void main(String[] args){
        NthFibonacciNumberUsingDynamicProgramming nthFibonacciNumber = new NthFibonacciNumberUsingDynamicProgramming();
        nthFibonacciNumber.initializeLookup();
        System.out.println(nthFibonacciNumber.nthFiboNumber + "th Fibonacci number  :: "+ findNthFiboNumber(nthFibonacciNumber.nthFiboNumber));

    }

    private static int findNthFiboNumber(int nthFiboNumber) {
        if(lookup[nthFiboNumber] == -1){
            if(nthFiboNumber <= 1){
                lookup[nthFiboNumber] = nthFiboNumber;
            } else {
                lookup[nthFiboNumber] = findNthFiboNumber(nthFiboNumber-1) + findNthFiboNumber(nthFiboNumber -2);
            }
        }
        return lookup[nthFiboNumber];
    }

    private static void initializeLookup() {

        for (int i=0; i<100; i++){
            lookup[i] = -1;
        }
    }
}
