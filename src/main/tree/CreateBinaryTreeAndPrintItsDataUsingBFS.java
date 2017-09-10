package main.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
    http://www.geeksforgeeks.org/level-order-tree-traversal/
 */
public class CreateBinaryTreeAndPrintItsDataUsingBFS {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        System.out.println("Tree travesal using BFS :: ");
        traverseTreeUsingBFS(tree.root);
    }

    private static void traverseTreeUsingBFS(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left!=null){
                queue.add(temp.left);
            }
            if(temp.right!=null){
                queue.add(temp.right);
            }
        }
    }
}
