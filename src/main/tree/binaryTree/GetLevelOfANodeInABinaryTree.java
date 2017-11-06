package main.tree.binaryTree;

/*
    http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/

    Time Complexity : O(n)
 */
public class GetLevelOfANodeInABinaryTree {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(5);
        tree.root.left.left = new TreeNode(1);
        tree.root.left.right = new TreeNode(4);

        for(int i=0; i<=5; i++){
            int level = getLevel(tree.root, i);
            if(level != 0){
                System.out.println("Node with data " + i + " is present at level " + level);
            } else {
                System.out.println("Node with data " + i + " does not exist");
            }
        }

    }

    private static int getLevel(TreeNode root, int i) {
        return getLevelUtil(root, i, 1);
    }

    private static int getLevelUtil(TreeNode root, int data, int level) {

        if(root == null){
            return 0;
        }

        if(root.data == data){
            return level;
        }
        int leftLevel = getLevelUtil(root.left, data, level+1);
        if(leftLevel != 0){
            return leftLevel;
        }

        int rightLevel = getLevelUtil(root.right, data, level+1);
        return rightLevel;
    }
}
