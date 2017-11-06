package main.machineCoding;

/*
    Given a file with content written in tree structure
    Example :
        Input

            dir1
                dir2
                    dir3
                        file1.txt
            dir4
                dir5
                dir6
                    file2.txt

        Output
            file1.txt

 */
public class LongestAbsolutePathInAFileWrittenInTreeStructure {

    public static void main(String[] args){

        // Assumption
            // File content is read line by line and written in a String array
        String[] input = new String[9];
        input[0] = "dir1";
        input[1] = "\tdir2";
        input[2] = "\t\tdir3";
        input[3] = "\t\t\tfile1.txt";
        input[4] = "dir4444444444";
        input[5] = "\tdir5";
        input[6] = "\tdir6";
        input[7] = "\t\tfile22.txt";
        input[8] = "\t\tfile222.txt";

        printLongestAbsolutePathFileName(input);
    }

    private static void printLongestAbsolutePathFileName(String[] input) {

        int max = 0;
        int current = 0;
        String fileName = "";
        for(int i=0; i<input.length; i++){

        // Complete this


        }
        System.out.println("File with longest absolute path :: " + fileName);
    }
}
