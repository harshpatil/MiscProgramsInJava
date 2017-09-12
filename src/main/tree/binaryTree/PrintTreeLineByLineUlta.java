package main.tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
    Here print the tree ulta

    Time Complexity: O(n)
 */
public class PrintTreeLineByLineUlta {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(6);

        printNodesUltaLevelWiseBFS(tree.root);
    }

    private static void printNodesUltaLevelWiseBFS(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            int nodeCount = queue.size();
            if(nodeCount==0){
                break;
            }
            int i=0;
            while (i<nodeCount){
                TreeNode temp = queue.poll();
                stack.add(temp);
                if(temp.right!=null){
                    queue.add(temp.right);
                }
                if(temp.left!=null){
                    queue.add(temp.left);
                }
                if(i==nodeCount-1){
                    stack.add(null);
                }
                i++;
            }
        }
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp!=null){
                System.out.print(temp.data + " ");
            } else {
                System.out.println();
            }
        }
    }
}
