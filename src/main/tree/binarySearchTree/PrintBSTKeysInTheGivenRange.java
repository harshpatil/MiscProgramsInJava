package main.tree.binarySearchTree;

/*
    http://www.geeksforgeeks.org/print-bst-keys-in-the-given-range/

    Given two values k1 and k2 (where k1 < k2) and a root pointer to a Binary Search Tree.
    Print all the keys of tree in range k1 to k2.
    i.e. print all x such that k1<=x<=k2 and x is a key of given BST.
    Print all the keys in increasing order.

 */
public class PrintBSTKeysInTheGivenRange {

    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = insertNode(null, 20);
        insertNode(tree.root, 8);
        insertNode(tree.root, 22);
        insertNode(tree.root, 4);
        insertNode(tree.root, 12);
        insertNode(tree.root, 29);

        int k1 = 10;
        int k2 = 25;
        System.out.print("Nodes between "+ k1 + " & "+ k2 + " are ");
        printNodesBetween(tree.root, k1, k2);
    }

    private static void printNodesBetween(BSTNode node, int k1, int k2) {

        if(node == null){
            return;
        }
        printNodesBetween(node.left, k1, k2);

        if(node.data >= k1 && node.data <= k2){
            System.out.print(node.data + " ");
        }

        printNodesBetween(node.right, k1, k2);
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
}
