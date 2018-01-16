package main.machineCoding;

import java.util.LinkedHashMap;
import java.util.Map;

public class WishLRU {

    // This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    // get(key) - Get the value (will always be positive) of the key if the key exists in the cache
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

    public static void main(String[] args) throws Exception {

        int lruSize = 3;

        Object value = new Object();
        LinkedHashMap<Integer, Object> lruMap = new LinkedHashMap<>(lruSize);

        put(11, value, lruMap, lruSize);
        put(21, value, lruMap, lruSize);
        put(31, value, lruMap, lruSize);

        Object getResult = get(11, lruMap);
        System.out.println(getResult.toString());

        getResult = get(21, lruMap);
        System.out.println(getResult.toString());

        put(41, value, lruMap, lruSize);

        getResult = get(21, lruMap);
        System.out.println(getResult.toString());

    }

    private static Object get(int getElement, LinkedHashMap<Integer, Object> lruMap) throws Exception{

        if(lruMap.containsKey(getElement)){
            Object temp = lruMap.get(getElement);
            lruMap.remove(getElement);
            lruMap.put(getElement, temp);
            return temp;
        } else{
            System.out.println(getElement + " is not present in cache");
            throw new Exception("Item Not Found");
        }
    }

    private static void put(int keyToBeInserted, Object value, LinkedHashMap<Integer, Object> sourceMap, int lruSize){

        if(sourceMap.containsKey(keyToBeInserted)) {
            sourceMap.remove(keyToBeInserted);
            sourceMap.put(keyToBeInserted, value);
        }
        else if(sourceMap.size() < lruSize){
            sourceMap.put(keyToBeInserted, value);
        }
        else {

            int keyTobeRemoved = 0;
            for(Map.Entry<Integer, Object> map : sourceMap.entrySet()){
                keyTobeRemoved = map.getKey();
                break;
            }
            sourceMap.remove(keyTobeRemoved);
            sourceMap.put(keyToBeInserted, value);
        }
    }
}
