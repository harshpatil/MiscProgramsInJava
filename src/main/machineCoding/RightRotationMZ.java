package main.machineCoding;

import java.util.Scanner;

/*
    MZ coding test

    https://www.hackerrank.com/challenges/circular-array-rotation
 */
public class RightRotationMZ {

    public static void main(String[] args){

//        Scanner scanner = new Scanner(System.in);
//        int arrayLength = scanner.nextInt();
//        int placesToRotate = scanner.nextInt();
//        int numbersToPrint = scanner.nextInt();
//
//        scanner.nextLine();
//
//        int[] inputArray = new int[arrayLength];
//        for(int i=0; i<arrayLength; i++){
//            inputArray[i] = scanner.nextInt();
//        }
//
//        scanner.nextLine();
//
//        int[] indexToPrint = new int[numbersToPrint];
//        for(int i=0; i<numbersToPrint; i++){
//            indexToPrint[i] = Integer.parseInt(scanner.nextLine());
//        }

        int arrayLength = 6;
        int placesToRotate = 3;
        int numbersToPrint = 2;
        int[] inputArray = {16, 0, 4, 2, 14, 6};
        int[] indexToPrint = {1, 4};

        int resultArray[] = new int[arrayLength];

        for(int i=0; i<arrayLength; i++){
            resultArray[(i+placesToRotate)%arrayLength] = inputArray[i];
        }

        for(int i=0; i<indexToPrint.length; i++){
            System.out.println(resultArray[indexToPrint[i]]);
        }
    }
}
