package main.tree.binarySearchTree;

/*
    http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 */
public class SearchForGivenElementInBST {

    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new BSTNode(8);
        tree.root.left = new BSTNode(3);
        tree.root.left.left = new BSTNode(1);
        tree.root.left.right = new BSTNode(6);
        tree.root.left.right.left = new BSTNode(4);
        tree.root.left.right.right = new BSTNode(7);
        tree.root.right = new BSTNode(10);
        tree.root.right.right = new BSTNode(14);
        tree.root.right.right.left = new BSTNode(13);

        int searchElement=14;

        if(searchForGivenItem(tree.root , searchElement)){
            System.out.println(searchElement + " Found");
        } else {
            System.out.println(searchElement + " Not Found");
        }
    }

    private static boolean searchForGivenItem(BSTNode root, int searchElement) {

        if(root.data == searchElement){
            return true;
        }

        if (root.left == null && root.right == null){
            return false;
        }

        if(searchElement < root.data){
            return searchForGivenItem(root.left, searchElement);
        } else {
            return searchForGivenItem(root.right, searchElement);
        }
    }
}
