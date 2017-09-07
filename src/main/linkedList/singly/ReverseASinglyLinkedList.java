package main.linkedList.singly;

public class ReverseASinglyLinkedList {

    public static void main(String []args){

        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new SinglyLinkedListNode(1);
        sll.head.next = new SinglyLinkedListNode(2);
        sll.head.next.next = new SinglyLinkedListNode(3);
        sll.head.next.next.next = new SinglyLinkedListNode(4);
        sll.head.next.next.next.next = new SinglyLinkedListNode(5);

        printElementsOfLinkedList(sll);

        reverseTheLinkedList(sll);
        System.out.println("\n\nList after reversal");
        printElementsOfLinkedList(sll);
    }

    private static void reverseTheLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = null;
        SinglyLinkedListNode temp = sll.head;
        while (temp != null){
            current = temp;
            temp = temp.next;
            current.next = prev;
            prev = current;
        }
        sll.head = prev;
    }

    private static void printElementsOfLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }

}
