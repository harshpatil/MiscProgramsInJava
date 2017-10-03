package main.array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ReturnIndexOfHighestElementIfThereAreMultipleInstancesOfMaximumItShouldReturnWithUniformDistribution {

    public static void main(String[] args){

        int inputArray[] = {1 ,3, 2, 7, 5, 9, 9, 8};
        System.out.println("Index of Highest Element is "+ returnMaximumIndex(inputArray));
    }

    private static int returnMaximumIndex(int[] inputArray) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int highestElement = inputArray[0];
        for(int i=0; i<inputArray.length; i++){
            if(map.containsKey(inputArray[i])){
                ArrayList<Integer> arrayList = map.get(inputArray[i]);
                arrayList.add(i);
                map.put(inputArray[i], arrayList);
            }
            else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                map.put(inputArray[i], arrayList);
            }
            if(inputArray[i] > highestElement){
                highestElement = inputArray[i];
            }
        }
        ArrayList<Integer> result = map.get(highestElement);
        if(result.size() == 1){
            return result.get(0);
        }
        else {
            Random random = new Random();
            int rand = random.nextInt(result.size());
            return (result.get(rand));
        }

    }
}
