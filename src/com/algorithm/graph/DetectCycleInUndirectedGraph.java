package com.algorithm.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(0, 4);
        System.out.println("Is cyclic -->" + g.isCyclic());
    }
}

class Graph {
    int totalVertices;
    LinkedList<Integer> adj[];

    Graph(int totalVertices) {
        adj = new LinkedList[totalVertices];
        this.totalVertices = totalVertices;
        for (int i = 0; i < totalVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    Boolean isCyclic() {
        Boolean visited[] = new Boolean[totalVertices];
        Arrays.fill(visited, false);
        for (int u = 0; u < totalVertices; u++) {
            return isCyclicUtil(u, visited, -1);
        }
        return false;
    }

    private Boolean isCyclicUtil(int v, Boolean[] visited, int parent) {
        visited[v] = true;
        Iterator<Integer> ll = adj[v].iterator();
        while (ll.hasNext()) {
            Integer i = ll.next();
            System.out.println("Visiting vertex --> " + v + " , parent --> " + parent);
            if (!visited[i]) {
                return isCyclicUtil(i, visited, v);
            } else {
                if (i != parent) {
                    return true;
                }
            }
        }
        /*ll.stream().map((i) -> {
            System.out.println("Visiting vertex --> "+v+" , parent --> "+parent);
            if (!visited[i]) {
                return isCyclicUtil(i, visited, v);
            } else {
                if(i != parent){
                    return true;
                }
                return false;
            }
        });*/
        return false;
    }

}
