package main.tree.binarySearchTree;

/*
    http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

    Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise
    starting from the root.
 */
public class BoundaryTraversalOfBinaryTree {

    public static void main(String []args){

        BinarySearchTree tree  = new BinarySearchTree();
        tree.root = new BSTNode(20);
        tree.root.left = new BSTNode(8);
        tree.root.left.left = new BSTNode(4);
        tree.root.left.right = new BSTNode(12);
        tree.root.left.right.left = new BSTNode(10);
        tree.root.left.right.right = new BSTNode(14);
        tree.root.right = new BSTNode(22);
        tree.root.right.right = new BSTNode(25);

        printBoundary(tree.root);
    }

    private static void printBoundary(BSTNode node) {

        if(node!=null){
            System.out.print(node.data + " ");

            printLeftBoundary(node.left);

            printLeaves(node.left);
            printLeaves(node.right);

            printRightBoundary(node.right);
        }
    }

    private static void printLeftBoundary(BSTNode node) {

        if(node != null){
            if(node.left!=null){
                System.out.print(node.data + " ");
                printLeftBoundary(node.left);
            }
            else if(node.right != null){
                System.out.print(node.data + " ");
                printLeftBoundary(node.right);
            }

        }
    }

    private static void printLeaves(BSTNode node) {

        if(node!=null){

            printLeaves(node.left);

            if(node.left == null && node.right == null){
                System.out.print(node.data + " ");
            }

            printLeaves(node.right);
        }
    }

    private static void printRightBoundary(BSTNode node) {
        if(node!=null){
            if(node.right!=null){
                printRightBoundary(node.right);
                System.out.print(node.data + " ");
            }
            else if (node.left != null){
                printRightBoundary(node.left);
                System.out.print(node.data + " ");
            }
        }
    }
}
