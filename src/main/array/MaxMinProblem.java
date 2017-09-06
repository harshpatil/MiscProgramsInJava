package main.array;

/**
 *
 * Write an efficient function that takes stock_prices_yesterday
 * and returns the best profit I could have made
 * from 1 purchase and 1 sale of 1 Apple stock yesterday.
 *
 * Created by HarshPatil on 4/2/17.
 */
public class MaxMinProblem {

    static int array[] = {10, 7, 5, 8, 11, 9, 15};
//    static int array[] = {10, 8, 6, 4, 3, 2};

    public static void main(String args[]){

        int min=array[0];
        int profitAmount = array[1] - array[0];

        for(int i=1; i<array.length; i++){
            if(profitAmount < (array[i] - min)){
                profitAmount = (array[i]-min);
            }
            if(array[i] < min){
                min = array[i];
            }
        }
        System.out.println("Best stock purchase amount:"+ min + " & selling amount:" + (min+profitAmount) + ", Therefore profit="+profitAmount);
    }
}
