package main.tree;

import main.identicalTrees.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    We have discussed level order traversal of a post in previous post.
    The idea is to print last level first, then second last level, and so on.
    Like Level order traversal, every level is printed from left to right.

    http://www.geeksforgeeks.org/reverse-level-order-traversal/

    The method 2 of normal level order traversal can also be easily modified
    to print level order traversal in reverse order. The idea is to use a stack
    to get the reverse level order. If we do normal level order traversal and
    instead of printing a node, push the node to a stack and then print contents
    of stack, we get “5 4 3 2 1” for above example tree, but output should be “4 5 2 3 1”.
    So to get the correct sequence (left to right at every level), we process children
    of a node in reverse order, we first push the right subtree to stack, then left subtree.

 */
public class ReverseLevelOrderTraversal {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        traverseTreeUsingBFSReverse(tree.root);

    }

    private static void traverseTreeUsingBFSReverse(TreeNode root) {

        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        while(!queue.isEmpty()){

            TreeNode temp = queue.poll();
            stack.add(temp);

            if(temp.right!=null){
                queue.add(temp.right);
            }
            if(temp.left!=null){
                queue.add(temp.left);
            }
        }

        while (!stack.isEmpty()){
            System.out.print(stack.pop().data + " ");
        }
    }
}
