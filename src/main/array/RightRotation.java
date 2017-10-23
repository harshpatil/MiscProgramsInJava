package main.array;

/*
    http://www.geeksforgeeks.org/c-program-cyclically-rotate-array-one/
 */
public class RightRotation {

    public static void main(String[] args){

        int inputArray[] = {1, 2, 3, 4, 5};

        int rotateByPositions = 3;
        int resultArray[] = new int[inputArray.length];

        System.out.print("Input Array :: ");
        printArray(inputArray);

        System.out.println("\nRight rotate by "+ rotateByPositions + " positions");

        int j=0;
        for(int i=inputArray.length-rotateByPositions; i<inputArray.length; i++){
            resultArray[j] = inputArray[i];
            j++;
        }

        for(int i=0; i<inputArray.length - rotateByPositions; i++){
            resultArray[j] = inputArray[i];
            j++;
        }

        System.out.print("Result Array :: ");
        printArray(resultArray);

    }

    private static void printArray(int[] array) {
        for (int i=0; i<array.length; i++){
            System.out.print(array[i] + " ");
        }
    }
}
