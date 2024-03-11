package com.java.concept.hashmap;

import java.util.ArrayList;
import java.util.List;

public class HashMapImplementation<K, V> {


    private Entry[] array;
    private int defaultSize = 5;

    HashMapImplementation() {
        array = new Entry[this.defaultSize];
    }

    HashMapImplementation(int size) {
        this.defaultSize = size;
        array = new Entry[this.defaultSize];
    }

    boolean put(K key, V value) {
        int hash = hashForKey(key);
        Entry firstNodeOfArray = array[hash];
        if (firstNodeOfArray == null) {
            System.out.println("First element getting added on array for hash --> " + hash);
            array[hash] = new Entry(key, value, null);
            return true;
        }
        Entry node = firstNodeOfArray;

        while (node.next != null) {
            if (node.key == key) {
                System.out.println("Entry already present.Cant add the same entry again");
                return false;
            }
            node = node.next;
        }
        Entry entryToAdd = new Entry(key, value, firstNodeOfArray);
        array[hash] = entryToAdd;
        return true;
    }

    public V get(K key) {
        int hashOfKey = hashForKey(key);
        Entry entryNode = array[hashOfKey];
        Entry nodeToTraverse = entryNode;
        if (entryNode == null) {
            System.out.println("No entry present on the array !");
            return null;
        } else {
            while (nodeToTraverse != null) {
                if (nodeToTraverse.key.hashCode() == key.hashCode()) {
                    return (V) nodeToTraverse.value;
                }
                nodeToTraverse = nodeToTraverse.next;
            }
        }
        System.out.println("Couldnt find the entry in the map !");
        return null;
    }

    private int hashForKey(K key) {
        int hash = key.hashCode() % defaultSize;
        System.out.println("hash of key - " + key + " is - " + hash);
        return hash;
    }

    public static void main(String[] args) {

        List<String>[] arrayOfList = new ArrayList[2];
        List<String> list1 = new ArrayList<>();
        list1.add("L1S1");
        list1.add("L1S2");
        List<String> list2 = new ArrayList<>();
        list2.add("L1S1");
        list2.add("L1S2");
        arrayOfList[0] = list1;
        arrayOfList[1] = list2;

        System.out.println("Print array of list -->" + arrayOfList[0]);

        HashMapImplementation<Integer, String> hMap = new HashMapImplementation();
        hMap.put(3, "Three");
        hMap.put(13, "Thirteen");
        hMap.put(23, "TwentyThree");
        hMap.put(4, "Four");
        hMap.put(3, "Three");
        hMap.put(2, "Two");
        hMap.put(1, "One");
        hMap.put(5, "Five");
        System.out.println("Value -->" + hMap.get(1));
        System.out.println("Value -->" + hMap.get(2));
        System.out.println("Value -->" + hMap.get(3));
        System.out.println("Value -->" + hMap.get(4));
        System.out.println("Value -->" + hMap.get(5));
        System.out.println("Value -->" + hMap.get(13));
        System.out.println("Value -->" + hMap.get(23));

        System.out.println("Value -->" + hMap.get(100));


        hMap.put(3, "Three");

    }

}

/*
[ x, y, z] --> segment
x --> [a,b,c ]


// 0 1 2 3 4 5 6 7 8 9
   -1 -2 3 4 5 6 7 -9 10
   -1 -2 -9 4 5 6 7 3 10

   first  = 0 <-- -1 --> +ve
0 +ve -ve
*/

// positive = 8th element
// negate = 2 th element

class Entry<K, V> {
    K key;
    V value;
    Entry next;


    Entry(K key, V value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
