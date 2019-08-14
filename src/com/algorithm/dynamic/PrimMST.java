package com.algorithm.dynamic;


import java.util.*;

import com.algorithm.heap.BinaryMinHeap;

public class PrimMST {
	public Graph inputGraph;
	public BinaryMinHeap<Integer> heap=new BinaryMinHeap<>();
	public Map<Integer, String> vertexToEdge=new HashMap<Integer,String>();
	
	public PrimMST(int vertices){
		inputGraph=new Graph(vertices);
		setData();
	}
	
	public void setData(){
		inputGraph.addEdge(0, 1, 2);
		inputGraph.addEdge(0, 3, 6);
		inputGraph.addEdge(1, 3, 8);
		inputGraph.addEdge(1, 4, 5);
		inputGraph.addEdge(3, 4, 9);
		inputGraph.addEdge(1, 2, 3);
		inputGraph.addEdge(2, 4, 7);
	}

	public void initializeHeap(){
		for(int i=0;i<inputGraph.graphLength;i++){
			heap.add(Integer.MAX_VALUE, i);
		}
	}
	public void mst(){
		int totalWeight=0;
		
		initializeHeap();
		heap.decrease(0, 0);
		while(!heap.empty()){
			int current=heap.extractMin();
			List<Integer> adjacentVertices=inputGraph.getAdjacentVerticesOf(current);
			//System.out.println("adjacent vertices ("+current+")--> "+adjacentVertices);
			for(int i=0;i<adjacentVertices.size();i++){
				int adjacent = adjacentVertices.get(i);
				int weight=inputGraph.graph[current][adjacent];
				if(heap.containsData(adjacent) && heap.getWeight(adjacent)> weight){
					totalWeight=totalWeight+weight;
					heap.decrease(adjacent, weight);
					System.out.println("adding current-->"+current+" edge-->"+current+" "+adjacent);
					vertexToEdge.put(adjacent, current+" "+adjacent);
				}
			}
			
		}
		printMap();
	}
	
	public void printMap(){
		Iterator<String> iterator=vertexToEdge.values().iterator();
		while(iterator.hasNext()){
			System.out.println(""+iterator.next());
		}
	}
	public void printResult(List<?> result){
		System.out.println("result-->"+result);
	}
    /**
     * @param args
     */
    public static void main(String[] args) {
		PrimMST prim=new PrimMST(5);
		prim.inputGraph.displayGraph();
		prim.mst();
		prim.heap.printHeap();
		
	}
}	

