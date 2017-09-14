package main.tree.binarySearchTree;

/*
    Design a data structure to do reservations of future jobs on a single machine under
    following constraints.
        1) Every job requires exactly k time units of the machine.
        2) The machine can do only one job at a time.
        3) Time is part of the system. Future Jobs keep coming at different times.
            Reservation of a future job is done only if there is no existing reservation
            within k time frame (after and before)
        4) Whenever a job finishes (or its reservation time plus k becomes equal to
            current time), it is removed from system.

    Let time taken by a job (or k) be = 4

    At time 0: Reservation request for a job at time 2 in
               future comes in, reservation is done as machine
               will be available (no conflicting reservations)
    Reservations {2}

    At time 3: Reservation requests at times 15, 7, 20 and 3.
               Job at 7, 15 and 20 can be reserved, but at 3
               cannot be reserved as it conflicts with a
               reserved at 2.
    Reservations {2, 7, 15, 20}

    At time 6: Reservation requests at times 30, 17, 35 and 45
               Jobs at 30, 35 and 45 are reserved, but at 17
               cannot be reserved as it conflicts with a reserved
               at 15.
    Reservations {7, 15, 30, 35, 45}.
    Note that job at 2 is removed as it must be finished by 6.

    http://www.geeksforgeeks.org/data-structure-for-future-reservations-for-a-single-resource/

 */
public class DataStructureForASingleResourceReservations {

    public static void main(String[] args){

        int timeTakenByAJob = 4;
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = insertElement(null, 2, timeTakenByAJob);

        System.out.println("Inorder Traversal at Time 0");
        printInOrder(tree.root);

        insertElement(tree.root, 15, timeTakenByAJob);
        insertElement(tree.root, 7, timeTakenByAJob);
        insertElement(tree.root, 20, timeTakenByAJob);
        insertElement(tree.root, 3, timeTakenByAJob);
        System.out.println("\nInorder Traversal at Time 3");
        printInOrder(tree.root);

        insertElement(tree.root, 30, timeTakenByAJob);
        insertElement(tree.root, 17, timeTakenByAJob);
        insertElement(tree.root, 35, timeTakenByAJob);
        insertElement(tree.root, 45, timeTakenByAJob);
        tree.root = deleteKey(tree.root, 2);
        System.out.println("\nInorder Traversal at Time 6");
        printInOrder(tree.root);

        tree.root = deleteKey(tree.root, 7);
        tree.root = deleteKey(tree.root, 15);
        System.out.println("\nInorder Traversal at Time 20");
        printInOrder(tree.root);
    }

    private static BSTNode insertElement(BSTNode root, int time, int timeTakenByAJob) {

        if(root == null){
            root = new BSTNode(time);
            return root;
        }

        if(((time-timeTakenByAJob)<root.data) && ((time+timeTakenByAJob)>root.data)){
            return root;
        }

        if(time < root.data){
            root.left = insertElement(root.left, time, timeTakenByAJob);
        } else {
            root.right = insertElement(root.right, time, timeTakenByAJob);
        }
        return root;
    }

    private static void printInOrder(BSTNode root) {

        if(root == null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    private static BSTNode deleteKey(BSTNode root, int keyToBeDeleted) {

        if(root == null){
            return root;
        }

        if(keyToBeDeleted == root.data){
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            root.data = min(root.right);
            root.right = deleteKey(root.right, root.data);
        }
        else if(keyToBeDeleted < root.data){
            root.left = deleteKey(root.left, keyToBeDeleted);
        }
        else {
            root.right = deleteKey(root.right, keyToBeDeleted);
        }
        return root;
    }

    private static int min(BSTNode root) {

        int min = root.data;
        while (root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }
}
