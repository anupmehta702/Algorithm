package com.algorithm.list;


public class AddTwoNumbers {
    public static void main(String[] args) {
        AddTwoNumbers aTN = new AddTwoNumbers();
        ListNode l1, l2 = null;

        l1 = new ListNode(1);
        l1.next = new ListNode(8);
        l2 = new ListNode(0);
        aTN.printSumOfTwoNumbers(l1,l2);

        l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        aTN.printSumOfTwoNumbers(l1, l2);

        l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);

        l2 = new ListNode(0);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(1);
        aTN.printSumOfTwoNumbers(l1,l2);

        l1 = new ListNode(9);
        l1.next = new ListNode(8);
        l2 = new ListNode(1);
        aTN.printSumOfTwoNumbers(l1,l2);

    }

    public void printSumOfTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = addTwoNumbers(l1, l2);
        System.out.println("Resultant list -->");
        while (result != null) {
            System.out.print("-->" + result.val);
            result = result.next;
        }
        System.out.println();
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1Temp = l1;
        ListNode l2Temp = l2;
        ListNode resultListNode = new ListNode(-1);
        ListNode tempResultListNode = resultListNode;
        int carryForward = 0;
        while (l1Temp != null || l2Temp != null) {
            int x = l1Temp!=null ? l1Temp.val : 0;
            int y = l2Temp!=null ? l2Temp.val : 0;
            int sum = x + y + carryForward;
            int result = (sum) % 10;
            carryForward = sum / 10;
            tempResultListNode = addNodeToResultList(tempResultListNode, result);
            if (l1Temp != null) {
                l1Temp = l1Temp.next;
            }
            if (l2Temp != null) {
                l2Temp = l2Temp.next;
            }
        }
        if (carryForward != 0) {
            addNodeToResultList(tempResultListNode, carryForward);
        }
        return resultListNode.next;

    }

    public ListNode addNodeToResultList(ListNode tempResultListNode, int result) {
        tempResultListNode.next = new ListNode(result);
        return tempResultListNode.next;

    }

    public ListNode addNodeToResultList1(ListNode tempResultListNode, int result) {
        if ( tempResultListNode.val == -1) {
            tempResultListNode.val = result;
            return tempResultListNode;
        }
        ListNode resultNode = new ListNode(result);
        tempResultListNode.next = resultNode;
        return tempResultListNode.next;

    }
}

/*
Output -
Input 81 +0 Resultant list -->
-->1-->8
input 342+465 esultant list -->
-->7-->0-->8
Input 999 + 1 Resultant list -->
-->9-->9-->0-->1
input 89 +1 Resultant list -->
-->0-->9
 */
