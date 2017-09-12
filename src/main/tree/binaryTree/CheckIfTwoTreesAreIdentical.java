package main.tree.binaryTree;

/*
    Two trees are identical when they have same data and arrangement of data is also same.
    To identify if two trees are identical, we need to traverse both trees simultaneously,
    and while traversing we need to compare data and children of the trees.

    http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/

 */
public class CheckIfTwoTreesAreIdentical {

    public static void main(String[] args){

        BinaryTree tree1 = new BinaryTree();
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(3);
        tree1.root.left.left = new TreeNode(4);
        tree1.root.left.right = new TreeNode(5);

        BinaryTree tree2 = new BinaryTree();
        tree2.root = new TreeNode(1);
        tree2.root.left = new TreeNode(2);
        tree2.root.right = new TreeNode(3);
        tree2.root.left.left = new TreeNode(4);
        tree2.root.left.right = new TreeNode(5);

        if(checkIfTreesAreIdentical(tree1.root, tree2.root)){
            System.out.println("Two trees are identical");
        } else {
            System.out.println("Two trees are not identical");
        }
    }

    private static boolean checkIfTreesAreIdentical(TreeNode node1, TreeNode node2) {

        if(node1==null && node2==null){
            return true;
        }
        if(node1!= null && node2!=null){
            return (node1.data == node2.data &&
                    checkIfTreesAreIdentical(node1.left, node2.left) &&
                    checkIfTreesAreIdentical(node1.right, node2.right));
        }
        return false;
    }
}
