package main.random;

/**
 * Created by HarshPatil on 8/22/18.
 */
public class FibonacciUsingRecursion {

    public static void main(String[] args){
        int n=4;
        int result = findFiboNumber(n);
        System.out.println(n + "th Fibonacci number is : "+ result);
    }

    private static int findFiboNumber(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return (findFiboNumber(n-1)+ findFiboNumber(n-2));
    }
}
