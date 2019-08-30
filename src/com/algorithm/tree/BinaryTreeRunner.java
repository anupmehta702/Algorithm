package com.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRunner {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        List<Integer> inputList = new ArrayList<>();
        inputList.add(6);inputList.add(4);inputList.add(8);inputList.add(3);inputList.add(5);inputList.add(7);inputList.add(9);
        /*
                     6
                  4     8
                 3 5   7 9
         */

        bt.insertData(inputList);
        bt.print();

        bt.containsNode(6);bt.containsNode(8);bt.containsNode(3);bt.containsNode(1);

        bt.insertData(2);
        bt.insertData(1);
        /*
                     6
                  4     8
                 3 5   7 9
                2
               1
         */
        bt.deleteElement(1);
        bt.deleteElement(2);

        bt.insertData(10);
        bt.deleteElement(10);

        bt.deleteElement(3);
        bt.insertData(3);
         /*
                     6
                  4     8
                 3 5   7 9
         */

        bt.deleteElement(6);

        bt.printPath(9);
        bt.printPath(3);

        bt.printAllPath();

        bt.doMirror();

        checkIfBinaryTreeIsABinarySearchTree();

    }

    public static void checkIfBinaryTreeIsABinarySearchTree(){
        BinaryTree bt = new BinaryTree();
        bt.root = new Node(3);
        bt.root.right = new Node(4);
        bt.root.right.right = new Node(5);
        bt.root.right.left = new Node(2);
        /*
            3
              4
             2 5
           THis is binary tree but not a binary search tree because 2 should be at left of 3
           and not on   right of 3 .
           BST is tree where left is always smaller than parent node
           and right is always greater than parent node .

         */
        bt.print();
        System.out.println("Is it a binary search tree ? -"+bt.isBST());

    }
}
/*
  6 4 8 3 5 7 9
 value 6 is present - true
 value 8 is present - true
 value 3 is present - true
 value 1 is present - false
Adding element - 2
Adding element - 1

-- Tree structure before deletion of 1 --
 6 4 8 3 5 7 9 2 1
Data to delete is a leaf
-- Tree structure after deletion of 1 --
 6 4 8 3 5 7 9 2


-- Tree structure before deletion of 2 --
 6 4 8 3 5 7 9 2
Data to delete is a leaf
-- Tree structure after deletion of 2 --
 6 4 8 3 5 7 9

Adding element - 10

-- Tree structure before deletion of 10 --
 6 4 8 3 5 7 9 10
Data to delete is a leaf
-- Tree structure after deletion of 10 --
 6 4 8 3 5 7 9


-- Tree structure before deletion of 3 --
 6 4 8 3 5 7 9
Data to delete is a leaf
-- Tree structure after deletion of 3 --
 6 4 8 5 7 9

Adding element - 3

-- Tree structure before deletion of 6 --
 6 4 8 3 5 7 9
Data to delete is a node with both left and right children
Replacing data to delete with -7
Data to delete is a leaf
-- Tree structure after deletion of 6 --
 7 4 8 3 5 9

Printing path to 9
 -> 7 -> 8 -> 9
Printing path to 3
 -> 7 -> 4 -> 3
Printing path
 -> 7 -> 4 -> 3
Printing path
 -> 7 -> 4 -> 3 -> 5
Printing path
 -> 7 -> 4 -> 3 -> 5 -> 8 -> 9

 */
