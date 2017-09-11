package main.tree;

/*
    http://www.geeksforgeeks.org/write-a-c-program-to-delete-a-tree/

    To delete a tree we must traverse all the nodes of the tree and delete them one by one.
    So which traversal we should use – Inorder or Preorder or Postorder.
    Answer is simple – Postorder, because before deleting the parent node we should
    delete its children nodes first

    We can delete tree with other traversals also with extra space complexity but why
    should we go for other traversals if we have Postorder available which does the work
    without storing anything in same time complexity.

 */
public class DeleteATree {

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        deleteTree(tree.root);
        tree.root = null;
        System.out.println("Tree has been Deleted");
    }

    private static void deleteTree(TreeNode root) {

        TreeNode temp = root;
        if(temp == null){
            return;
        }

        deleteTree(temp.left);
        deleteTree(temp.right);
        System.out.println("Deleting node :: "+ temp.data);
        temp = null;
    }
}
