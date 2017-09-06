package main.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by HarshPatil on 9/5/17.
 */
public class MapIterator {

    public static void main(String []args){

        Map<Integer, Integer> map = new HashMap<>();

        map.put(1, 11);
        map.put(2, 12);
        map.put(3, 13);
        map.put(4, 14);

        for(Map.Entry<Integer, Integer> mapEntry : map.entrySet()){

            System.out.println("KEY::" + mapEntry.getKey() + ", VALUE:" + mapEntry.getValue());
        }

    }
}
