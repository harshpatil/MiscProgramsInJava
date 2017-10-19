package main.tree.binarySearchTree;

import java.util.HashMap;
import java.util.Map;

/*
    http://www.geeksforgeeks.org/print-common-nodes-in-two-binary-search-trees/

    Given two Binary Search Trees, find common nodes in them.
    In other words, find intersection of two BSTs.

    Method 2 (Linear Time) We can find common elements in O(n) time.
    1) Do inorder traversal of first tree and store the traversal in an auxiliary array ar1[]. See sortedInorder() here.
    2) Do inorder traversal of second tree and store the traversal in an auxiliary array ar2[]
    3) Find intersection of ar1[] and ar2[]. See this for details.

    Time complexity of this method is O(m+n)
    where m and n are number of nodes in first and second tree respectively.
    This solution requires O(m+n) extra space.

 */
public class PrintCommonNodesInTwoBinarySearchTrees {

    static Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args){

        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.root = insertNode(null, 5);
        insertNode(tree1.root, 1);
        insertNode(tree1.root, 10);
        insertNode(tree1.root, 0);
        insertNode(tree1.root, 4);
        insertNode(tree1.root, 7);
        insertNode(tree1.root, 9);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = insertNode(null, 10);
        insertNode(tree2.root, 7);
        insertNode(tree2.root, 20);
        insertNode(tree2.root, 4);
        insertNode(tree2.root, 9);

        inorderTravesal(tree1.root);
        System.out.print("Common Nodes in given BSTs are :: ");
        printCommon(tree2.root);
    }

    private static void inorderTravesal(BSTNode root) {
        if(root == null){
            return;
        } else {
            inorderTravesal(root.left);
            map.put(root.data, true);
            inorderTravesal(root.right);
        }
    }

    private static void printCommon(BSTNode root) {
        if(root == null){
            return;
        } else {
            printCommon(root.left);
            if(map.containsKey(root.data)){
                System.out.print(root.data + " ");
            }
            printCommon(root.right);
        }
    }


    private static BSTNode insertNode(BSTNode root, int key) {

        if(root == null){
            root = new BSTNode(key);
            return root;
        }
        if(key < root.data){
            root.left = insertNode(root.left, key);
        }
        else {
            root.right = insertNode(root.right, key);
        }
        return root;
    }

}
