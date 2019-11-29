package com.algorithm.list;

public class OddEvenList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution1 solution1= new Solution1();
        ListNode output =solution1.oddEvenList(head);
        System.out.println("Output --");
        while(output.next!=null){
            System.out.print(" "+output.val+" , ");
            output=output.next;
        }
    }
}


class Solution1 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null)
            return null;
        ListNode oddHead = head ,odd = head ,evenHead =head.next, even = head.next ;
        while(odd.next != null && even.next != null){
            if(odd != null) {
                odd.next = even.next;
                odd = odd.next;
            }
            if(even != null){
                even.next=odd.next;
                even = even.next;
            }
        }
        odd.next = evenHead;
        return oddHead;
    }
}
/*
Input --  1 , 2 , 3 , 4 , 5
Output -- 1 ,  3 ,  5 ,  2 ,
 */