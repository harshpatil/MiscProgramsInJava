package main.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    http://www.geeksforgeeks.org/find-pairs-ab-cd-array-satisfy-ab-cd/

    Same as : http://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
 */
public class FindAllPairs_a_b_And_c_d_InArrayWhichSatisfy_ab_Equals_cd {

    /*
      LOGIC : 1) Create a map such that product of 2 numbers is key and those 2 int as value
              2) Iterate through list using 2 loops.
              3) If product is found in map, print both the product int and the map value
                    else, add product to map

              Time Complexity : O(n2)

          Similar problem : Find four elements a, b, c and d in an array such that a+b = c+d
     */

//    static int array[] = {3, 4, 7, 1, 2, 9, 8};
    static int array[] = {1, 2, 3, 4, 5, 6, 7, 8};

    public static void main(String []args){

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; j++){
                int product = (array[i]*array[j]);
                if(map.containsKey(product)){
                    List list = map.get(product);
                    System.out.println(array[i]+ "*" +array[j]+ " and " +list.get(0)+"*" +list.get(1));
                }else {
                    List list = new ArrayList();
                    list.add(array[i]);
                    list.add(array[j]);
                    map.put(product, list);
                }
            }
        }
    }
}
