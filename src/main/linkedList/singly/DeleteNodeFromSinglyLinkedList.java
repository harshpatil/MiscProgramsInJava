package main.linkedList.singly;

public class DeleteNodeFromSinglyLinkedList {

    public static void main(String []args){
        SinglyLinkedList sll = new SinglyLinkedList();

        SinglyLinkedListNode first = new SinglyLinkedListNode(11);
        sll.head=first;
        sll.head.next = new SinglyLinkedListNode(21);
        sll.head.next.next = new SinglyLinkedListNode(31);
        sll.head.next.next.next = new SinglyLinkedListNode(41);
        sll.head.next.next.next.next = new SinglyLinkedListNode(51);

        printElementsOfLinkedList(sll);

        int nodeTobeDeleted = 31;
        deleteGivenNode(sll, nodeTobeDeleted);

        System.out.println("\n\nAfter deleting node "+ nodeTobeDeleted);
        printElementsOfLinkedList(sll);

        deleteFirstNode(sll);
        System.out.println("\n\nAfter deleting the first Node");
        printElementsOfLinkedList(sll);

        deleteLastNode(sll);
        System.out.println("\n\nAfter deleting the last Node");
        printElementsOfLinkedList(sll);

    }

    private static void deleteLastNode(SinglyLinkedList sll) {

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = sll.head;
        while (current.next != null){
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }

    private static void deleteFirstNode(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        sll.head = current.next;
    }

    private static void deleteGivenNode(SinglyLinkedList sll, int nodeTobeDeleted) {

        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = sll.head;
        while (current.data != nodeTobeDeleted){
            prev = current;
            current = current.next;
        }
        prev.next = current.next;
    }

    private static void printElementsOfLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
