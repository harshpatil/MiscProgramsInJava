package main.linkedList.singly;

import java.util.Stack;

/*
    There are 2 approaches
    Approach 1)
        Identify middle element using slow & fast pointer
        Once Middle is found, reverse the 2nd half of list
        Start 2 pointers, 1 from beginning & other one from beginning of reversed half
        Move 1 node at a time by comparing each element
        If you reach end, it's a Palindrome

        Time Complexity O(n), space complexity O(1)

    Approach 2)
        Use 2 pointers slow & fast
        While moving slow pointer keep pushing data to a stack.
        Once Middle is found, only move slow pointer
        Check next item in list to top of stack. If they are same remove item from stack and go to next one.
        Repeat above step, if you reach end and there are no elements in stack, it's a Palindrome

        Time Complexity O(n), space complexity O(n)
 */
public class CheckIfContentsOfSinglyLinkedListIsAPalindrome {

    public static void main(String []args){

        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new SinglyLinkedListNode(0);
        sll.head.next = new SinglyLinkedListNode(0);
        sll.head.next.next = new SinglyLinkedListNode(0);
        sll.head.next.next.next = new SinglyLinkedListNode(1);
        sll.head.next.next.next.next = new SinglyLinkedListNode(0);
        sll.head.next.next.next.next.next = new SinglyLinkedListNode(0);
        sll.head.next.next.next.next.next.next = new SinglyLinkedListNode(0);

        printElementsOfLinkedList(sll);

        checkForPalindrome(sll);
    }

    private static void checkForPalindrome(SinglyLinkedList sll) {

        Stack<Integer> stack = new Stack<>();
        SinglyLinkedListNode slow = sll.head;
        SinglyLinkedListNode fast = sll.head;
        while (fast != null && fast.next!= null){
            stack.add(slow.data);
            slow=slow.next;
            fast=fast.next.next;
        }

        if(fast != null){
            slow = slow.next;
        }

        while (slow != null){
            if(stack.size() == 0 || stack.pop() != slow.data){
                System.out.println("\n List is not a Palindrome");
                System.exit(0);
            }
            slow = slow.next;
        }
        System.out.println("\n\nList is a Palindrome");
    }

    private static void printElementsOfLinkedList(SinglyLinkedList sll) {

        SinglyLinkedListNode current = sll.head;
        while (current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
    }
}
