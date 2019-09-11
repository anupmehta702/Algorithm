package com.algorithm.heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date 04/06/2013
 * @author Tushar Roy
 *
 * Data structure to support following operations
 * extracMin - O(logn)
 * addToHeap - O(logn)
 * containsKey - O(1)
 * decreaseKey - O(logn)
 * getKeyWeight - O(1)
 *
 * It is a combination of binary heap and hash map
 *
 */
public class BinaryMinHeap<T> {

    private List<Node> allNodesList = new ArrayList<>();
    private Map<T,Integer> nodePositionMap = new HashMap<>();
        
    public class Node {
       public int weight;
        public T key;
    }

    /**
     * Checks where the key exists in heap or not
     */
    public boolean containsData(T key){
        return nodePositionMap.containsKey(key);
    }

    /**
     * Add key and its weight to they heap
     */
    public void add(int weight,T key) {
        Node node = new Node();
        node.weight = weight;
        node.key = key;
        allNodesList.add(node);
        int size = allNodesList.size();
        int current = size - 1;
        int parentIndex = (current - 1) / 2;
        nodePositionMap.put(node.key, current);

        while (parentIndex >= 0) {
            Node parentNode = allNodesList.get(parentIndex);
            Node currentNode = allNodesList.get(current);
            if (parentNode.weight > currentNode.weight) {
                swap(parentNode,currentNode);
                updatePositionMap(parentNode.key,currentNode.key,parentIndex,current);
                current = parentIndex;
                parentIndex = (parentIndex - 1) / 2;
            } else {
                break;
            }
        }
    }

    /**
     * Get the heap min without extracting the key
     */
    public T min(){
        return allNodesList.get(0).key;
    }

    /**
     * Checks with heap is empty or not
     */
    public boolean empty(){
        return allNodesList.size() == 0;
    }

    /**
     * Decreases the weight of given key to newWeight
     */
    public void decrease(T data, int newWeight){
        Integer position = nodePositionMap.get(data);
        allNodesList.get(position).weight = newWeight;
        int parent = (position -1 )/2;
        while(parent >= 0){
            if(allNodesList.get(parent).weight > allNodesList.get(position).weight){
                swap(allNodesList.get(parent), allNodesList.get(position));
                updatePositionMap(allNodesList.get(parent).key, allNodesList.get(position).key,parent,position);
                position = parent;
                parent = (parent-1)/2;
            }else{
                break;
            }
        }
    }

    /**
     * Get the weight of given key
     */
    public Integer getWeight(T key) {
        Integer position = nodePositionMap.get(key);
        if( position == null ) {
            return null;
        } else {
            return allNodesList.get(position).weight;
        }
    }

    /**
     * Returns the min node of the heap
     */
    public Node extractMinNode() {
        int size = allNodesList.size() -1;
        Node minNode = new Node();
        Node lastNode = allNodesList.get(size);

        allNodesList.get(0).weight = lastNode.weight;
        allNodesList.get(0).key = lastNode.key;
        nodePositionMap.remove(minNode.key);
        nodePositionMap.remove(allNodesList.get(0));
        nodePositionMap.put(allNodesList.get(0).key, 0);
        allNodesList.remove(size);

        int currentIndex = 0;
        size--;
        while(true){
            int left = 2*currentIndex + 1;
            int right = 2*currentIndex + 2;
            if(left > size){
                break;
            }
            if(right > size){
                right = left;
            }
            int smallerIndex = allNodesList.get(left).weight <= allNodesList.get(right).weight ? left : right;
            if(allNodesList.get(currentIndex).weight > allNodesList.get(smallerIndex).weight){
                swap(allNodesList.get(currentIndex), allNodesList.get(smallerIndex));
                updatePositionMap(allNodesList.get(currentIndex).key, allNodesList.get(smallerIndex).key,currentIndex,smallerIndex);
                currentIndex = smallerIndex;
            }else{
                break;
            }
        }
        return minNode;
    }
    /**
     * Extract min value key from the heap
     */
    public T extractMin(){
        Node node = extractMinNode();
        return node.key;
    }

    private void printPositionMap(){
        System.out.println(nodePositionMap);
    }

    private void swap(Node node1,Node node2){
        int weight = node1.weight;
        T data = node1.key;
        
        node1.key = node2.key;
        node1.weight = node2.weight;
        
        node2.key = data;
        node2.weight = weight;
    }

    private void updatePositionMap(T data1, T data2, int pos1, int pos2){
        nodePositionMap.remove(data1);
        nodePositionMap.remove(data2);
        nodePositionMap.put(data1, pos1);
        nodePositionMap.put(data2, pos2);
    }
    
    public void printHeap(){
        for(Node n : allNodesList){
            System.out.println(n.weight + " " + n.key);
        }
    }
    
    public static void main(String args[]){
        BinaryMinHeap<String> heap = new BinaryMinHeap<String>();
        heap.add(3, "Tushar");
        heap.add(4, "Ani");
        heap.add(8, "Vijay");
        heap.add(10, "Pramila");
        heap.add(5, "Roy");
        heap.add(6, "NTF");
        heap.add(2,"AFR");
        heap.printHeap();
        System.out.println("------");
        heap.decrease("Pramila", 1);
        heap.printHeap();
        heap.printPositionMap();
    }
}

/*Output

2 AFR
4 Ani
3 Tushar
10 Pramila
5 Roy
8 Vijay
6 NTF
------
1 Pramila
2 AFR
3 Tushar
4 Ani
5 Roy
8 Vijay
6 NTF

{NTF=6, Vijay=5, Pramila=0, Tushar=2, Roy=4, Ani=3, AFR=1}

 */