package main.stack;

/*
    http://www.geeksforgeeks.org/c-program-for-tower-of-hanoi/

    Tower of Hanoi is a mathematical puzzle where we have three rods and n disks.
    The objective of the puzzle is to move the entire stack to another rod, obeying
    the following simple rules:
    1) Only one disk can be moved at a time.
    2) Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e. a disk can only be moved if it is the uppermost disk on a stack.
    3) No disk may be placed on top of a smaller disk.
 */
public class TowerOfHanoi {

    public static void main(String[] args){

        int numberOfDisks = 3;
        towerOfHanoi(numberOfDisks, "SOURCE", "DESTINATION", "HELPER");
    }

    private static void towerOfHanoi(int numberOfDisks, String source, String destination, String helper) {

        if(numberOfDisks == 1){
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        towerOfHanoi(numberOfDisks-1, source, helper, destination);
        System.out.println("Move disk " + numberOfDisks +" from " + source + " to " + destination);
        towerOfHanoi(numberOfDisks-1, helper, destination, source);
    }
}
