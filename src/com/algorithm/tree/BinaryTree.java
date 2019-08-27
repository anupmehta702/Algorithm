package com.algorithm.tree;

import java.util.List;

public class BinaryTree {
    Node root=null;

    public void insertData(List<Integer> dataList){
        for(int data : dataList){
            insertNode(data);
        }
    }

    public Node insertNode(int data){
        if(root == null){
            return new Node(data,null,null);
        }

        return null;
    }

}
class Node {
    int data;
    Node right;
    Node left;

    public Node(int data, Node right, Node left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }
}
