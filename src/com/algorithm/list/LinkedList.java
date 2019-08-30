package com.algorithm.list;

public class LinkedList {
    private Node root=null;

    public void addData(int data){
        if(root==null){
            root = new Node(data);
            return;
        }
        else{
            Node temp = root;
            while(temp.next !=null){
                temp= temp.next;
            }
            temp.next = new Node(data);
        }
    }
    public void printList(){
        if(root==null){
            System.out.println("List is empty !");
        }else
        {
            Node temp = root;
            System.out.println("List -");
            while(temp!=null){
                System.out.print(" -> "+temp.data);
                temp= temp.next;
            }
            System.out.println();
        }
    }

    public void reverseLinkedList(){
        System.out.println("Before reversing the list -");
        printList();
        Node nextNode,temp = null;
        nextNode=root;
        while(nextNode !=null){
            nextNode= root.next;
            root.next=temp;
            temp=root;
            if(nextNode!=null) {
                root = nextNode;
            }
        }
        System.out.println("after reversing the list - ");
        printList();
    }

    public void insertNodeInSortedList(int data){
        Node current = root.next;
        Node temp = current;
        Node newNode = new Node(data);
        if(root.data > data){
            newNode.next=root;
            root=newNode;
        }else{
            while(current!=null){
                if(current.data > data){
                    temp.next=newNode;
                    newNode.next=current;
                    return;
                }
                temp=current;
                current=current.next;

            }
        }
    }


}
class Node{

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }
}
