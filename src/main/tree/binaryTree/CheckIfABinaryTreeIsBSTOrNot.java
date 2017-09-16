package main.tree.binaryTree;

/*
    http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

    1) Do In-Order Traversal of the given tree and store the result in a temp array.
    2) Check if the temp array is sorted in ascending order, if it is, then the tree is BST.

    Time Complexity: O(n)

 */
public class CheckIfABinaryTreeIsBSTOrNot {

    static BinaryTree tree = new BinaryTree();
    static TreeNode prev;

    public static void main(String []args){

        tree.root = new TreeNode(4);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(3);

        if(isBST(tree.root)){
            System.out.println("Is a BST");
        } else {
            System.out.println("Is not a BST");
        }
    }

    private static boolean isBST(TreeNode root) {

        if(root == null){
            return true;
        }
        else {
            if(!isBST(root.left)){
                return false;
            }
            if(prev!= null && root.data < prev.data){
                return false;
            }
            prev = root;
            return isBST(root.right);
        }
    }

    private static boolean isBST() {
        prev = null;
        return isBST(tree.root);
    }
}
