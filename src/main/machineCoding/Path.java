package main.machineCoding;

/*
    Braviant Coding test
 */
public class Path {

    String path;

    public Path(String path){
        this.path = path;
    }

    public static void main(String[] args){

        Path path = new Path("/a/b/c/d");
        System.out.print("Old PATH :: " + path.path);
        path.cd("../x");
        System.out.print("\nNew PATH :: " + path.path);
    }

    private void cd(String newFolder) {

        String[] folders = newFolder.split("/");
        for(String value : folders){
            if(value.equals("..")){
                int index = path.lastIndexOf("/");
                path = path.substring(0, index);
            } else {
                path = path +"/"+ value;
            }
        }
    }
}
