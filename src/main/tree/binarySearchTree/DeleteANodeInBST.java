package main.tree.binarySearchTree;

import main.array.BinarySearch;

/*
    http://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

    1) Node to be deleted is leaf: Simply remove from the tree.
    2) Node to be deleted has only one child: Copy the child to the node and delete the child
    3) Node to be deleted has two children: Find inorder successor (min node) of the node.
       Copy contents of the inorder successor (min node) to the node and
       delete the inorder successor (min node). Note that inorder predecessor can also be used.

 */
public class DeleteANodeInBST {

    public static void main(String []args){

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = insertNode(null, 50);
        insertNode(tree.root, 30);
        insertNode(tree.root, 20);
        insertNode(tree.root, 40);
        insertNode(tree.root, 70);
        insertNode(tree.root, 60);
        insertNode(tree.root, 80);

        System.out.println("Inorder traversal of Tree");
        printInorder(tree.root);

        int keyToBeDeleted = 20;
        deleteKey(tree.root, keyToBeDeleted);
        System.out.println("\nInorder traversal after deleting key :: " + keyToBeDeleted);
        printInorder(tree.root);

        keyToBeDeleted = 30;
        deleteKey(tree.root, keyToBeDeleted);
        System.out.println("\nInorder traversal after deleting key :: " + keyToBeDeleted);
        printInorder(tree.root);

        keyToBeDeleted = 50;
        deleteKey(tree.root, keyToBeDeleted);
        System.out.println("\nInorder traversal after deleting key :: " + keyToBeDeleted);
        printInorder(tree.root);
    }

    private static BSTNode insertNode(BSTNode root, int key) {
        if(root == null){
            root = new BSTNode(key);
            return root;
        }
        else if(key < root.data){
            root.left = insertNode(root.left, key);
        }
        else {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    private static void printInorder(BSTNode root) {

        if(root == null){
            return;
        } else {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    private static BSTNode deleteKey(BSTNode root, int keyToBeDeleted) {

        if(root == null){
            return root;
        }

        if(keyToBeDeleted == root.data){
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            root.data = min(root.right);
            root.right = deleteKey(root.right, root.data);
        }
        else if(keyToBeDeleted < root.data){
            root.left = deleteKey(root.left, keyToBeDeleted);
        }
        else {
            root.right = deleteKey(root.right, keyToBeDeleted);
        }
        return root;
    }

    private static int min(BSTNode root) {

        int min = root.data;
        while (root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
}
