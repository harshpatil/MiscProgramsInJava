package main.identicalTrees;

import static java.lang.System.exit;

/**
 * Created by HarshPatil on 11/18/16.
 */
public class Tree {

    private Node root;

    public Tree(){

        root = null;
    }

    public void insert(int data){

        root = insertNode(root, data);
    }

    public Node insertNode(Node node, int data){

        if(node == null){
            node = new Node(data);
        } else {

            if(data <= node.getData()){
                node.setLeft(insertNode(node.getLeft(), data));
            } else {
                node.setRight(insertNode(node.getRight(), data));
            }
        }

        return node;
    }

    public void printTree() {
        inorder(root);
    }

    private void inorder(Node first) {

        if (first != null) {

            inorder(first.getLeft());
            System.out.print(first.getData() +" ");
            inorder(first.getRight());
        }
    }

    public void identicalTest(Tree first, Tree second){

        Node firstRoot = first.root;
        Node secondRoot = second.root;
        boolean result = traverse(firstRoot, secondRoot);
        if (result){
            System.out.println("\nTrees are IDENTICAL");
        } else {
            System.out.println("\nTrees are NOT IDENTICAL");
        }
    }

    public boolean traverse(Node firstRoot, Node secondRoot){

        if (firstRoot==null && secondRoot==null){
            return true;
        }

        if(firstRoot != null && secondRoot != null) {

           return firstRoot.getData() == secondRoot.getData() &&
                traverse(firstRoot.getLeft(), secondRoot.getLeft()) &&
                traverse(firstRoot.getRight(), secondRoot.getRight());

            } else {
                return false;
            }
    }

    private static int getHeight(Node temp){

        if(temp == null){

            return 0;

        } else{

            int leftHeight = getHeight(temp.getLeft());
            int rightHeight = getHeight(temp.getRight());

            if(leftHeight>rightHeight){

                return leftHeight + 1;

            }else{

                return rightHeight+1;
            }
        }
    }

    public void printInputTree() {

        int height = getHeight(root);

        for(int i=1; i <= height; i++){

            printItemsAtGivenLevel(root,i);
            System.out.println();
        }
    }

    private void printItemsAtGivenLevel(Node temp, int level) {

        if(temp == null){

            return;
        }else if (level == 1){

            System.out.print(" "+temp.getData());
        }else{

            printItemsAtGivenLevel(temp.getLeft(),level-1);
            printItemsAtGivenLevel(temp.getRight(),level-1);
        }
    }
}
