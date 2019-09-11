package com.algorithm.dynamic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.algorithm.heap.BinaryMinHeap;
import com.algorithm.heap.BinaryMinHeap.Node;

public class Dijkstra {

	public Map<Integer, Integer> path = new HashMap<>();
	public Map<Integer,Integer> distance=new HashMap<>();
	public BinaryMinHeap<Integer> heap=new BinaryMinHeap<>();
	public Graph graph;
	
	public Dijkstra(int vertices){
		graph=new Graph(vertices);
		setData();
	}
	
	public void setData(){
		graph.addEdge(0, 1, 5);
		graph.addEdge(0, 3, 9);
		graph.addEdge(0, 4, 2);
		graph.addEdge(1, 2, 2);
		graph.addEdge(2, 3, 3);
		graph.addEdge(3, 5, 2);
		graph.addEdge(4, 5, 3);
	}
	
	public void printMap(Map<Integer, Integer> map){		
		Set<Entry<Integer, Integer>> hashSet=map.entrySet();
        for(Entry<Integer, Integer> entry:hashSet ) {

            System.out.println("Key="+entry.getKey()+", Value="+entry.getValue());
        }
	}
	
	public void findShortestDist(){
		for(int i=0;i<graph.graphLength;i++){
			heap.add(Integer.MAX_VALUE, i);
		}
			
		heap.decrease(0, 0);
		distance.put(0, 0);
		path.put(0, 0);
		
		while(!heap.empty()){
			@SuppressWarnings("rawtypes")
			Node currentNode=heap.extractMinNode();
			Integer current=(Integer)currentNode.key;
			System.out.println("Current Node-->"+current);
			
			distance.put((Integer)currentNode.key, currentNode.weight);
			
			List<Integer> adjacentVertices=graph.getAdjacentVerticesOf(current);
			for(int i=0;i<adjacentVertices.size();i++){
				int currentVertex=adjacentVertices.get(i);
				if(heap.containsData(currentVertex)){
					int newWeight =graph.getWeight(current, currentVertex);
					if(distance.containsKey(current)){
						newWeight =newWeight + distance.get(current);
					}
					if(newWeight < heap.getWeight(currentVertex)){
						heap.decrease(currentVertex, newWeight);
						path.put(currentVertex,newWeight);
					}
				}
			}
			
		}
		printMap(distance);
	}
	
	public static void main(String[] args) {
		Dijkstra dijkstra=new Dijkstra(6);
		dijkstra.graph.displayGraph();
		dijkstra.findShortestDist();
	}
}
/*Output
Graph -->
050920
502000
020300
903002
200003
000230
Current Node-->0
Current Node-->4
Current Node-->1
Current Node-->5
Current Node-->2
Current Node-->3
Key=0, Value=0
Key=1, Value=5
Key=2, Value=7
Key=3, Value=7
Key=4, Value=2
Key=5, Value=5

 */
