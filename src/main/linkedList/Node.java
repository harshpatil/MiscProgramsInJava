package main.linkedList;

/**
 * Created by HarshPatil on 10/28/16.
 */
public class Node {

    private int data;
    private Node next;

    public Node(int data){

        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void displayNode(){
        System.out.print("{ "+ data +" }");
    }
}
