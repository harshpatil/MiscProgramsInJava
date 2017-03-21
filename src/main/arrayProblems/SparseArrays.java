package main.arrayProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/**
 *   There are N strings. Each string's length is no more than 20 characters. There are also Q queries.
 *   For each query, you are given a string, and you need to find out how many times this string occurred previously.
 *
 *   The first line contains N, the number of strings.
    The next N lines each contain a string.
    The N+2nd line contains Q, the number of queries.
    The following Q lines each contain a query string.
 *
 *   Sample Input
     4
     aba
     baba
     aba
     xzxb
     3
     aba
     xzxb
     ab

    Sample Output
     2
     1
     0
 *
 *
 * Created by HarshPatil on 1/21/17.
 */
public class SparseArrays {

    public static void main(String[] args) throws Exception{

        System.out.println("Enter number of Strings ::: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();

        int totalNumberOfStrings = Integer.parseInt(input);

        List<String> inputStringList = new ArrayList<String>();
        System.out.println("Enter "+ totalNumberOfStrings + " Strings");
        for(int i=0; i<totalNumberOfStrings; i++){
            inputStringList.add(bufferedReader.readLine());
        }

        System.out.println("Enter number of Strings to be seached ::: ");
        String inputNumber = bufferedReader.readLine();

        int totalSearchStrings = Integer.parseInt(inputNumber);

        List<String> searchStringList = new ArrayList<String>();
        System.out.println("Enter "+ totalSearchStrings + " search Strings");
        for(int i=0; i<totalSearchStrings; i++){
            searchStringList.add(bufferedReader.readLine());
        }

        Map<String, Integer> inputStringToCountMap = new HashMap<String, Integer>();
        for(int i=0; i<totalNumberOfStrings; i++){

            if(inputStringToCountMap.containsKey(inputStringList.get(i))){
                int count = inputStringToCountMap.get(inputStringList.get(i));
                count = count + 1;
                inputStringToCountMap.put(inputStringList.get(i), count);
            } else {
                inputStringToCountMap.put(inputStringList.get(i), 1);
            }
        }

        System.out.println("Result Count");
        for(int i=0; i<totalSearchStrings; i++){

            if(inputStringToCountMap.containsKey(searchStringList.get(i))){
                System.out.println(inputStringToCountMap.get(searchStringList.get(i)));
            }else{
                System.out.println(0);
            }
        }
    }
}
