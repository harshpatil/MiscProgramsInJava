package main.machineCoding;

public class PrintBox {

    public static void main (String[] args) throws Exception {

        int width = 17;
        int height = 6;
        printBox(width, height);
    }

    private static void printBox(int width, int height){

        printHorizontalLine(width);
        System.out.println("");

        for(int i=0; i<width; i++){
            if(i==0 || i==width-1){
                System.out.print("|");
            } else if(i== (width/2)){
                System.out.print("*");
            } else{
                System.out.print(" ");
            }
        }
        System.out.println("");

        for(int j=0; j<height-3; j++){
            for(int i=0; i<width; i++){
                if(i==0 || i==width-1){
                    System.out.print("|");
                } else{
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }

        printHorizontalLine(width);
    }

    private static void printHorizontalLine(int width){

        for(int i=0; i<width; i++){
            if(i==0 || i== width-1){
                System.out.print(" ");
            } else{
                System.out.print("-");
            }
        }
    }
}

