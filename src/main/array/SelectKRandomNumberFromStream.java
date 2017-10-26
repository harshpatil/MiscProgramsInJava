package main.array;

import java.util.Arrays;
import java.util.Random;

/*
    http://www.geeksforgeeks.org/select-a-random-number-from-stream-with-o1-space/
 */
public class SelectKRandomNumberFromStream {

    public static void main(String[] args) {
        int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int n = stream.length;
        int k = 5;
        selectKItems(stream, n, k);
    }

    static void selectKItems(int stream[], int n, int k) {

        int i;

        int reservoir[] = new int[k];
        for (i = 0; i < k; i++)
            reservoir[i] = stream[i];

        Random r = new Random();
        // Iterate from the (k+1)th element to nth element
        for (; i < n; i++)
        {
            // Pick a random index from 0 to i.
            int j = r.nextInt(i + 1);

            // If the randomly  picked index is smaller than k,
            // then replace the element present at the index
            // with new element from stream
            if(j < k)
                reservoir[j] = stream[i];
        }

        System.out.println("Following are k randomly selected items");
        System.out.println(Arrays.toString(reservoir));
    }
}
