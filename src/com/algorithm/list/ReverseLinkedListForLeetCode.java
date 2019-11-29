package com.algorithm.list;

public class ReverseLinkedListForLeetCode {

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1);
        head.next = new ListNode1(2);
        head.next.next = new ListNode1(3);
        head.next.next.next = new ListNode1(4);
        head.next.next.next.next = new ListNode1(5);
        Solution solution = new Solution();
        System.out.println("Reversing the list -->");
        printListNode(solution.reverseList(head));
        printListNode(solution.reverseBetween(head, 2, 4));
        head = new ListNode1(3);
        head.next = new ListNode1(5);
        System.out.println("Reverse between output -->");
        //printListNode(solution.reverseBetween(head, 1, 2));
        System.out.println("head -->"+head.val+" next -->"+head.next.val);
    }
    public static void printListNode(ListNode1 root){
        ListNode1 temp = root ;
        while(temp!=null){
            System.out.print(" "+temp.val+" ,");
            temp=temp.next;
        }
        System.out.println();
    }

}

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x) {
        val = x;
    }
}

class Solution {
    public ListNode1 reverseList(ListNode1 head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode1 temp = null;
        ListNode1 nextNode = head.next;
        ListNode1 newHead = head;
        while (newHead != null) {
            newHead.next = temp;
            temp = newHead;
            newHead = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
        }
        return temp;

    }

    public ListNode1 reverseBetween(ListNode1 head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode1 previous = head, head1 = head;
        for (int i = 1; i < m; i++) {
            previous = head1;
            head1 = head1.next;
        }
        previous.next = reverse(previous, head1, n - m);
        return head;

    }

    public ListNode1 reverse(ListNode1 previous, ListNode1 head, int n) {
        ListNode1 head1 = head, temp = previous, nextNode = head1.next;
        int count = 0;
        while (count <= n) {
            if (head1 == null) {
                break;
            }
            head1.next = temp;
            temp = head1;
            head1 = nextNode;
            if (nextNode != null) {
                nextNode = nextNode.next;
            }
            count++;
        }
        if (head1 != null) {
            head.next = head1;
        }
        return temp;

    }
}
/*
Input - 1 , 2 , 3 , 4 , 5
output - Reversing the list -->
 1 , 4 , 3 , 2 , 5 ,
output -Reversing the list between 1 & 4 -->
 1 , 4 , 3 , 2 , 5 ,
 */