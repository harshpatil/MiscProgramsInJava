package main.linkedList.singly;

public class FindMiddleOfSLL {

    public static void main(String []args){

        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new SinglyLinkedListNode(1);
        sll.head.next = new SinglyLinkedListNode(2);
        sll.head.next.next = new SinglyLinkedListNode(3);
        sll.head.next.next.next = new SinglyLinkedListNode(4);
        sll.head.next.next.next.next = new SinglyLinkedListNode(5);
        sll.head.next.next.next.next.next = new SinglyLinkedListNode(6);

        printElementsOfLinkedList(sll);
        findTheMiddleNode(sll);
    }

    private static void findTheMiddleNode(SinglyLinkedList sll) {

        SinglyLinkedListNode slowPointer = sll.head;
        SinglyLinkedListNode fastPointer = sll.head;
        while (fastPointer != null && fastPointer.next != null){
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        System.out.println("\nMiddle Node is :: " + slowPointer.data);
    }

    private static void printElementsOfLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
