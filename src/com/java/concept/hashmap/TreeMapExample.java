package com.java.concept.hashmap;

import java.util.*;

public class TreeMapExample {

    public static void main(String[] args) {
        Order o = new Order(1,"Dec",20191110);
        Order o0 = new Order(2,"Nov",20191110);
        Order o1 = new Order(3,"Oct",20191110);
        Order o2 = new Order(4,"Oct",20191010);
        Order o3 = new Order(5,"Sep",20190910);
        Order o4 = new Order(6,"Aug",20190810);
        Order o5 = new Order(7,"Jul",20190710);
        Order o6 = new Order(8,"Jun",20190610);
        Order o7 = new Order(9,"May",20190510);
        Order o8 = new Order(10,"Apr",20190410);
        Map<Integer,Order> tm = new TreeMap<>();
        tm.put(o.time,o);
        tm.put(o0.time,o0);
        tm.put(o1.time,o1);
        tm.put(o2.time,o2);
        tm.put(o3.time,o3);
        tm.put(o4.time,o4);
        tm.put(o5.time,o5);
        tm.put(o6.time,o6);
        tm.put(o7.time,o7);
        tm.put(o8.time,o8);
        /*Map<Order,String> tm = new TreeMap<>();

*/
        Set<Map.Entry<Integer,Order>> entryHashSet =  tm.entrySet();
        entryHashSet.stream().forEach((entry)-> System.out.println("Key -->"+entry.getKey()+" Value-->"+entry.getValue()));

        Map<Integer,Order> subMap = ((TreeMap<Integer,Order>) tm).subMap(20190610,20191110);
        System.out.println("Order between June and Oct -->"+subMap);
        /*Set<Map.Entry<Integer,Order>> subMapSet =  subMap.entrySet();
        subMapSet.stream().forEach((entry)-> System.out.println("Key -->"+entry.getKey()+" Value-->"+entry.getValue()));
*/

        //method returns the key + value stored for the least (smallest) key in the NavigableMap
        // which is higher than or equal to the parameter value passed to the ceilingEntry() method
        System.out.println("Ceiling Entry --> "+((TreeMap<Integer,Order>) tm).ceilingEntry(20190825)); //10thOct is next greater than 28thAug

        //The floorEntry() method works opposite of the ceilingEntry() method
        System.out.println("FloorEntry --> "+((TreeMap<Integer,Order>) tm).floorEntry(20190825));////10thAug is next smallest than 28thAug


    }
}
class Order implements Comparable<Order> {
    int id ;
    String name;
    int time ;

    public Order(int id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time=" + time +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        if(o == null) return 1;
        else{
            if(this.time == o.time) return 0;
            return this.time < o.time ? -1 :1;
        }
    }
}