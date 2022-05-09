package com.algorithm.tree;

public class TreeNode {
    int val;
    com.algorithm.tree.TreeNode left;
    com.algorithm.tree.TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}


