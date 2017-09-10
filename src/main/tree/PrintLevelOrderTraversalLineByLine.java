package main.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
    Given a binary tree, print level order traversal in a way that nodes of all
    levels are printed in separate lines

    http://www.geeksforgeeks.org/print-level-order-traversal-line-line/

 */
public class PrintLevelOrderTraversalLineByLine {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);

        printNodesLevelWiseBFS(tree.root);
    }

    private static void printNodesLevelWiseBFS(TreeNode root) {

        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (true){

            int nodeCount = queue.size();
            if(nodeCount == 0){
                break;
            }
            int i=0;
            while (i<nodeCount){

                TreeNode temp = queue.poll();
                System.out.print(temp.data + " ");

                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                i++;
            }
            System.out.println();
        }
    }
}
