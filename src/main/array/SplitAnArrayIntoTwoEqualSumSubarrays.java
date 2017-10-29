package main.array;

/*
    constraint: Order of elements should not be changed
        Logic : 1) Calculate totalSum. if totalSum is odd splitting is not possible
                2) Traverse from right, calculate rightSum & leftSum (rightSum-totalSum)
                3) If leftSum == rightSum, array can be split, print elements of both arrays

    Time complexity : O(n)

 */
public class SplitAnArrayIntoTwoEqualSumSubarrays {

    static int array[] = { 1 , 2 , 3 , 4 , 5 , 5 };
//    static int array[] = {5,1,3,2,5};

    public static void main(String []args){

        System.out.print("Input Array ::: { ");
        int sum=0;
        for(int i=0; i<array.length; i++){
            sum = sum + array[i];
            System.out.print(array[i]+ " ");
        }
        System.out.println("}");

        if(sum%2 == 1){
            System.out.println("Array can not be split into 2 equal sum sub arrays");
        }else {
            int rightSum=0;
            int leftSum=0;
            for(int i=array.length-1; i>0; i--){
                rightSum = rightSum + array[i];
                leftSum = sum-rightSum;
                if(rightSum == leftSum){
                    System.out.println("Array can be broken into 2 halves");
                    System.out.print("First Array elements :: { ");
                    for(int j=0; j<i;j++){
                        System.out.print(array[j] + " ");
                    }
                    System.out.print("} \n");
                    System.out.print("Second Array elements :: { ");
                    for(int j=i; j<array.length;j++){
                        System.out.print(array[j] + " ");
                    }
                    System.out.print("} \n");
                    System.exit(0);
                }
            }
            System.out.println("Array can not be split into 2 equal sum sub arrays");
        }
    }
}
