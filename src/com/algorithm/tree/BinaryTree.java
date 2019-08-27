package com.algorithm.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    private Node root = null;

    public void insertData(List<Integer> dataList) {
        for (int data : dataList) {
            insertNode(root, data);
        }
    }

    public void insertData(int dataToAdd) {
        System.out.println("Adding element - "+dataToAdd);
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

    public void deleteElement(int dataToDelete) {
        System.out.println();
        System.out.println("-- Tree structure before deletion of "+dataToDelete+" --");
        print();
        deleteElement(root, dataToDelete);
        System.out.println("-- Tree structure after deletion of "+dataToDelete+" --");
        print();
        System.out.println();
    }

    public Node deleteElement(Node current, int dataToDelete) {
        if (current == null) {
            System.out.println("Root itself is null");
            return null;
        }
        if (current.data > dataToDelete) {
            current.left = deleteElement(current.left, dataToDelete);
        } else if (current.data < dataToDelete) {
            current.right = deleteElement(current.right, dataToDelete);
        } else {
            if (current.left != null && current.right != null) {
                System.out.println("Data to delete is a node with both left and right children ");
                //Find min from right subtree
                Node minNodeFromRight = findMin(current.right);
                //replace current with the min from right subtree
                System.out.println("Replacing data to delete with -" + minNodeFromRight.data);
                current.data = minNodeFromRight.data;
                //delete the min Node from right (which would be always on the left of the current)
                deleteElement(current.right, minNodeFromRight.data);//need to find the replaced root from right of current node

            } else {
                // if nodeToBeDeleted has only left child
                if (current.left != null) {
                    System.out.println("Data to delete had only left child .");
                    current = current.left;
                }// if nodeToBeDeleted has only right child
                else if (current.right != null) {
                    System.out.println("Data to delete had only right child .");
                    current = current.right;
                }// if nodeToBeDeleted has no child
                else {
                    System.out.println("Data to delete is a leaf ");
                    current = null;
                }
            }
        }

        return current;//by mistake returned null
    }

    private Node findMin(Node root) {
        if (root.left != null) {
            root=findMin(root.left);//forgot to assign to root
        }
        return root;
    }

    public void print() {
        LinkedList<Node> list = new LinkedList<>();
        if (root == null) {
            System.out.println("No nodes present");
            return;
        }
        list.add(root);

        while (!list.isEmpty()) {
            Node temp = list.remove();
            System.out.print(" " + temp.data);
            if (temp.left != null) {
                list.add(temp.left);
            }
            if (temp.right != null) {
                list.add(temp.right);
            }
        }
        System.out.println();
    }

    public int getDepth() {
        int count =0;
        LinkedList<Node> list = new LinkedList<>();
        if (root == null) {
            System.out.println("No nodes present");
            return count;
        }
        list.add(root);
        list.add(null);
        count =1;

        while (!list.isEmpty()) {
            Node temp = list.remove();
            System.out.print(" " + temp.data);

            if (temp.left != null) {
                list.add(temp.left);
            }
            if (temp.right != null) {
                list.add(temp.right);
            }
        }
        System.out.println();
        return count;
    }


    public void containsNode(int dataToSearch) {
        System.out.println(" value "+dataToSearch+" is present - "+containsNode(root, dataToSearch));
    }

    private boolean containsNode(Node current, int value) {
        if (current == null) {
            return false;
        }
        if (current.data == value) {
            return true;
        }

        return value > current.data ? containsNode(current.right, value) : containsNode(current.left, value);
    }

    public void printPath(int targetData){
        List<Integer> path = new ArrayList<>();
        printPath(root,path,targetData);
        System.out.println("Printing path to "+targetData);
        path.forEach((data)-> System.out.print(" -> "+data));
        System.out.println();
    }

    public void printAllPath(){
        printAllPath(root,new ArrayList<>());
    }

    private void printAllPath(Node current ,List<Integer> path ){
        if(current == null){
            return;
        }else{
            path.add(current.data);
        }
        if(current.right == null && current.left == null){
            System.out.println("Printing path ");
            path.forEach((data)-> System.out.print(" -> "+data));
            System.out.println();
        }else{
            //below are the steps to traverse a node from left to right ie. print left first ,come to head,print right
            printAllPath(current.left,path);
            printAllPath(current.right,path);
        }

    }


    private void printPath(Node current,List<Integer> path,int targetData){
        if(targetData == current.data){
            path.add(current.data);
            return;
        }else{
            if(targetData > current.data){
                path.add(current.data);
                printPath(current.right,path,targetData);
            }else{
                path.add(current.data);
                printPath(current.left,path,targetData);
            }
        }
        return ;
    }

    public void doMirror(){
        System.out.println("Tree before mirror");
        print();
        mirror(root);
        System.out.println("Tree after mirror");
        print();
    }

    private Node mirror(Node current){
        if(current == null){
            return current;
        }
        Node left = mirror(current.left);
        Node right = mirror(current.right);
        //THis is where you get a leaf node or a node ,you interchange thier left right
        /*
                     7
                  4     8
                 3 5      9
         */
        //Example first it goes to 3 ,then 5 ,then 4 swaps it's left right,then goes to 8 to then null,then 9,then null,
        // then 8 again to swap it's right left,then goes to 7 and swaps 4 and 8
        current.left = right;
        current.right= left;

        return current;
    }


}

class Node {
    int data;
    Node right;
    Node left;

    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}
