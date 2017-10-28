package main.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    https://www.hackerrank.com/challenges/crush

    You are given a list(1-indexed) of size , initialized with zeroes. You have to perform
    operations on the list and output the maximum of final values of all the  elements in the
    list. For every operation, you are given three integers ,  and  and you have to add
    value  to all the elements ranging from index  to (both inclusive).

    For example,
    consider a list  of size . The initial list would be  = [, , ] and after performing the
    update  = , the new list would be  = [, , ]. Here, we've added value 30 to elements between
    indices 2 and 3. Note the index of the list starts from 1.

 */
public class AlgorithmicCrush {

    public static void main(String[] args){

        int n = 5;
        int[] array = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();

        List<Integer> indexAndKArray1 = new ArrayList<>();
        indexAndKArray1.add(1);
        indexAndKArray1.add(2);
        indexAndKArray1.add(100);

        List<Integer> indexAndKArray2 = new ArrayList<>();
        indexAndKArray2.add(2);
        indexAndKArray2.add(5);
        indexAndKArray2.add(100);

        List<Integer> indexAndKArray3 = new ArrayList<>();
        indexAndKArray3.add(3);
        indexAndKArray3.add(4);
        indexAndKArray3.add(100);

        map.put(1, indexAndKArray1);
        map.put(2, indexAndKArray2);
        map.put(3, indexAndKArray3);

        for(int i=0; i<array.length; i++){
            array[i] = 0;
        }
        int max = 0;

        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> index = entry.getValue();
            for(int startIndex = index.get(0)-1; startIndex<index.get(1); startIndex++){
                array[startIndex] = array[startIndex] + index.get(2);
                if(array[startIndex] > max){
                    max = array[startIndex];
                }
            }
        }

        System.out.println("Largest element is :: " + max);
    }
}
