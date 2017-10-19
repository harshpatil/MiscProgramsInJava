package main.tree.binarySearchTree;

/*
    http://www.geeksforgeeks.org/kth-largest-element-in-bst-when-modification-to-bst-is-not-allowed/

    Given a Binary Search Tree (BST) and a positive integer k,
    find the k’th largest element in the Binary Search Tree.

    Find Second largest element (http://www.geeksforgeeks.org/second-largest-element-in-binary-search-tree-bst/)
    is a variant of this one.

 */
public class KthLargestElementInBST {

    public static void main(String[] args){

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80  */

        BinarySearchTree tree = new BinarySearchTree();
        tree.root = insertNode(null, 50);
        insertNode(tree.root, 30);
        insertNode(tree.root, 20);
        insertNode(tree.root, 40);
        insertNode(tree.root, 70);
        insertNode(tree.root, 60);
        insertNode(tree.root, 80);

        int kth = 4;
        findKthLargest(tree.root, kth);
    }

    static public class Count{
        int count = 0;
    }

    private static void findKthLargest(BSTNode root, int kth) {

        Count count = new Count();
        findKthLargestUtil(root, kth, count);
    }

    private static void findKthLargestUtil(BSTNode node, int k, Count count) {

        if(node == null || count.count >= k){
            return;
        }
        findKthLargestUtil(node.right, k, count);
        count.count++;
        if(count.count == k){
            System.out.println(k + "th Largest element is " + node.data);
            return;
        }
        findKthLargestUtil(node.left, k, count);
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
