package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HarshPatil on 8/17/18.
 */
public class Practice {

    public static void main(String[] args){
        List<Integer> andrea = new ArrayList<>();
        andrea.add(1);
        andrea.add(2);
        andrea.add(3);

        List<Integer> maria = new ArrayList<>();
        maria.add(2);
        maria.add(1);
        maria.add(3);
        System.out.println(winner(andrea, maria, "Odd"));

    }

    private static String winner(List<Integer> andrea, List<Integer> maria, String s) {
        int andreaScore = 0;
        int mariaScore = 0;
        if(s.equals("Even")){
            int i=0;
            while(i<andrea.size()){
                andreaScore = andreaScore + (andrea.get(i) - maria.get(i));
                mariaScore = mariaScore + (maria.get(i) - andrea.get(i));
                i=i+2;
            }
        }
        else if(s.equals("Odd")){
            int i=1;
            while(i<andrea.size()){
                andreaScore = andreaScore + (andrea.get(i) - maria.get(i));
                mariaScore = mariaScore + (maria.get(i) - andrea.get(i));
                i=i+2;
            }
        }
        if(andreaScore == mariaScore){
            return "Tie";
        } else if(andreaScore > mariaScore){
            return "Andrea";
        } else {
            return "Maria";
        }
    }

}


