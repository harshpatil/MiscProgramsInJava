package main.array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by HarshPatil on 4/2/17.
 */
public class DisplaySingleOccuringNumberInAnArray {

    static int array[] = {1, 2, 3, 5, 2, 2, 3, 4};

    public static void main(String []args){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i<array.length; i++){
            if(map.containsKey(array[i])){
                int count = map.get(array[i]);
                count = count + 1;
                map.put(array[i], count);
            }else {
                map.put(array[i], 1);
            }
        }
        Iterator iterator = map.entrySet().iterator();
        System.out.print("{");
        while (iterator.hasNext()){
            Map.Entry pair = (Map.Entry)iterator.next();
            if((int)pair.getValue() <= 1){
                System.out.print(pair.getKey() + " ");
            }
        }
        System.out.print("}");
    }
}
