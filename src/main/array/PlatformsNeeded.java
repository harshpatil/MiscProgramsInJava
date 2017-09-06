package main.array;

import java.util.Arrays;

/**
 * Created by HarshPatil on 2/10/17.
 */
public class PlatformsNeeded {

    public static void main(String []args) throws Exception {

        int arrivals[] = {900, 902, 904, 906, 908, 910};
        int departures[] = {902, 904, 906, 908, 910, 912};
        int flights = 6;

        int result = findMinPlatforms(arrivals, departures, flights);

        System.out.println("Total number of platforms needed :::" + result);
    }

    static int findMinPlatforms(int[] arrivals, int[] departures, int flights) {

        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int gatesNeeded = 0;
        int result = 1;
        int i=0, j=0;
        while(i<arrivals.length && j<departures.length){
            if(arrivals[i]<=departures[j]){
                gatesNeeded++;
                if(gatesNeeded>result){
                    result = gatesNeeded;
                }
                i++;
            }else{
                gatesNeeded--;
                j++;
            }
        }
        if(i<arrivals.length){
            gatesNeeded++;
            if(gatesNeeded>result){
                result = gatesNeeded;
            }
        }
        return result;
    }
}
