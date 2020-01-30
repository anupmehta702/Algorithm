package com.java.concept.setAndList;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TestHashSet {

    public static void main(String[] args) {
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



}

/*Output
TreeSet --> 1 5 10 20
Tree set using stream --> 1 5 10 20
TreeSet<Order> --> {orderNumber=1, name='A'} {orderNumber=2, name='B'} {orderNumber=3, name='C'} {orderNumber=4, name='D'} {orderNumber=6, name='B'}
LinkedHashSet -->{orderNumber=4, name='D'}{orderNumber=1, name='A'}{orderNumber=2, name='B'}{orderNumber=3, name='C'}

 */