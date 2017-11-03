package main.machineCoding;

import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

public class MZLongestConsecutiveSubarry {

    public static void main(String args[]) throws Exception {

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

//        int[] input = {4, 5, 1, 5, 7, 6, 8, 4, 1};
//        int[] input = {2,1,5,6,4};
        int[] input = {1,2,3,3,4,5,6};
//        int[] input = {1, 6, 7, 9, 10, 5};

//            Scanner scanner = new Scanner(System.in);
//            String inputString = scanner.nextLine();
//            String[] elements = inputString.split(",");
//            int[] input = new int[elements.length];
//            for(int i=0; i<elements.length; i++){
//                input[i] = Integer.parseInt(elements[i].trim());
//            }

        printLongestConsecutiveNumbers(input);
    }

    private static void printLongestConsecutiveNumbers(int[] input){

        if(input.length < 1){
            System.out.println("There are no elements in the input Array");
            System.exit(0);
        }

        if(input.length == 1){
            System.out.println("Longest consecutive numbers are" + input[0]);
            System.exit(0);
        }

        Arrays.sort(input);

        List<Integer> listWithDuplicates = new ArrayList<>();
        for(int val : input){
            listWithDuplicates.add(val);
        }

        List<Integer> result = listWithDuplicates.stream().distinct().collect(Collectors.toList());

        int startIndex = 0;
        int current = 0;
        int max=0;
        for(int i=1; i<result.size(); i++){
            if(result.get(i) == (result.get(i-1) + 1)){
                current++;
                if(current > max){
                    max = current;
                    startIndex = i-current;
                }
            } else {
                current = 0;
            }
        }

        for(int i=startIndex; i<=(startIndex+max); i++){
            if(i != (startIndex+max)){
                System.out.print(result.get(i) + ",");
            } else{
                System.out.print(result.get(i));
            }
        }
    }
}