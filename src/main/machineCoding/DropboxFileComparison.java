package main.machineCoding;

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
public class DropboxFileComparison {

    // Assumptions
    // ArrayList<String> fileList(String path); This return list of files/folders under given path
    // boolean isDir(String path); This function returns true if given path is DIR
    // int[] fileContent(String filePath)

    public static void main(String[] args){

    }
}
