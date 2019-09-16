package com.java.concept;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TestHashSet {

    public static void main(String[] args) {
        testTreeSet();
        testLinkedHashSet();
    }

    public static void testLinkedHashSet(){
        Set<Order> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(new Order(4,"D"));
        linkedHashSet.add(new Order(1,"A"));
        linkedHashSet.add(new Order(2,"B"));
        linkedHashSet.add(new Order(3,"C"));
        linkedHashSet.add(new Order(3,"C"));//TO avoid duplicates overrride equals and hashcode
        System.out.print("LinkedHashSet -->");
        for(Order input : linkedHashSet){
            System.out.print(input);
        }
        System.out.println();
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
        //java.lang.ClassCastException: com.java.concept.Order cannot be cast to java.lang.Comparable
        treeSetForOrder.add(new Order(4,"D"));
        treeSetForOrder.add(new Order(1,"A"));
        treeSetForOrder.add(new Order(3,"C"));
        treeSetForOrder.add(new Order(2,"B"));
        treeSetForOrder.add(new Order(2,"B"));//uses compareTO to check for duplicate records
        treeSetForOrder.add(new Order(6,"B"));
        System.out.print("TreeSet<Order> -->");
        for(Order inputOrder :treeSetForOrder){
            System.out.print(" "+inputOrder);
        }
        System.out.println();
    }
}
class Order implements Comparable<Order>{
    int orderNumber=0;
    String name;
    public Order(int orderNumber, String name) {
        this.orderNumber = orderNumber;
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" + "orderNumber=" + orderNumber + ", name='" + name + '\'' + '}';
    }

    @Override
    public int compareTo(Order o) {
        //for ascending order
        if(this.orderNumber < o.orderNumber)return -1;
        if(this.orderNumber > o.orderNumber)return 1;
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
        return orderNumber == order.orderNumber &&
                Objects.equals(name, order.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, name);
    }
}