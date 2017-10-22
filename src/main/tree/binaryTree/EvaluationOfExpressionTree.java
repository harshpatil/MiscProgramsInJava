package main.tree.binaryTree;

/*
    http://www.geeksforgeeks.org/evaluation-of-expression-tree/

    Given a simple expression tree, consisting of basic binary operators
    i.e., + , – ,* and / and some integers, evaluate the expression tree.

 */
public class EvaluationOfExpressionTree {

    static class Node<T>{

        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args){

        Node<String> root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right = new Node("-");
        root.right.left = new Node("100");
        root.right.right = new Node("20");

        System.out.print("Result of evaluating expression is "+ evaluateExpression(root));

        root = new Node("+");
        root.left = new Node("*");
        root.left.left = new Node("5");
        root.left.right = new Node("4");
        root.right = new Node("-");
        root.right.left = new Node("100");
        root.right.right = new Node("/");
        root.right.right.left = new Node("20");
        root.right.right.right = new Node("2");

        System.out.print("\nResult of evaluating expression is "+ evaluateExpression(root));
    }

    private static int evaluateExpression(Node<String> root) {

        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return Integer.parseInt(root.data);
        }

        int leftValue = evaluateExpression(root.left);
        int rightValue = evaluateExpression(root.right);

        if(root.data == "+"){
            return (leftValue + rightValue);
        }
        if(root.data == "-"){
            return (leftValue - rightValue);
        }
        if(root.data == "*"){
            return (leftValue * rightValue);
        }
        return (leftValue / rightValue);
    }
}
