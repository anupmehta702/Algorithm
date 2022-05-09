package com.algorithm.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NonRecursiveTopologicalSorting {

    private List<Integer> adj[];
    private int size;
    private boolean visited[];
    Stack<Integer> stack = new Stack<>();


    NonRecursiveTopologicalSorting(int size) {
        this.size = size;
        adj = new LinkedList[size];
        visited = new boolean[size];
        for (int i = 0; i < size; i++) {
            adj[i] = new LinkedList<>();
            visited[i] = false;
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public static void main(String[] args) {
        NonRecursiveTopologicalSorting tsort = new NonRecursiveTopologicalSorting(6);
        tsort.addEdge(0, 4);
        tsort.addEdge(0, 5);
        tsort.addEdge(1, 3);
        tsort.addEdge(1, 4);
        tsort.addEdge(2, 5);
        tsort.addEdge(3, 2);
        tsort.topologicalSort();
    }


    void topologicalSort() {
        for (int i = 0; i < size; i++) {
            if (!visited[i]) {
                //mark visited and push in stack
                visited[i] = true;
                stack.push(i);

                //push adjacent vertex in stack
                List<Integer> adjacentVertexList = adj[i];
                for (Integer adjVertex : adjacentVertexList) {
                    if (!visited[adjVertex]) {
                        stack.push(adjVertex);
                    }
                }

                //check stack, if entry in stack has all adjacent visited, if true pop and print,else break
                while (!stack.isEmpty()) {
                    Integer stackPeek = stack.peek();
                    boolean hasAllAdjacentVisited = true;
                    List<Integer> adjacentVerticesForStackPeek = adj[stackPeek];
                    for (Integer adjVertexPeek : adjacentVerticesForStackPeek) {
                        if (!visited[adjVertexPeek]) {
                            hasAllAdjacentVisited = false;
                            break;
                        }
                    }
                    if (hasAllAdjacentVisited) {
                        Integer poppedItem = stack.pop();
                        System.out.println(" Output -->" + poppedItem);
                        visited[poppedItem] = true;
                    }else{
                        break;
                    }

                }
            }
        }

    }
}
/*
Output
Output -->5
 Output -->4
 Output -->0
 Output -->2
 Output -->3
 Output -->1
 */