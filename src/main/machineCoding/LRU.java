package main.machineCoding;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRU {

    // This is the text editor interface.
// Anything you type or change here will be seen by the other person in real time.

// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

    // get(key) - Get the value (will always be positive) of the key if the key exists in the cache
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

    // Time Complexity : constant time

    static int lruSize = 3;
    static LinkedHashMap<Integer, String> lruMap = new LinkedHashMap<>(lruSize);


    public static void main(String[] args) throws Exception {
        put(11, "HARSH");
        put(21, "PATIL");
        put(31, "SOWMYA");

        String getResult = get(11);
        System.out.println(getResult.toString());

        getResult = get(21);
        System.out.println(getResult.toString());

        put(41, "P");

        getResult = get(31);
        System.out.println(getResult.toString());

        getResult = get(21);
        System.out.println(getResult.toString());


    }

    private static String get(int getElement) throws Exception{

        if(lruMap.containsKey(getElement)){
            String temp = lruMap.get(getElement);
            lruMap.remove(getElement);
            lruMap.put(getElement, temp);
            return temp;
        } else{
            return (getElement + " Not Found in Cache");
        }
    }

    private static void put(int keyToBeInserted, String value){

        if(lruMap.containsKey(keyToBeInserted)) {
            lruMap.remove(keyToBeInserted);
            lruMap.put(keyToBeInserted, value);
        }
        else if(lruMap.size() < lruSize){
            lruMap.put(keyToBeInserted, value);
        }
        else {
            for(Map.Entry<Integer, String> map : lruMap.entrySet()){
                lruMap.remove(map.getKey());
                break;
            }
            lruMap.put(keyToBeInserted, value);
        }
    }
}
