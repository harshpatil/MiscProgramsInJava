package main.machineCoding;

public class PrintBox {

    public static void main (String[] args) throws Exception {

        int width = 16;
        int height = 6;
        printBox(width, height);
    }

    private static void printBox(int width, int height){

        String firstAndLastRow = "";
        String secondRow = "";
        String middleRow = "";

        for(int i=0; i<width; i++){
            if(i==0 || i== width-1){
                firstAndLastRow = firstAndLastRow + " ";
                secondRow = secondRow + "|";
                middleRow = middleRow + "|";
            } else if(i==(width/2)){
                firstAndLastRow = firstAndLastRow + "-";
                secondRow = secondRow + "*";
                middleRow = middleRow + " ";
            } else {
                firstAndLastRow = firstAndLastRow + "-";
                secondRow = secondRow + " ";
                middleRow = middleRow + " ";
            }
        }

        System.out.println(firstAndLastRow);
        System.out.println(secondRow);

        for(int i=0; i<height-3; i++){
            System.out.println(middleRow);
        }

        System.out.println(firstAndLastRow);

    }
}

