package main.linkedList.singly;

import java.util.HashSet;
import java.util.Set;

public class FindAnIntersectionOf2LinkedLists {

    public static void main(String[] args){

        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.head = new SinglyLinkedListNode(1);
        sll1.head.next = new SinglyLinkedListNode(2);
        sll1.head.next.next = new SinglyLinkedListNode(3);
        sll1.head.next.next.next = new SinglyLinkedListNode(4);
        SinglyLinkedListNode intersectionNode = new SinglyLinkedListNode(8);
        sll1.head.next.next.next.next = intersectionNode;


        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.head = new SinglyLinkedListNode(5);
        sll2.head.next = new SinglyLinkedListNode(6);
        sll2.head.next.next = new SinglyLinkedListNode(7);
        sll2.head.next.next.next = intersectionNode;
        sll2.head.next.next.next.next = new SinglyLinkedListNode(9);
        sll2.head.next.next.next.next.next = new SinglyLinkedListNode(10);

        System.out.println("List 1 :::");
        printElementsOfLinkedList(sll1);

        System.out.println("\nList 2 :::");
        printElementsOfLinkedList(sll2);

        findIntersectingNodeUsingHashSet(sll1, sll2);
        findIntersectingNodeUsingWithoutUsingHashSet(sll1, sll2);

    }

    private static void findIntersectingNodeUsingHashSet(SinglyLinkedList sll1, SinglyLinkedList sll2) {

        // This will work only if all the elements int the list are unique
        Set<Integer> hashSet = new HashSet<>();
        SinglyLinkedListNode current = sll1.head;
        while (current.next != null){
            hashSet.add(current.data);
            current=current.next;
        }

        SinglyLinkedListNode currentNodeList2 = sll2.head;
        while (currentNodeList2 != null){
            if(hashSet.contains(currentNodeList2.data)){
                System.out.println("\nIntersecting node :: "+currentNodeList2.data);
                return;
            }
            currentNodeList2=currentNodeList2.next;
        }
    }

    private static void findIntersectingNodeUsingWithoutUsingHashSet(SinglyLinkedList sll1, SinglyLinkedList sll2) {

        int lengthOfList1 = 0;
        int lengthOfList2 = 0;
        SinglyLinkedListNode tempList1 = sll1.head;
        SinglyLinkedListNode tempList2 = sll2.head;

        while (tempList1 != null){
            tempList1 = tempList1.next;
            lengthOfList1++;
        }

        while (tempList2 != null){
            tempList2 = tempList2.next;
            lengthOfList2++;
        }

        int diff = lengthOfList1 - lengthOfList2;
        if(diff > 0){
            tempList1 = sll1.head;
            for(int i=0; i<diff; i++){
                tempList1 = tempList1.next;
            }
            tempList2 = sll2.head;
        } else {
            tempList2 = sll2.head;
            for(int i=0; i<diff; i++){
                tempList2 = tempList2.next;
            }
            tempList1 = sll1.head;
        }

        while (tempList1.next != null || tempList2.next != null){
            if(tempList1.data == tempList2.data){
                System.out.println("\nIntersecting node :: "+tempList1.data);
                return;
            }
            tempList1 = tempList1.next;
            tempList2 = tempList2.next;
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
