package main.tree.binaryTree;

import java.util.Stack;

/**
 * Created by HarshPatil on 8/21/18.
 *
 *  https://www.geeksforgeeks.org/zigzag-tree-traversal/
 */
public class ZigzagTreeTraversal {

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(7);
        tree.root.left.right = new TreeNode(6);
        tree.root.right.left = new TreeNode(5);
        tree.root.right.right = new TreeNode(4);
        printTreeInZigZagFashion(tree.root);
    }

    private static void printTreeInZigZagFashion(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> currentLevel = new Stack();
        Stack<TreeNode> nextLevel = new Stack();
        currentLevel.push(root);
        boolean leftToRight = true;
        while(!currentLevel.empty()){
            TreeNode temp = currentLevel.pop();
            System.out.print(temp.data + " ");
            if(leftToRight){
                if(temp.left!=null){
                    nextLevel.push(temp.left);
                }
                if(temp.right!= null){
                    nextLevel.push(temp.right);
                }
            } else {
                if(temp.right!= null){
                    nextLevel.push(temp.right);
                }
                if(temp.left!=null){
                    nextLevel.push(temp.left);
                }
            }
            if(currentLevel.empty()){
                leftToRight = (!leftToRight);
                currentLevel = nextLevel;
                nextLevel = new Stack<>();
            }
        }

    }
}
