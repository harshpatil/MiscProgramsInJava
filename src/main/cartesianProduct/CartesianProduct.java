package main.cartesianProduct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *  Question :
 - Implement cartesian product in any language of your choice without using for loop, arrays (Brute force).
 Input should be read from 2 flat text files.

 Solution :
 - Read all the lines from input file2 and stored it in ArrayList.
 - Read all the lines from input file1 and stored it as key in HashMap, stored above ArrayList as value for all the keys.
 - Iterated through HashMap and wrote output to file

 Assumption :
 - There are no duplicate records in one of the input file.

 Below is the performance evaluation of entire program.

 500 tuples in each input file :
 Total time taken in mili seconds :::: 297

 1000 tuples in each input file :
 Total time taken in mili seconds :::: 826

 3000 tuples in each input file :
 Total time taken in mili seconds :::: 4467

 5000 tuples in each input file :
 Total time taken in mili seconds :::: 9973

 7000 tuples in each input file :
 Total time taken in mili seconds :::: 19769

 10000 tuples in each input file :
 Total time taken in mili seconds :::: 36448

 20000 tuples in each input file :
 Total time taken in mili seconds :::: 152006

 * Created by HarshPatil on 9/28/16.
 */
public class CartesianProduct {

    String inputFile1 = "/Users/HarshPatil/passion/MiscProgramsInJava/src/res/inputFile1.txt";
    String inputFile2 = "/Users/HarshPatil/passion/MiscProgramsInJava/src/res/inputFile2.txt";
    String outputFile = "/Users/HarshPatil/passion/MiscProgramsInJava/src/res/outputFile.txt";

    public static void main(String []args) throws Exception {

        long startTime = System.currentTimeMillis();
        CartesianProduct cartesianProduct = new CartesianProduct();
        HashMap<String, ArrayList<String>> file1TupleToFile2TupleMap = cartesianProduct.readTuplesFromFlatFile();
        cartesianProduct.writeCartesianProductResultToFile(file1TupleToFile2TupleMap);
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken in mili seconds :::: "+ (endTime-startTime));
    }

    public HashMap<String, ArrayList<String>> readTuplesFromFlatFile() throws Exception{

        BufferedReader bufferedReaderFile1 = new BufferedReader(new FileReader(inputFile1));
        BufferedReader bufferedReaderFile2 = new BufferedReader(new FileReader(inputFile2));;
        String lineFromInputFile1 = "";
        String lineFromInputFile2 = "";

        HashMap<String, ArrayList<String>> file1TupleToFile2TupleMap = new HashMap<String, ArrayList<String>>();
        ArrayList<String> inputFile2Data = new ArrayList<String>();
        while ((lineFromInputFile2 = bufferedReaderFile2.readLine()) != null) {
            inputFile2Data.add(lineFromInputFile2);
        }
        while((lineFromInputFile1 = bufferedReaderFile1.readLine()) != null) {
            file1TupleToFile2TupleMap.put(lineFromInputFile1, inputFile2Data);
        }
        return file1TupleToFile2TupleMap;
    }

    public void writeCartesianProductResultToFile(HashMap<String, ArrayList<String>> file1TupleToFile2TupleMap) throws Exception {

        FileWriter fileWriter = new FileWriter(outputFile, true);
        for(Map.Entry<String, ArrayList<String>> entry : file1TupleToFile2TupleMap.entrySet()){
            Iterator<String> listIterator = entry.getValue().iterator();
            while (listIterator.hasNext()) {
                fileWriter.write(entry.getKey() + " : " + listIterator.next() + "\n");
            }
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
