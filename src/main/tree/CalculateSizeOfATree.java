package main.tree;

/*
    Size of a tree is the number of elements present in the tree.
    Size() function recursively calculates the size of a tree. It works as follows:

    Size of a tree = Size of left subtree + 1 + Size of right subtree.

    http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
 */
public class CalculateSizeOfATree {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Size of the tree :: " + calculateSize(tree.root));
    }

    private static int calculateSize(TreeNode root) {

        if(root == null){
            return 0;
        }
        return (calculateSize(root.left) + 1 + calculateSize(root.right));
    }
}
