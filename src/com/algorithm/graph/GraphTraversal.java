package com.algorithm.graph;

import java.util.*;

public class GraphTraversal {

    List<Integer> adj[];
    int size;
    boolean visited[];


    public GraphTraversal(int size) {
        this.size = size;
        adj = new LinkedList[size];
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            adj[i] = new LinkedList<>();
            visited[i] = false;
        }
    }

    void addNode(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public static void main(String[] args) {
        GraphTraversal dfs = new GraphTraversal(6);
        dfs.addNode(0, 1);
        dfs.addNode(1, 2);
        dfs.addNode(1, 3);
        dfs.addNode(3, 4);dfs.addNode(3, 5);
        dfs.printDFS(0);
        dfs.flush();
        dfs.printDFS(5);
        dfs.flush();
        dfs.printBFS(0);
        dfs.flush();
        dfs.printBFS(5);
    }

    private void flush() {
        for (int i = 0; i < size; i++) {
            visited[i] = false;
        }
    }

    void printDFS(int startVertex) {
        Stack<Integer> stack = new Stack();
        System.out.println("DFS for start vertex -->"+startVertex );
        stack.push(startVertex);
        visited[startVertex] = true;
        System.out.print(" --> "+startVertex);
        while(!stack.isEmpty()){
            Integer adjVertex = getUnvisitedAdjVertex(stack.peek());
            if(adjVertex == -1){
                stack.pop();
            }else{
                stack.push(adjVertex);
                visited[adjVertex] = true;
                System.out.print(" --> "+adjVertex);
            }
        }
        System.out.println();
    }

    void printBFS(int startVertex){
        Queue<Integer> queue = new ArrayDeque<>();
        System.out.println("BFS for start vertex -->"+startVertex );
        queue.add(startVertex);
        visited[startVertex] = true;
        System.out.print(" --> "+startVertex);
        while(!queue.isEmpty()){
            Integer current = queue.remove();
            List<Integer> adjVertices = getUnvisitedAdjVerticesFromQueue(current);
            for(Integer adjVertex : adjVertices){
                queue.add(adjVertex);
                visited[adjVertex] = true;
                System.out.print(" --> "+adjVertex);
            }
        }
        System.out.println();
    }

    private List<Integer> getUnvisitedAdjVerticesFromQueue(Integer current) {
        List<Integer> adjVertices = adj[current];
        List<Integer> adjUnvisitedVertices = new LinkedList<>();
        for(Integer vertex : adjVertices){
            if(!visited[vertex]){
                adjUnvisitedVertices.add(vertex);
            }
        }
        return adjUnvisitedVertices;
    }

    private Integer getUnvisitedAdjVertex(Integer peek) {
        List<Integer> adjVertices = adj[peek];
        for(Integer vertex : adjVertices){
            if(!visited[vertex]){
                return vertex;
            }
        }
        return -1;
    }
}
