package main.dynamicProgramming;

/*
    http://www.geeksforgeeks.org/count-strings-with-consecutive-1s/
 */
public class CountStringsWithConsecutive1s {

    public static void main(String []args){
        int n=5;
        System.out.println("Number of Strings with consecutive 1's :: "+countNumber(n));
    }

    private static int countNumber(int n) {
        int a[] = new int[n];
        int b[] = new int[n];

        a[0] = b[0] =1;
        for(int i=1;i<n;i++){
            a[i] = a[i-1]+b[i-1];
            b[i] = a[i-1];
        }
        return ((int)Math.pow(2, n) - (a[n-1]+b[n-1]));
    }

}
