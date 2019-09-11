package com.algorithm.list;

import java.util.ArrayList;
import java.util.List;

import static com.algorithm.list.LinkedList.*;

public class LinkedListRunner {
    public static void main(String[] args) {
        mergeLinkedLists();
        identifyCycle();
        LinkedList ll = new LinkedList();
        ll.addData(1);ll.addData(2);ll.addData(4);ll.addData(5);ll.addData(6);

        System.out.println("Middle of linked list is - "+ll.findMiddleOfList());

        ll.insertNodeInSortedList(3);

        ll.printList();

        System.out.println("Middle of linked list is - "+ll.findMiddleOfList());

        ll.reverseLinkedList();
    }

    public static void identifyCycle(){
        LinkedList llWithCycle = new LinkedList();
        List<Integer> inputList = new ArrayList<>();
        inputList.add(1);inputList.add(2);inputList.add(3);inputList.add(4);
        inputList.add(5);inputList.add(5);inputList.add(6);inputList.add(8);
        llWithCycle.createCycle(inputList);
        System.out.println("Does linked list have cycle - "+llWithCycle.identifyCycle());
    }

    public static void mergeLinkedLists(){
        LinkedList ll = new LinkedList();
        ll.addData(1);ll.addData(4);ll.addData(10);ll.addData(13);

        LinkedList ll2 = new LinkedList();
        ll2.addData(2);ll2.addData(3);ll2.addData(11);ll2.addData(12);ll2.addData(15);

        LinkedList mergedList = mergeTwoList(ll,ll2);
        mergedList.printList();

    }


}
/*Output
List -
 -> 1 -> 2 -> 3 -> 4 -> 10 -> 11 -> 12 -> 13 -> 15
Cycle identified at - 5
Does linked list have cycle - true
Middle of linked list is - 4
List -
 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
Middle of linked list is - 3
Before reversing the list -
List -
 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6
after reversing the list -
List -
 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1
 */