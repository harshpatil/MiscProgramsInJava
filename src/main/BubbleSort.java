package main;

/**
 * Created by HarshPatil on 12/17/16.
 */
public class BubbleSort {

    public static void main (String args[]) throws Exception{

        int inputArray[] = {2,3,1,-5,4,8};

        int arrayLength = inputArray.length;
        System.out.print("Input Array ::: {");
        for(int i=0; i<arrayLength; i++){

            System.out.print(inputArray[i]);
            if(i!=arrayLength-1){
                System.out.print(",");
            }
        }
        System.out.print("}\n");

        for(int i=0; i<arrayLength-1; i++){

            boolean flag = false;
            for(int j=0; j<arrayLength-i-1; j++){

                if(inputArray[j] > inputArray [j+1]){

                    int temp = inputArray[j+1];
                    inputArray[j+1] = inputArray[j];
                    inputArray[j] = temp;
                    flag = true;
                }
            }
            if(flag == false){
                break;
            }
        }

        System.out.print("Sorted Array ::: {");
        for(int i=0; i<arrayLength; i++){

            System.out.print(inputArray[i]);
            if(i!=arrayLength-1){
                System.out.print(",");
            }
        }
        System.out.print("}");
    }
}
