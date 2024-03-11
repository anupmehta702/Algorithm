package com.algorithm.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        DirectedGraph g = new DirectedGraph(5);
        g.addEdge(0, 1);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(4, 2);
        g.addEdge(3, 4);
        System.out.println("Is cyclic -->" + g.isCyclic());
    }
}

class DirectedGraph {
    int totalVertices;
    LinkedList<Integer> adj[];

    DirectedGraph(int totalVertices) {
        adj = new LinkedList[totalVertices];
        this.totalVertices = totalVertices;
        for (int i = 0; i < totalVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    Boolean isCyclic() {
        Boolean visited[] = new Boolean[totalVertices];
        Boolean recurStack[] = new Boolean[totalVertices];
        Arrays.fill(visited, false);
        Arrays.fill(recurStack, false);

        for (int u = 0; u < totalVertices; u++) {
            if (!visited[u]) {
                if (isCyclicUtil(u, visited, recurStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private Boolean isCyclicUtil(int i, Boolean[] visited, Boolean[] recurStack) {

        /*if (visited[i] && recurStack[i]) {
            return true;
        }
        if (visited[i]) {
            return false;
        }*/
        visited[i] = true;
        recurStack[i] = true;

        List<Integer> list = adj[i];
        for (Integer vertex : list) {
            /*if (isCyclicUtil(vertex, visited, recurStack)) {
                return true;
            }*/
            System.out.println("Called for vertex -->" + vertex + " from -->"+i);
            if (!visited[vertex]) {
                if (isCyclicUtil(vertex, visited, recurStack)) {
                    return true;
                }
            } else if (recurStack[vertex]) {
                System.out.println("Cycle detected at vertex -->"+vertex);
                return true;
            }
        }

        recurStack[i] = false;
        return false;
    }

}
