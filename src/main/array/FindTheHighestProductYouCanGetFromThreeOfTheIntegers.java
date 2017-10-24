package main.array;

/*
    https://www.interviewcake.com/question/java/highest-product-of-3

    Given an array of integers, find the highest product you can get from three of
    the integers.

    The input arrayOfInts will always have at least three integers.

    Time Complexity: O(n)
    Space : O(1)
 */
public class FindTheHighestProductYouCanGetFromThreeOfTheIntegers {

    public static void main(String[] args){

        int[] inputArray = {2, 4, 6, 1, 2, 5};
        System.out.println("Maximum Product with any 3 integers = " + findMaxProduct(inputArray));
        System.out.println("Maximum Product with any 3 integers = " + findMaxProductHarsh(inputArray));
    }

    private static int findMaxProductHarsh(int[] inputArray) {

        if(inputArray.length < 3){
            return -1;
        }

        int first = Math.max(Math.max(inputArray[0], inputArray[1]), inputArray[2]);
        int third = Math.min(Math.min(inputArray[0], inputArray[1]), inputArray[2]);
        int second = 0;
        for(int i=0; i<3; i++){
            if(inputArray[i] != first && inputArray[i] != third){
                second = inputArray[i];
            }
        }

        int productOf3 = first*second*third;

        for(int i=3; i<inputArray.length; i++){
            int current = inputArray[i];
            if(current < third){
                continue;
            }
            else if(current > first){
                int temp = first;
                first = current;
                third = second;
                second = temp;
                productOf3 = first*second*third;
            }
            else if(current > third && current < second){
                third = current;
                productOf3 = first*second*third;
            }
            else if(current > second && current < first) {
                int temp = second;
                second = current;
                third = temp;
                productOf3 = first*second*third;
            }
        }

        return productOf3;
    }

    private static int findMaxProduct(int[] inputArray) {

        if(inputArray.length < 3){
            return -1;
        }

        int lowest = Math.max(inputArray[0], inputArray[1]);
        int highest = Math.max(inputArray[0], inputArray[1]);

        int lowestProductOf2 = lowest*highest;
        int highestProductOf2 = lowest*highest;

        int productOf3 = inputArray[0]*inputArray[1]*inputArray[2];

        for(int i=2;i<inputArray.length;i++){
            int current = inputArray[i];
            productOf3 = Math.max(
                                Math.max(current*highestProductOf2, current*lowestProductOf2)
                                , productOf3);
            highestProductOf2 = Math.max(
                                Math.max(current*highest,highestProductOf2)
                                , current*lowest);
            lowestProductOf2 = Math.min(
                                Math.min(current*lowest,lowestProductOf2)
                                , current*highest);

            highest = Math.max(current,highest);
            lowest = Math.min(current,lowest);

        }
        return productOf3;
    }

}
