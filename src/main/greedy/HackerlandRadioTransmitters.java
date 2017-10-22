package main.greedy;

import java.util.Arrays;

/*
    https://www.hackerrank.com/challenges/hackerland-radio-transmitters/problem

    Hackerland is a one-dimensional city with n houses, where each house i is located at
    some Xi on the x-axis. The Mayor wants to install radio transmitters on the roofs of
    the city's houses. Each transmitter has a range, k, meaning it can transmit a signal
    to all houses <=K units of distance away.

    Given a map of Hackerland and the value of k, can you find and print the minimum
    number of transmitters needed to cover every house in the city?
    (Every house must be covered by at least one transmitter) Each transmitter must be
    installed on top of an existing house.

    Time Complexity : O(n)
 */
public class HackerlandRadioTransmitters {

    public static void main(String[] args){

        int[] houseIndex = {7, 2, 4, 6, 5, 9, 12, 11};
        int coverage = 2;

//        int[] houseIndex = {1,2,3,4,5};
//        int coverage = 1;

        System.out.print("\nNumber of Transmitters needed = "+ findNumberOfTransmittersNeeded(houseIndex, coverage));
    }

    private static int findNumberOfTransmittersNeeded(int[] houseIndex, int coverage) {

        Arrays.sort(houseIndex);
        int numberOfTransmitters = 0;
        int i=0;
        while (i<houseIndex.length){
            numberOfTransmitters++;

            // Key is to use greedy algorithm to always place the transmitter
            // at the house furthest to the right possible to cover the range.
            int location = houseIndex[i] + coverage;
            while(i<houseIndex.length && houseIndex[i]<=location){
                i++;
            }

            // this is where we place the transmitter
            i--;
            System.out.println("Place Transmitter on house :: " + houseIndex[i]);


            //now go to the right of houseIndex[i] by k
            // because transmitter at houseIndex[i] covers houses to its right as well.
            location = houseIndex[i] + coverage;
            while(i<houseIndex.length && houseIndex[i]<=location){
                i++;
            }
        }

        return numberOfTransmitters;
    }
}
