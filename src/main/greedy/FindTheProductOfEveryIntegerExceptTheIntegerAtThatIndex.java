package main.greedy;

/*
    https://www.interviewcake.com/question/java/product-of-other-numbers

    You have an array of integers, and for each index you want to find the product of every
    integer except the integer at that index.

    Write a method getProductsOfAllIntsExceptAtIndex() that takes an array of integers and
    returns an array of the products.

    Time Complexity : O(n)

 */
public class FindTheProductOfEveryIntegerExceptTheIntegerAtThatIndex {

    public static void main(String[] args){

        int[] inputArray = {1, 7, 3, 4};
        System.out.print("Input Array :: ");
        printArray(inputArray);

        int[] result = findProductOfAllExceptTheIndex(inputArray);

        System.out.print("\nResult Array :: ");
        printArray(result);
    }

    private static int[] findProductOfAllExceptTheIndex(int[] inputArray) {

        int[] resultArray = new int[inputArray.length];

        //we find the product of all the integers before it,
        // storing the total product so far each time
        int productSoFar = 1;
        for(int i=0; i<inputArray.length; i++){
            resultArray[i] = productSoFar;
            productSoFar = productSoFar * inputArray[i];
        }

        //  we find the product of all the integers
        // after it. since each index in products already has the
        // product of all the integers before it, now we're storing
        // the total product of all other integers
        productSoFar = 1;
        for(int i=inputArray.length-1; i>=0; i--){
            resultArray[i] = resultArray[i] * productSoFar;
            productSoFar = productSoFar * inputArray[i];
        }

        return resultArray;
    }

    private static void printArray(int[] array) {

        for(int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
