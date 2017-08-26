package main.linkedList;

import javafx.beans.binding.When;

import static java.lang.System.exit;

/**
 * Created by HarshPatil on 10/28/16.
 */
public class NodeList {

    private Node first;

    public Node getFirst() {
        return first;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public NodeList(){
        first = null;
    }

    public void insertNodeAtBeginning(int data){

        Node node = new Node(data);
        node.setNext(first);
        first = node;
    }

    public void insertNodeAtEnd(int data){

        Node node = new Node(data);
        Node temp = first;
        while(temp.getNext()!=null){
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void insertNodeAtEnd(Node node){

        Node temp = first;
        while(temp.getNext()!=null){
            temp = temp.getNext();
        }
        temp.setNext(node);
    }

    public void deleteFirstNode(){
        Node temp = first;
        first = first.getNext();
    }

    public void deleteLastNode(){
        Node temp = first;
        Node previous = null;
        while (temp.getNext()!=null){
            previous = temp;
            temp = temp.getNext();
        }
        previous.setNext(null);
    }

    public void printList(){

        Node start = first;
        while (start!=null){
            start.displayNode();
            start = start.getNext();
        }
    }

    public void insertNodeAtXPosition(int position, int data){

        int length = 0;
        Node temp = first;
        while (temp!=null){
            temp = temp.getNext();
            length++;
        }
        if(position>length+1 || position < 1){
            System.out.println("Invalid position");
            exit(0);
        } else {

            if(position == 1){
                insertNodeAtBeginning(data);
            }
            else {
                int nodeNumber = 1;
                Node current = first;
                Node previous = null;
                while (position != nodeNumber){
                    nodeNumber++;
                    previous = current;
                    current = current.getNext();

                }
                Node node = new Node(data);
                node.setNext(current);
                previous.setNext(node);
            }
        }
    }

    public void deleteNodeAtXPosition(int position){

        if(position == 1){
            first = first.getNext();
        }
        else {
            int nodeNumber = 1;
            Node temp = first;
            Node previous = null;
            while (position != nodeNumber){
                previous = temp;
                temp = temp.getNext();
                nodeNumber++;
            }
            previous.setNext(temp.getNext());
        }
    }

    public void loopNode(Node node){

        Node current = first;
        while(current.getNext()!=null){
            current = current.getNext();
        }
        current.setNext(node);
    }
}
