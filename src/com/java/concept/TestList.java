package com.java.concept;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        testLinkedList();
    }
    public static void testLinkedList() {
        List<Order> orderList = new LinkedList<>();
        orderList.add(new Order(4, "D"));
        orderList.add(new Order(1, "A"));
        orderList.add(new Order(2, "B"));
        orderList.add(new Order(3, "C"));
        System.out.print("Order LinkedList -->");
        for (int index = 0; index < orderList.size(); index++) {
            System.out.print(" " + orderList.get(index));// get(index) allowed but it runs a loop to reach that index
            /* internal get() code for linkedList
            Node<E> node(int index) {
              if (index < (size >> 1)) {
                Node<E> x = first;
                for (int i = 0; i < index; i++)
                    x = x.next;
                return x;
              } else {
                Node<E> x = last;
                for (int i = size - 1; i > index; i--)
                    x = x.prev;
                return x;
              }
            }
             */
            if(orderList.size()==4)
                orderList.add(new Order(5,"E"));
        }
        System.out.println();
        orderList.sort(new ComparatorForOrder());
        System.out.print("Ordered List --> ");
        for(Order input : orderList){
            System.out.print(input);
           // orderList.add(new Order(6,"F")); throws checkForComodification exception
        }
        System.out.println();
    }
}
class ComparatorForOrder implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        if(o1 == null && o2 == null) return 0;
        if(o1 == null && o2!=null) return -1;
        if(o2 == null && o1!=null) return 1;
        if(o1.orderNumber > o2.orderNumber) return 1;
        if(o1.orderNumber < o2.orderNumber) return -1;
        return 0;
        // or simple use this --> return o1.compareTo(o2);
        //else o1.orderNumber.compareTo(o2.orderNumber);
    }
    public int compareUsingTwoParameters(Order o1, Order o2) {
        int  compareForOrderNumber= o1.orderNumber.compareTo(o2.orderNumber);
        int compareForName = o1.name.compareTo(o2.name);
        return compareForOrderNumber == 0 ? compareForName : compareForOrderNumber;
    }
}

/*Output
Order LinkedList --> {orderNumber=4, name='D'} {orderNumber=1, name='A'} {orderNumber=2, name='B'} {orderNumber=3, name='C'} {orderNumber=5, name='E'}
Ordered List --> {orderNumber=1, name='A'}{orderNumber=2, name='B'}{orderNumber=3, name='C'}{orderNumber=4, name='D'}{orderNumber=5, name='E'}
 */
