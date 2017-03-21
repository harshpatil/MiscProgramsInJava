package main.linkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.LinkedList;

/**
 * Created by HarshPatil on 10/28/16.
 */
public class LinkedListImplementation {

    public static void main(String args[]) throws Exception {

//        Node head;
//        Node node = new Node(3);
//        node.setNext(null);
//        head = node;
//
//        Node node2 = new Node(6);
//        node2.setNext(null);
//        node.setNext(node2);
//
//        Node node3 = new Node(8);
//        node3.setNext(null);
//        node2.setNext(node3);
//
//        Node current = head;
//        while (current!=null){
//            System.out.print(current.getData() + "->");
//            current = current.getNext();
//        }

        NodeList nodeList = new NodeList();
        nodeList.insertNodeAtBeginning(1);
        nodeList.insertNodeAtBeginning(2);
        nodeList.insertNodeAtBeginning(3);
        nodeList.insertNodeAtBeginning(4);
        nodeList.insertNodeAtBeginning(5);

        nodeList.printList();

        nodeList.insertNodeAtBeginning(6);
        System.out.print("\n New List after inserting 6 at beginning ::: ");
        nodeList.printList();

        nodeList.deleteFirstNode();
        System.out.print("\n After deleting first Node ::: ");
        nodeList.printList();

        nodeList.deleteLastNode();
        System.out.print("\n After deleting last Node ::: ");
        nodeList.printList();

        nodeList.insertNodeAtEnd(8);
        System.out.print("\n After inserting node 8 at last ::: ");
        nodeList.printList();

        System.out.println("\n Enter position item should be inserted");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        if(!input.matches("[a-zA-Z]+")){

            nodeList.insertNodeAtXPosition(Integer.parseInt(input), 11);
            System.out.print("\n After inserting node at position " + Integer.parseInt(input) +" ::: ");
            nodeList.printList();
        }else {
            System.out.println("Invalid input");
            return;
        }

        System.out.println("\n Enter position item needs to be deleted from");
        input = bufferedReader.readLine();

        if(!input.matches("[a-zA-Z]+")){

            nodeList.deleteNodeAtXPosition(Integer.parseInt(input));
            System.out.print("\n After deleting node at position " + Integer.parseInt(input) +" ::: ");
            nodeList.printList();
        }else {
            System.out.println("Invalid input");
            return;
        }
    }
}
