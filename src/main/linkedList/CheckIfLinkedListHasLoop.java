package main.linkedList;

/**
 * Created by HarshPatil on 8/26/17.
 */
public class CheckIfLinkedListHasLoop {

    public static void main(String []args){

        NodeList nodeList = new NodeList();
        createLinkedList(nodeList);
//        nodeList.printList();
        checkIfLoopExist(nodeList);
        checkAtWhichNodeLoopStarts(nodeList);
    }

    public static void createLinkedList(NodeList nodeList){

        Node node = new Node(5);
        nodeList.insertNodeAtBeginning(1);
        nodeList.insertNodeAtEnd(2);
        nodeList.insertNodeAtEnd(3);
        nodeList.insertNodeAtEnd(4);
        nodeList.insertNodeAtEnd(node);
        nodeList.insertNodeAtEnd(6);
        nodeList.insertNodeAtEnd(7);
        nodeList.insertNodeAtEnd(8);
        nodeList.loopNode(node);
    }

    public static void checkIfLoopExist(NodeList nodeList){

        Node firstPointer = nodeList.getFirst();
        Node secondPointer = nodeList.getFirst();

        while (firstPointer.getNext() != null){
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext().getNext();
            if(firstPointer == secondPointer){
                System.out.println("Loop exist");
                break;
            }
        }
    }

    public static void checkAtWhichNodeLoopStarts(NodeList nodeList){

        Node firstPointer = nodeList.getFirst();
        Node secondPointer = nodeList.getFirst();

        while (firstPointer.getNext() != null){
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext().getNext();
            if(firstPointer == secondPointer){
                firstPointer = nodeList.getFirst();
                break;
            }
        }

        while (firstPointer.getNext() != null){
            firstPointer = firstPointer.getNext();
            secondPointer = secondPointer.getNext();
            if(firstPointer == secondPointer){
                System.out.println("Loop starts at node :: "+ firstPointer.getData());
                break;
            }
        }
    }
}
