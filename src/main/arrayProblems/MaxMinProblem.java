package main.arrayProblems;

/**
 * Created by HarshPatil on 4/2/17.
 */
public class MaxMinProblem {

    static int array[] = {10, 7, 5, 8, 11, 9};

    public static void main(String args[]){

        int max=array[0];
        int min=array[0];

        for(int i=1; i<array.length; i++){
            if(array[i] < min){
                min = array[i];
            }
            if(array[i] > max){
                max = array[i];
            }
        }

        System.out.println("Smallest element:"+ min + " & largest element:"+max);
    }
}
