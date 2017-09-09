package main.tree;


/*
    http://www.geeksforgeeks.org/binary-tree-set-1-introduction/
    http://www.geeksforgeeks.org/binary-tree-set-2-properties/
    http://www.geeksforgeeks.org/binary-tree-set-3-types-of-binary-tree/

    Inorder, Preorder, Postorder traversal are Depth First Traversal methods
 */

public class CreateBinaryTreeAndPrintItsDataUsingDFS {

    public static void main(String[] args){

        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new TreeNode(1);

        binaryTree.root.left = new TreeNode(2);
        binaryTree.root.right = new TreeNode(3);
        binaryTree.root.left.left = new TreeNode(4);

        System.out.println("Pre order traversal");
        preOrderTraversal(binaryTree.root);

        System.out.println("In order traversal");
        inOrderTraversal(binaryTree.root);

        System.out.println("Post order traversal");
        postOrderTraversal(binaryTree.root);
    }

    private static void preOrderTraversal(TreeNode root) {

        if(root==null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static void inOrderTraversal(TreeNode root) {

        if(root==null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    private static void postOrderTraversal(TreeNode root) {

        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.data);
    }
}
