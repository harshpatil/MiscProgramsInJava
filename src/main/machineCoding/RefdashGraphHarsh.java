package main.machineCoding;

import java.util.LinkedList;
import java.util.Queue;

/*
    In a given array and start index, check if you can reach the index which has value 0.
    If yes, return true
        else return false
    You can move left/right the number of positions mentioned in the array index

    arr = [1, 3, 2, 0, 4, 2, 1]

    startIndex = 6 => true

    2 -> 0 -> 1 -> 4 -> 0
      -> 4 -> 0 -> 1 -> 4

    6 -> 5 -> 3 (0)

    info@refdash.com
*/

public class RefdashGraphHarsh {

    public static void main(String[]  args){

        int[] input = {1, 3, 2, 0, 4, 2, 1};
        int startingIndex = 6;
        System.out.println("Path from index "+ startingIndex +" to index with value 0 exists? " + checkPath(input, startingIndex));
    }

    private static boolean checkPath(int[] input, int startingIndex){

        if(startingIndex < 0 || startingIndex >= input.length){
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[input.length];
        queue.add(startingIndex);

        while(!queue.isEmpty()){

            int current = queue.poll();
            visited[current] = true;
            if(input[current] == 0){
                return true;
            }

            int leftJump = current-input[current];
            if(leftJump >= 0 && !visited[leftJump]){
                queue.add(leftJump);
            }
            int rightJump = current+input[current];
            if(rightJump < input.length && !visited[rightJump]){
                queue.add(rightJump);
            }
        }
        return false;
    }
}
