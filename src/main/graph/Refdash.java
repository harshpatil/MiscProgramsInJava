package main.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Refdash {

/*
arr = [1, 3, 2, 0, 4, 2, 1]

startIndex = 6 => true

2 -> 0 -> 1 -> 4 -> 0
  -> 4 -> 0 -> 1 -> 4

6 -> 5 -> 3 (0)

info@refdash.com
*/

    public static void main(String[]  args){

        int[] input = {1, 3, 2, 0, 4, 2, 1};
        int startingIndex = 2;
        System.out.println("Path from index "+ startingIndex +" to index with value 0 exists? " + checkPath(input, startingIndex));
    }

    private static boolean checkPath(int[] input, int startingIndex){

        if(startingIndex < 0 || startingIndex >= input.length){
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[input.length];
        visited[startingIndex] = true;
        queue.add(startingIndex);

        while(!queue.isEmpty()){

            int current = queue.poll();
            visited[current] = true;
            if(input[current] == 0){
                return true;
            }

            int leftJump = current-input[current];
            if(leftJump >= 0){
                if(visited[leftJump] == false){
                    queue.add(current-input[current]);
                }
            }
            int rightJump = current+input[current];
            if(rightJump < input.length){
                if(visited[rightJump] == false){
                    queue.add(current+input[current]);
                }
            }
        }
        return false;
    }
}
