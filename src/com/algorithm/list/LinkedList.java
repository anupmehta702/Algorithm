package com.algorithm.list;

import java.util.List;

public class LinkedList {
    private Node root = null;

    public void createCycle(List<Integer> input) {
        input.forEach((index) -> {
            addData(index);
        });
        Node temp = root;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = root.next.next;
    }

    public boolean identifyCycle() {
        Node ftr = root;
        Node str = root;
        while (str.next != null) {
            ftr = ftr.next;
            str = str.next.next;
            if (ftr.data == str.data) {
                System.out.println("Cycle identified at - " + ftr.data);
                return true;
            }
        }
        return false;
    }

    public void addData(int data) {
        if (root == null) {
            root = new Node(data);
            return;
        } else {
            Node temp = root;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    public void printList() {
        if (root == null) {
            System.out.println("List is empty !");
        } else {
            Node temp = root;
            System.out.println("List -");
            while (temp != null) {
                System.out.print(" -> " + temp.data);
                temp = temp.next;
            }
            System.out.println();
        }
    }

    public void reverseLinkedList() {
        System.out.println("Before reversing the list -");
        printList();
        Node nextNode, temp = null;
        nextNode = root;
        while (nextNode != null) {
            nextNode = root.next;
            root.next = temp;
            temp = root;
            if (nextNode != null) {
                root = nextNode;
            }
        }
        System.out.println("after reversing the list - ");
        printList();
    }



    public void insertNodeInSortedList(int data) {
        Node current = root.next;
        Node temp = current;
        Node newNode = new Node(data);
        if (root.data > data) {
            newNode.next = root;
            root = newNode;
        } else {
            while (current != null) {
                if (current.data > data) {
                    temp.next = newNode;
                    newNode.next = current;
                    return;
                }
                temp = current;
                current = current.next;

            }
        }
    }

    public Integer findMiddleOfList() {
        Node first = root, second = root;
        int i = 0;
        while (first.next != null) {
            if (i == 0) {
                first = first.next;
                i++;
            } else {
                first = first.next;
                second = second.next;
                i = 0;
            }
        }
        return second.data;
    }

    public static LinkedList mergeTwoList(LinkedList aLL, LinkedList bLL) {
        LinkedList result = new LinkedList();
        Node a = aLL.root;
        Node b = bLL.root;
        Node temp = null;
        if (a.data < b.data) {
            result.root = new Node(a.data);
            a = a.next;
        } else {
            result.root = new Node(b.data);
            b = b.next;
        }
        temp = result.root;
        while (!(a == null && b == null)) {//condition is imp
            if (b == null) {
                while (a != null) {
                    temp.next = new Node(a.data);
                    temp = temp.next;//forgot this step
                    a = a.next;
                }
            } else if (a == null) { //got to have else if condition
                while (b != null) {
                    temp.next = new Node(b.data);
                    temp = temp.next;
                    b = b.next;
                }
            } else if (a.data < b.data) {
                temp.next = new Node(a.data);
                temp = temp.next;
                a = a.next;
            } else {
                temp.next = new Node(b.data);
                temp = temp.next;
                b = b.next;
            }
        }
        return result;
    }


}

class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}
