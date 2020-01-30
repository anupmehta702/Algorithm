package com.java.concept.setAndList;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TestTreeSet {
    public static void main(String[] args) {
        testTreeSet();
    }

    public static void testTreeSet(){
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);treeSet.add(20);
        treeSet.add(5);treeSet.add(1);
        System.out.print("TreeSet -->");
        for(Integer input : treeSet){
            System.out.print(" "+input);
        }
        System.out.println();
        for(int index =0 ;index<treeSet.size();index++){
            //treeSet has got no get function
        }
        System.out.print("Tree set using stream -->");
        treeSet.stream().forEach((input)-> System.out.print(" "+input));
        System.out.println();

        /*
        for(Integer input : treeSet){
            System.out.print(" "+input);
            treeSet.add(2);//Throws concurrentModification exception
        }
        */

        Set<Order> treeSetForOrder = new TreeSet<>();
        //No compile time exception ,but runtime exception if Order is not comparable
        //java.lang.ClassCastException: com.java.concept.Set.Order cannot be cast to java.lang.Comparable

        treeSetForOrder.add(new Order(4,"D"));
        treeSetForOrder.add(new Order(1,"A"));
        treeSetForOrder.add(new Order(3,"C"));
        treeSetForOrder.add(new Order(2,"B"));
        treeSetForOrder.add(new Order(7,"B"));
        treeSetForOrder.add(new Order(6,"B"));
        treeSetForOrder.add(new Order(7,"Bbb"));//uses compareTO to check for duplicate records
        System.out.print("TreeSet<Order> -->");
        for(Order inputOrder :treeSetForOrder){
            System.out.print(" "+inputOrder);
        }
        System.out.println();
    }
}

class Order {//implements Comparable<Order>  {
    Integer orderNumber = 0;
    String name;

    public Order(Integer orderNumber, String name) {
        this.orderNumber = orderNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + "orderNumber=" + orderNumber + ", name='" + name + '\'' + '}';
    }

    //@Override
    public int compareTo(Order o) {
        //for ascending order
        if (this.orderNumber < o.orderNumber) return -1;
        if (this.orderNumber > o.orderNumber) return 1;
        return 0;
        /* For descending order
        if(this.orderNumber < o.orderNumber)return 1;
        if(this.orderNumber > o.orderNumber)return -1;
        return 0;*/
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(name, order.name);
    }
    /*
     public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
     */

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, name);
    }
    /*
        public static int hash(Object... values) {
          return Arrays.hashCode(values);
        }

        public static int hashCode(Object a[]) {
        if (a == null)
            return 0;

        int result = 1;

        for (Object element : a)
            result = 31 * result + (element == null ? 0 : element.hashCode());

        return result;
       }

     */
}
class OrderComparator implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        return o1.orderNumber.compareTo(o2.orderNumber);
    }
}