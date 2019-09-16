package com.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeForTraversal {

    public Node root = null;

    public void insertData(List<Integer> dataList) {
        for (int data : dataList) {
            insertNode(root, data);
        }
    }

    public void insertData(int dataToAdd) {
        System.out.println("Adding element - " + dataToAdd);
        insertNode(root, dataToAdd);
    }

    private Node insertNode(Node current, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (current == null) { //these are leaf nodes that we are adding
            return new Node(data);
        }
        if (current.data < data) {
            current.right = insertNode(current.right, data);//forgot to do the assignment
        } else if (current.data > data) {
            current.left = insertNode(current.left, data);
        } else {
            return current;
        }
        return current;
    }

    public void inOrder() {
        System.out.println("Printing in-order(LNR) -> ");
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public void preOrder() {
        System.out.println("Printing pre-order(NLR) -> ");
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder() {
        System.out.println("Printing post-order(LRN) -> ");
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public void printLeafNodes() {
        System.out.println("Printing leaf nodes -> ");
        printLeafNodes(root);
        System.out.println();
    }

    private Node printLeafNodes(Node root) {
        if (root == null) {
            return null;
        }
        Node left = printLeafNodes(root.left);
        Node right = printLeafNodes(root.right);
        //if (left.left == null && right == null) { //this is same as postOrder
        if (root.left == null && root.right == null) {
            System.out.print(root.data + " ");
        }
        return null;
    }

    public void levelOrderTraversal() {
        System.out.println("Level order tree ->");
        LinkedList<Node> list = new LinkedList<>();
        if (root == null) {
            System.out.println("No nodes present");
            return;
        }
        list.add(root);

        while (!list.isEmpty()) {
            Node temp = list.remove();
            System.out.print(temp.data + " ");
            if (temp.left != null) {
                list.add(temp.left);
            }
            if (temp.right != null) {
                list.add(temp.right);
            }
        }
        System.out.println();
    }


    public static void main(String[] args) {
        BinaryTreeForTraversal bt = new BinaryTreeForTraversal();
        List<Integer> inputList = new ArrayList<>();
        inputList.add(6);
        inputList.add(4);
        inputList.add(8);
        inputList.add(3);
        inputList.add(5);
        inputList.add(7);
        inputList.add(9);
        /*
                     6
                  4     8
                 3 5   7 9
         */

        bt.insertData(inputList);
        bt.levelOrderTraversal();
        bt.inOrder();
        bt.preOrder();
        bt.postOrder();
        bt.printLeafNodes();
    }

}
/*Output
Level order tree ->
6 4 8 3 5 7 9
Printing in-order(LNR) ->
3 4 5 6 7 8 9
Printing pre-order(NLR) ->
6 4 3 5 8 7 9
Printing post-order(LRN) ->
3 5 4 7 9 8 6
Printing leaf nodes ->
3 5 7 9
 */
