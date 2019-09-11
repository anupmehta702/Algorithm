package com.algorithm.string;

import java.util.*;
import java.util.stream.Collectors;

public class KthMostRepeatingOccurrence {

    public static void main(String[] args) {
        //int[] inputArr = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5};
        int[] inputArr = {1,2,1,2,5,3,1,4,1,2,4};
        //int[] inputArr = null;
        System.out.println("The kth most occurred element is - " + findKthRepeatingOccurrenceUsingStreams(inputArr, 2));
        System.out.println("The kth most occurred element is - " + findKthRepeatingOccurrenceUsingList(inputArr, 2));
    }

    public static int findKthRepeatingOccurrenceUsingStreams(int[] inputArr, int k) {
        if (inputArr == null || inputArr.length == 0) {
            return -1;
        }
        Map<Integer, Integer> occurrenceMap = getOccurrenceMap(inputArr);
        Set<Map.Entry<Integer, Integer>> entrySet = occurrenceMap.entrySet();
        List<Map.Entry<Integer, Integer>> sortedOccurrenceList = entrySet.stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        return sortedOccurrenceList.get(sortedOccurrenceList.size() - k).getKey();
    }

    public static int findKthRepeatingOccurrenceUsingList(int[] inputArr, int k) {
        if (inputArr == null || inputArr.length == 0) {
            return -1;
        }
        Map<Integer, Integer> occurrenceMap = getOccurrenceMap(inputArr);
        Iterator itr = occurrenceMap.entrySet().iterator();
        List<Node> nodeList=new ArrayList<>();
        while (itr.hasNext()) {
            Map.Entry<Integer, Integer> entry = (Map.Entry<Integer, Integer>) itr.next();
            Node node = new Node(entry.getKey(), entry.getValue());
            nodeList.add(node);
        }
        System.out.println("Unsorted List-->"+nodeList);
        Collections.sort(nodeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.value>o2.value) return 0;
                return o1.value>o2.value ?1:-1;
            }
        });
        System.out.println("Sorted list -->"+nodeList);
        return nodeList.get(nodeList.size() - k).key;
    }

    private static Map<Integer, Integer> getOccurrenceMap(int[] inputArr) {
        Map<Integer, Integer> occurrenceMap = new HashMap<>();
        for (int input : inputArr) {
            if (occurrenceMap.containsKey(input)) {
                int count = occurrenceMap.get(input);
                occurrenceMap.put(input, ++count);
            } else {
                occurrenceMap.put(input, 1);
            }
        }
        return occurrenceMap;
    }

}

class Node {
    int key;
    int value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

