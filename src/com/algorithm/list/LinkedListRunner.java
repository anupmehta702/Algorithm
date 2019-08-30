package com.algorithm.list;

public class LinkedListRunner {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addData(1);
        ll.addData(2);
        ll.addData(4);
        ll.addData(5);
        ll.addData(6);

        ll.insertNodeInSortedList(3);

        ll.printList();

        ll.reverseLinkedList();


    }
}
