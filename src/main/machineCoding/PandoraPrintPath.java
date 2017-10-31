package main.machineCoding;

import java.util.ArrayList;
import java.util.List;

public class PandoraPrintPath {

    private static class Node {

        private String value;
        private List<Node> children;

        public Node(String value, List<Node> children) {
            this.value = value;
            this.children = children;
        }

        public String getValue(){
            return value;
        }

        public List<Node> getChildren(){
            return children;
        }
    }

    public static void main(String[] args) {

        PandoraPrintPath interview = new PandoraPrintPath();

        List<Node> children2 = new ArrayList<Node>();
        children2.add(new Node("Dog", new ArrayList<Node>()));

        List<Node> children0 = new ArrayList<Node>();
        children0.add(new Node("Clown", new ArrayList<Node>()));

        List<Node> children1 = new ArrayList<Node>();
        children1.add(new Node("Car", children0));
        children1.add(new Node("Sky", new ArrayList<Node>()));
        children1.add(new Node("Dinosaur", null));
        children1.add(new Node("Truck", children2));

        Node root = new Node("Horse", children1);

        System.out.println("Expected :: \"Horse-Truck-Dog\", FOUND :: "+interview.getPathToValue("Dog", root));
        System.out.println("Expected :: \"Horse-Car-Clown\", FOUND :: "+interview.getPathToValue("Clown", root));
        System.out.println("Expected :: \"Horse\", FOUND :: "+interview.getPathToValue("Horse", root));
        System.out.println("Expected :: \"Horse-Sky\", FOUND :: "+interview.getPathToValue("Sky", root));
        System.out.println("Expected :: \"\", FOUND :: "+interview.getPathToValue("Pumpkin", root));
    }

    // Problem #2
    // example: getPathToValue("Dog",root)  "Horse-Cat-Truck-Patriots-Dog";
    // There's only a one to one relationship downward.
    // Meaning a node only can have one parent. Every parent can have 0..n children.
    // Values are unique.
    // Return empty string if not found.
    public String getPathToValue(String value, Node root) {

        if(root == null){
            return "";
        }
        if(root.getValue().equals(value)){
            return value;
        } else {
            if(root.getChildren() != null){
                List<Node> childList = root.getChildren();
                for(int i=0; i<childList.size(); i++){
                    if(childList.get(i).getValue().equals(value)){
                        return (root.getValue() + "-" + childList.get(i).getValue());
                    } else {
                        String result = getPathToValue(value, childList.get(i));
                        if(!result.equals("")){
                            return (root.getValue() + "-" + result);
                        }
                    }
                }
            }
        }
        return "";
    }
}
