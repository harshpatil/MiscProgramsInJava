package main.linkedList.singly;


public class CreateSinglyLinkedList {

    public static void main(String []args){

        SinglyLinkedList sll = new SinglyLinkedList();

        SinglyLinkedListNode first = new SinglyLinkedListNode(11);
        sll.head = first;

        SinglyLinkedListNode second = new SinglyLinkedListNode(21);
        sll.head.next = second;

        SinglyLinkedListNode third = new SinglyLinkedListNode(31);
        sll.head.next.next = third;

        printElementsOfLinkedList(sll);
    }

    private static void printElementsOfLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
