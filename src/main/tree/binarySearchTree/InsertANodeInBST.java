package main.tree.binarySearchTree;

/*
    http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
 */
public class InsertANodeInBST {

    public static void main(String[] args){

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80  */

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = insertNode(null, 50);
        insertNode(tree.root, 30);
        insertNode(tree.root, 20);
        insertNode(tree.root, 40);
        insertNode(tree.root, 70);
        insertNode(tree.root, 60);
        insertNode(tree.root, 80);

        printBSTInOrder(tree.root);
    }

    private static BSTNode insertNode(BSTNode root, int key) {

        if(root == null){
            root = new BSTNode(key);
            return root;
        }
        if(key < root.data){
            root.left = insertNode(root.left, key);
        }
        else {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    private static void printBSTInOrder(BSTNode root) {

        if(root == null){
            return;
        } else {
            printBSTInOrder(root.left);
            System.out.println(root.data);
            printBSTInOrder(root.right);
        }
    }
}
