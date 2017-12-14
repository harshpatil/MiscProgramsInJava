package main.machineCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HarshPatil on 12/13/17.
 */
public class Topfunnel {

    public static class Element{
        char alpha;
        int occurance;

        public Element(char aplha, int occurance){
            this.alpha = aplha;
            this.occurance = occurance;
        }

        public char getAlpha() {
            return alpha;
        }

        public void setAlpha(char alpha) {
            this.alpha = alpha;
        }

        public int getOccurance() {
            return occurance;
        }

        public void setOccurance(int occurance) {
            this.occurance = occurance;
        }
    }

    public static void main(String[] args) throws Exception{

        List<Element> inputList1 = new ArrayList<>();
        inputList1.add(new Element('a', 0));
        inputList1.add(new Element('b', 6));

        List<Element> inputList2 = new ArrayList<>();
        inputList2.add(new Element('b', 6));
        inputList2.add(new Element('c', 10));

        Map<Character, Integer> map1 = getCharAndItsOccurance(inputList1);
        Map<Character, Integer> map2 = getCharAndItsOccurance(inputList2);

        findCost(map1, map2);
    }

    private static Map<Character, Integer> getCharAndItsOccurance(List<Element> list){

        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<list.size(); i++){
            if(map.containsKey(list.get(i).getAlpha())){
                int count = map.get(list.get(i).getAlpha());
                count = count + list.get(i).getOccurance();
                map.put(list.get(i).getAlpha(), count);
            }
            else {
                map.put(list.get(i).getAlpha(), list.get(i).getOccurance());
            }
        }

        return map;
    }

    private static void findCost(Map<Character, Integer> map1, Map<Character, Integer> map2){

        int totalCost = 0;
        for(Map.Entry<Character, Integer> firstMap : map1.entrySet()){

            Character temp = firstMap.getKey();
            Integer value = firstMap.getValue();
            if(!map2.containsKey(temp)){
                System.out.println("Delete " + firstMap.getValue() + " " + temp +"'s");
                totalCost = totalCost + firstMap.getValue();
            }
            else {
                if(value > map2.get(temp)){
                    System.out.println("Delete " + (value-map2.get(temp))  + " " + temp +"'s");
                    totalCost = totalCost + (value-map2.get(temp));
                }
                else if(value < map2.get(temp)){
                    System.out.println("ADD " + (map2.get(temp)-value)  + " " + temp +"'s");
                    totalCost = totalCost + (map2.get(temp)-value);
                }
                map2.remove(temp);
            }
        }

        for(Map.Entry<Character, Integer> secondMap : map2.entrySet()){

            System.out.println("ADD " + secondMap.getValue()  + " " + secondMap.getKey() +"'s");
            totalCost = totalCost + secondMap.getValue();
        }


        System.out.println("Total cost == " + totalCost);

    }
}
