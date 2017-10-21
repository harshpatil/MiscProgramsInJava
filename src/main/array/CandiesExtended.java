package main.array;

/*
    2 students can have same score
 */
public class CandiesExtended {

    public static void main(String[] args){

        int[] array = {5,4,1,3,3,1,0,2};
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
            else if(array[i] == array[i-1]){
                result[i] = result[i-1];
            }
        }

        int sum = result[result.length-1];

        for(int i=array.length-2; i>=0; i--){
            if(array[i]>array[i+1]){
                result[i] = result[i+1] + 1;
            }
            else if(array[i] == array[i+1]){
                result[i] = result[i+1];
            }
            sum = sum + result[i];
        }
        return sum;
    }
}
