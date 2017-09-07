package main.linkedList.singly;


public class DeleteTheMiddleNodeFromSLL {

    public static void main(String[] args){

        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new SinglyLinkedListNode(1);
        sll.head.next = new SinglyLinkedListNode(2);
        sll.head.next.next = new SinglyLinkedListNode(3);
        sll.head.next.next.next = new SinglyLinkedListNode(4);
        sll.head.next.next.next.next = new SinglyLinkedListNode(5);
        sll.head.next.next.next.next.next = new SinglyLinkedListNode(6);

        printElementsOfLinkedList(sll);

        deleteTheMiddleNode(sll);
        System.out.println("\nList after deleting middle element");
        printElementsOfLinkedList(sll);
    }

    private static void deleteTheMiddleNode(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        int length = 0;
        while (current.next != null){
            length++;
            current=current.next;
        }

        int i=0;
        current = sll.head;
        SinglyLinkedListNode temp;
        while (i<(length/2)){
            current=current.next;
            i++;
        }
        temp = current.next;
        current.data = temp.data;
        current.next = temp.next;
    }

    private static void printElementsOfLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
