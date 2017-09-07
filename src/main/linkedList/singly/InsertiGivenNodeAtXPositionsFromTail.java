package main.linkedList.singly;

public class InsertiGivenNodeAtXPositionsFromTail {

    public static void main(String[] args){

        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new SinglyLinkedListNode(1);
        sll.head.next = new SinglyLinkedListNode(2);
        sll.head.next.next = new SinglyLinkedListNode(3);
        sll.head.next.next.next = new SinglyLinkedListNode(4);
        sll.head.next.next.next.next = new SinglyLinkedListNode(5);
        sll.head.next.next.next.next.next = new SinglyLinkedListNode(6);

        printElementsOfLinkedList(sll);

        int positionFromTail = 1;
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(55);
        insertNodeAtGivenPositionFromTail(sll, newNode, positionFromTail);

        System.out.println("\nList after inserting "+ newNode.data + ", " + positionFromTail + " positions from tail");
        printElementsOfLinkedList(sll);
    }

    private static void insertNodeAtGivenPositionFromTail(SinglyLinkedList sll, SinglyLinkedListNode newNode, int positionFromTail) {

        if(positionFromTail<0){
            System.out.println("\nInvalid position number. Number should be >= 0");
            System.exit(0);
        }

        SinglyLinkedListNode current = sll.head;
        SinglyLinkedListNode prev = sll.head;
        int count=0;
        int length=0;
        while (count<=positionFromTail && current != null){
            current = current.next;
            count++;
            length++;
        }

        while (current != null){
            current=current.next;
            prev = prev.next;
            length++;
        }

        if(positionFromTail>length){
            System.out.println("\nCan not insert at position " + positionFromTail + " from tail as list size is " + length);
            System.exit(0);
        }
        else if(positionFromTail == length){
            newNode.next = prev;
            sll.head = newNode;
        }
        else {
            SinglyLinkedListNode temp = prev.next;
            prev.next = newNode;
            newNode.next = temp;
        }
    }

    private static void printElementsOfLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
