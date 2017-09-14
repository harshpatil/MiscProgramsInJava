package main.tree.binarySearchTree;

/*
    http://www.geeksforgeeks.org/find-the-minimum-element-in-a-binary-search-tree/

    Just traverse the node from root to left recursively until left is NULL.
    The node whose left is NULL is the node with minimum value.
 */
public class FindTheNodeWithMinimumValueInABinarySearchTree {

    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = insertInBST(null, 20);
        insertInBST(tree.root, 8);
        insertInBST(tree.root, 4);
        insertInBST(tree.root, 12);
        insertInBST(tree.root, 10);
        insertInBST(tree.root, 14);
        insertInBST(tree.root, 22);

        System.out.println("Inorder traversal");
        printInOrder(tree.root);

        System.out.println("\nNode with smallest number :: " + findNodeWithMinValue(tree.root));
    }

    private static int findNodeWithMinValue(BSTNode root) {

        if(root == null){
            return -1;
        }
        int min = root.data;
        while (root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    private static void printInOrder(BSTNode root) {

        if(root == null){
            return;
        }
        else {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }

    private static BSTNode insertInBST(BSTNode root, int key) {

        if(root == null){
            root = new BSTNode(key);
            return root;
        }
        if(key<root.data){
            root.left = insertInBST(root.left, key);
        }
        else {
            root.right = insertInBST(root.right, key);
        }
        return root;
    }
}
