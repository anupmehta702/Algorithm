package com.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;

public class Graph {
		int[][] graph;
		int graphLength;
		public Graph(int vertices){
			graph=new int[vertices][vertices];
			graphLength=vertices;
		}
		public void addEdge(int v1,int v2,int weight){
			graph[v1][v2]=weight;
			graph[v2][v1]=weight;
		}
		public int getWeight(int v1,int v2){
			return graph[v1][v2];
		}
		public List<Integer> getAdjacentVerticesOf(int vertex){
			List<Integer> adjacentVertices=new ArrayList<Integer>();
			for(int i=0;i<graph.length;i++){
				if(graph[vertex][i] > 0){
					adjacentVertices.add(i);
				}
			}
			return adjacentVertices;
		}
		public void displayGraph(){
			System.out.println("Graph -->");
			for(int i=0;i<graph.length;i++){
				for(int j=0;j<graph.length;j++){
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}
		
}
