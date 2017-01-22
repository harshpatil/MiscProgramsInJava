package main.identicalTrees;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static java.lang.System.exit;
import static java.lang.System.in;

/**
 *                              Question
 ======================================================================
 - Write a program to check if the 2 trees are identical or not


 Assumption
 =========================================================================
 - Input value is only integer
 - Input values are stored in the form of binary search tree


 Solution
 =========================================================================
 - Take size of the trees and elements of the trees from command line
 - Store each element as a node of the tree
 - Insertion of elements happen as per the rules of binary search tree


 How to Run
 ========================================================================
 - import this project in any of the java editors
 - Run main method
 - Input size of first tree
 - Enter first tree elements
 - Input size of second tree
 - Enter second tree elements
 - Algorithm will tell you, if 2 trees are identical or not


 *
 * Created by HarshPatil on 11/17/16.
 */
public class IdenticalTrees {

    public static void main(String args[]) throws Exception {

        Tree firstTree = new Tree();
        Tree secondTree = new Tree();

        System.out.println("Enter size of the first binary search Tree");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int firstTreeSize = Integer.parseInt(bufferedReader.readLine());

        int start = 0;
        while (start != firstTreeSize){
            System.out.println("Enter element : "+ start);
            int input = Integer.parseInt(bufferedReader.readLine());
            firstTree.insert(input);
            start++;
        }

        System.out.println("Elements of first binary search tree ::: ");
        firstTree.printInputTree();

        System.out.println("\nEnter Size of the second binary search tree");
        int secondTreeSize = Integer.parseInt(bufferedReader.readLine());

        if(secondTreeSize != firstTreeSize) {

            System.out.println("Two trees are not identical");
            exit(0);
        } else {

            start = 0;
            while (start != secondTreeSize){

                System.out.println("Enter element : "+start);
                int input = Integer.parseInt(bufferedReader.readLine());
                secondTree.insert(input);
                start++;
            }

            System.out.println("Elements of second binary search tree ::: ");
            secondTree.printInputTree();
        }

        firstTree.identicalTest(firstTree, secondTree);
    }

}
