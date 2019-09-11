package com.algorithm.dynamic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {

	private LinkedList<Integer> adj[];
	private int V;
	
	TopologicalSorting(int v){
		V=v;
		adj=new LinkedList[V];
		for(int i=0;i<V;i++){
			adj[i]=new LinkedList<Integer>();
		}
	}
	public void addEdge(int v,int w){
		adj[v].add(w);
	}
	public static void main(String[] args) {
		TopologicalSorting s =new TopologicalSorting(6);
		s.addEdge(5,2);s.addEdge(5,0);s.addEdge(4,0);s.addEdge(4,1);
		s.addEdge(2,3);s.addEdge(3,1);
		s.topologicalSort();
		
	}
	
	public void topologicalSort(){
		Stack<Integer> stack =new Stack<Integer>();
		boolean visited[] =new boolean[V];
		for(int i=0;i<V;i++){
			visited[i]=false;
		}
		for(int i=0;i<V;i++){
			if(!visited[i]){
				topologicalsortutil(i,visited,stack);
			}
		}
		System.out.println("solution -->");
		while(stack.empty() == false){
			System.out.print(stack.pop()+" ");
		}
		
	}
	
	public void topologicalsortutil(int v,boolean[] visited,Stack<Integer> stack){
		visited[v]=true;
		Iterator<Integer> it = adj[v].iterator();
		while(it.hasNext()){
			Integer current=it.next();
			if(!visited[current]){
				topologicalsortutil(current,visited,stack);
			}
		}
		stack.push(new Integer(v));
	}
}
/*
Output
solution -->
5 4 2 3 1 0
 */