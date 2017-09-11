package main.tree;

/**
    http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 */
public class FindTheMaximumDepthOrHeightOfATree {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.left.right.right = new TreeNode(6);

        int height = findOutHeightOfTree(tree.root);
        System.out.println("Height of the tree is :: "+height);
    }

    private static int findOutHeightOfTree(TreeNode root) {

        TreeNode temp = root;
        if (temp == null){
            return 0;
        }

        int leftHeight = findOutHeightOfTree(temp.left);
        int rightHeight = findOutHeightOfTree(temp.right);

        if(leftHeight > rightHeight){
            return (leftHeight+1);
        } else {
            return (rightHeight+1);
        }
    }
}
