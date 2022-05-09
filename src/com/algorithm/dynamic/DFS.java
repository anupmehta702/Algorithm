package com.algorithm.dynamic;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {

	private List<Vertex> vertices= new ArrayList<Vertex>();
	private int adjMatrix[][] =new int[4][4];
	private Stack<Integer> theStack= new Stack<Integer>();
	
	public void addEdge(int start,int end){
		adjMatrix[start][end]=1;
		adjMatrix[end][start]=1;
	}
	public void addVertices(char ch){
		vertices.add(new Vertex(ch));
	}
	public void DFSWithoutRecursion(){
		visitTheVertex(0);
		while(!theStack.isEmpty()){
			int unvisitedVertex=getUnvisitedVertexOf(theStack.peek());
			if(unvisitedVertex==-1)
				theStack.pop();
			else{
				visitTheVertex(unvisitedVertex);
			}
		}
	}
	
	public void visitTheVertex(int vertex){
		vertices.get(vertex).visited=true;
		displayVertex(vertex);
		theStack.push(vertex);
	}
	public int getUnvisitedVertexOf(int vertex){
		for(int j=0;j<vertices.size();j++){
			if(adjMatrix[vertex][j]==1 && vertices.get(j).visited==false)
				return j;
		}
		return -1;
	}
	public void displayVertex(int v){
		System.out.println(vertices.get(v).ch);
	}
	public void displayGraph(){
		System.out.println("Graph -->");
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				System.out.print(adjMatrix[i][j]);
			}
			System.out.println();
		}
	}
	public void setData(){
		addVertices('A');addVertices('B');addVertices('C');addVertices('D');
		addEdge(0,1);addEdge(0,2);addEdge(1,3);
	}
	
	public static void main(String[] args) {
		DFS dfs=new DFS();
		System.out.println("-->"+dfs.adjMatrix.length);
		dfs.setData();
		dfs.displayGraph();
		dfs.DFSWithoutRecursion();
	}
	
	
}
 class Vertex{
	public boolean visited=false;
	public char ch;
	Vertex(char ch){
		this.ch=ch;
	}
	
}

/*Output
-->4
Graph(input) -->
0110
1001
1000
0100
A -> B -> D
A-> C
output
A
B
D
C
 */