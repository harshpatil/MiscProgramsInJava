package main.linkedList.singly;


public class CheckIfLinkedListHasLoop {

    public static void main(String []args){

        SinglyLinkedList sll = new SinglyLinkedList();
        createLinkedList(sll);
//        printElementsOfLinkedList(sll);
        checkIfLoopExist(sll);
        checkAtWhichNodeLoopStarts(sll);
    }

    public static void createLinkedList(SinglyLinkedList sll){

        SinglyLinkedListNode first = new SinglyLinkedListNode(1);
        sll.head = first;
        sll.head.next = new SinglyLinkedListNode(2);
        sll.head.next.next = new SinglyLinkedListNode(3);
        sll.head.next.next.next = new SinglyLinkedListNode(4);
        SinglyLinkedListNode loopNode = new SinglyLinkedListNode(5);
        sll.head.next.next.next.next = loopNode;
        sll.head.next.next.next.next.next = new SinglyLinkedListNode(6);
        sll.head.next.next.next.next.next.next = new SinglyLinkedListNode(7);
        sll.head.next.next.next.next.next.next.next = new SinglyLinkedListNode(8);
        sll.head.next.next.next.next.next.next.next.next = loopNode;
    }

    public static void checkIfLoopExist(SinglyLinkedList sll){

        SinglyLinkedListNode firstPointer = sll.head;
        SinglyLinkedListNode secondPointer = sll.head;

        while (firstPointer.next != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
            if(firstPointer == secondPointer){
                System.out.println("Loop exist");
                break;
            }
        }
    }

    public static void checkAtWhichNodeLoopStarts(SinglyLinkedList sll){

        SinglyLinkedListNode firstPointer = sll.head;
        SinglyLinkedListNode secondPointer = sll.head;

        while (firstPointer.next != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
            if(firstPointer == secondPointer){
                firstPointer = sll.head;
                break;
            }
        }

        while (firstPointer.next != null){
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
            if(firstPointer == secondPointer){
                System.out.println("Loop starts at node :: "+ firstPointer.data);
                break;
            }
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
