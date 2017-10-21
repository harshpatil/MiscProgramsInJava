package main.array;

/*
    https://www.hackerrank.com/challenges/candies/problem

    Alice is a kindergarten teacher. She wants to give some candies to the children in her class.
    All the children sit in a line (their positions are fixed), and each  of them has a rating
    score according to his or her performance in the class.  Alice wants to give at least 1 candy
    to each child. If two children sit next to each other, then the one with the higher rating
    must get more candies. Alice wants to save money, so she needs to minimize the total number
    of candies given to the children.

 */
public class Candies {

    public static void main(String[] args){

        int[] array = {5,4,1,3,4};
        System.out.print("Least number of candies required = " + distributeLeastCandies(array));
    }

    private static int distributeLeastCandies(int[] array) {

        int[] result = new int[array.length];
        result[0] = 1;

        for(int i=1; i<array.length; i++){
            result[i] = 1;
            if(array[i]>array[i-1]){
                result[i] = result[i-1] + 1;
            }
        }

        int sum = result[result.length-1];
        for(int i=array.length-2; i>=0; i--){
            if(array[i]>array[i+1]){
                result[i] = result[i+1] + 1;
            }
            sum = sum + result[i];
        }
        return sum;
    }
}
