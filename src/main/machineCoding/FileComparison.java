package main.machineCoding;

import java.util.*;

/*
    Write a program to return list of files whose content is identical

    Input : "foo"


    File Structure :
            /foo
                - /bar
                    - cat.dat
                - /sms.png
                - /abcd
                    - /temp
                        - /xyz/qwe.png
                - /mno.txt
                - /abc.tmp
                - /xyz.temp

    Output :
        [
            ['/foo/bar/cat.dat', '/foo/abc/tmp', '/foo/xyz.temp']
            ['/foo/sms.png', '/foo/abcd/temp/xyz/qwe.png']
        ]

    Note - If any file doesn't have matching file, it should not be returned in
    the output

 */
public class FileComparison {

    // Assumptions
    //This return list of files/folders under given path
     static ArrayList<String> fileList(String path){
         return null;
     }

     //This function returns true if given path is DIR
    static boolean isDir(String path){
        return true;
    }

    // This function returns file content in the form of an array
    static char[] fileContent(String filePath){
        return new char[10];
    }

    public static void main(String[] args){

        String input = "foo";
        printSimilarFiles(input);
    }

    private static void printSimilarFiles(String input) {

        if(!isDir(input)){
            System.out.println("Given input is a file so there are no matching files");
            System.exit(0);
        }
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        ArrayList<String> filesList = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        stack.add(input);
        while (!stack.empty()){
            String current = stack.pop();
            List<String> childList = fileList(current);
            for(int i=0; i<childList.size(); i++){
                if(!isDir(childList.get(i))){
                    filesList.add(current + "/" + childList.get(i));
                } else {
                    stack.add(current + "/" + childList.get(i));
                }
            }
        }

        HashMap<Integer, List<String>> map =  new HashMap<>();
        for(int i=0; i<filesList.size(); i++){
            char[] current = fileContent(filesList.get(i));
            int sum = 0;
            for(int j=0; j<current.length; j++){
                sum = sum + (j+current[j]);
            }
            if(map.containsKey(sum)){
                List<String> list = map.get(sum);
                list.add(filesList.get(i));
                map.put(sum, list);

            } else {
                List<String> list = new ArrayList<>();
                list.add(filesList.get(i));
                map.put(sum, list);
            }
        }

        for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
            if(entry.getValue().size() >1){
                ArrayList<String> ans = new ArrayList<>();
                List<String> list = entry.getValue();
                for(int i=0; i<list.size(); i++){
                    char[] sourceContent = fileContent(list.get(i));
                    for(int j=i+1; j<list.size(); i++){
                        char[] comparerContent = fileContent(list.get(j));

                        if(sourceContent.length != comparerContent.length){
                            break;
                        }
                        int k=0;
                        while(k < comparerContent.length){
                            if(sourceContent[k] != comparerContent[k]){
                                break;
                            }
                            k++;
                        }
                        if(ans.size()==0){
                            ans.add(list.get(i));
                            ans.add(list.get(j));
                        } else {
                            ans.add(list.get(j));
                        }
                    }
                }
                result.add(ans);
            }
        }

        for(int i=0; i<result.size(); i++){
            ArrayList<String> current = new ArrayList<>();
            for(int j=0; j<current.size(); j++){
                System.out.print("'" + current.get(j) + "',");
            }
            System.out.println();
        }
    }
}
