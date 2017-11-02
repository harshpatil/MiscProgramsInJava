package main.tree.binaryTree;

/*
    Given a binary tree and a number, return true if the tree has a root-to-leaf path
    such that adding up all the values along the path equals the given number.
    Return false if no such path can be found.

    This is same as DFS

    http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 */
public class GivenABinaryTreeAndANumberReturnTrueIfTheTreeHasRootToLeafPath {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(2);
        tree.root.right.left = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);

        int sum = 23;

        if(checkIfPathExists(tree.root, sum)){
            System.out.println("Path exists");
        }else {
            System.out.println("Path Does not exist");
        }
    }

    private static boolean checkIfPathExists(TreeNode root, int sum) {

        if(root == null){
            return (sum == 0);
        } else {
            boolean ans = false;
            int subsum = sum - root.data;
            if(subsum == 0 && root.left == null && root.right == null){
                return true;
            }
            if(root.left!=null){
                ans = ans || checkIfPathExists(root.left, subsum);
            }
            if(root.right!=null){
                ans = ans || checkIfPathExists(root.right, subsum);
            }
            return ans;
        }
    }
}
