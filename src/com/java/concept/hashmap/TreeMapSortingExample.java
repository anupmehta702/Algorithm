package com.java.concept.hashmap;

import java.util.*;
import java.util.stream.Collectors;

public class TreeMapSortingExample {

    public static void main(String[] args) {
        int[][] i = new int[1][3];
        System.out.println("length -->"+i.length);
        Map<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("D",2);
        treeMap.put("B",2);
        treeMap.put("A",4);
        treeMap.put("C",9);
        Set<Map.Entry<String,Integer>> entrySet=treeMap.entrySet();
        System.out.println("Sorted order by key -->");
        entrySet.stream().forEach((e)-> System.out.println(e.getKey()+"-"+e.getValue()));
        System.out.println("Sorted order by value --> ");
        List<Map.Entry<String, Integer>> list=entrySet.stream()
                .sorted( Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toList());
        for(Map.Entry<String,Integer> entry : list){
            System.out.println(entry);
        }

    }
}
/*Output
Sorted order by key -->
A-4
B-2
C-9
D-2
Sorted order by value -->
C=9
A=4
B=2
D=2
 */