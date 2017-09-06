package main.linkedList.singly;

public class InsertNodeInSinglyLinkedList {

    public static void main(String []args){
        SinglyLinkedList sll = new SinglyLinkedList();

        SinglyLinkedListNode first = new SinglyLinkedListNode(21);
        sll.head = first;

        SinglyLinkedListNode second = new SinglyLinkedListNode(31);
        sll.head.next = second;

        SinglyLinkedListNode third = new SinglyLinkedListNode(41);
        sll.head.next.next = third;

        printElementsOfLinkedList(sll);

        SinglyLinkedListNode newNode = new SinglyLinkedListNode(11);
        insertNodeAtTheBeginning(sll, newNode);
        System.out.println("\n\nAfter inserting new Node (11) at the beginning");
        printElementsOfLinkedList(sll);

        SinglyLinkedListNode lastNode = new SinglyLinkedListNode(101);
        insertNodeAtTheEnd(sll, lastNode);
        System.out.println("\n\nAfter inserting new Node (101) at the end");
        printElementsOfLinkedList(sll);

        int nodeWithData = 41;
        SinglyLinkedListNode insertAfterElementNode = new SinglyLinkedListNode(51);
        insertAfterElementAfterGivenNode(sll, insertAfterElementNode, nodeWithData);
        System.out.println("\n\nAfter inserting new Node (51) after node (41)");
        printElementsOfLinkedList(sll);

    }

    private static void insertAfterElementAfterGivenNode(SinglyLinkedList sll, SinglyLinkedListNode insertAfterElementNode, int nodeWithData) {

        SinglyLinkedListNode current = sll.head;
        while (current.data != nodeWithData){
            current = current.next;
        }
        insertAfterElementNode.next = current.next;
        current.next = insertAfterElementNode;
    }

    private static void insertNodeAtTheEnd(SinglyLinkedList sll, SinglyLinkedListNode lastNode) {

        SinglyLinkedListNode current = sll.head;
        while (current.next != null){
            current = current.next;
        }
        current.next = lastNode;
    }

    private static void insertNodeAtTheBeginning(SinglyLinkedList sll, SinglyLinkedListNode newNode) {

        SinglyLinkedListNode temp = sll.head;
        sll.head = newNode;
        newNode.next = temp;
    }

    private static void printElementsOfLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
