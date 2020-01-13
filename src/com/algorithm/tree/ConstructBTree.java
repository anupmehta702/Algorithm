package com.algorithm.tree;

import java.util.LinkedList;

public class ConstructBTree {
    private BNode root;

    public BNode insertNode(BNode current, int data) {
        if (root == null) {
            root = new BNode(data);
            return root;
        }
        if (current == null) {
            return new BNode(data);
        }
        if (current.data > data) {
            current.left = insertNode(current.left, data);
        } else if (current.data < data) {
            current.right = insertNode(current.right, data);
        } else {
            return current;
        }
        return current;
    }

    public void printLevelOrderTree(BNode root) {
        LinkedList<BNode> list = new LinkedList<>();
        list.add(root);
        System.out.println("Level order traversal --");
        while (!list.isEmpty()) {
            BNode element = list.remove();
            System.out.print(" " + element.data);
            if (element.left != null) list.add(element.left);
            if (element.right != null) list.add(element.right);
        }

    }

    public void preOrder(BNode root) {
        if (root == null) {
            return;
        }
        System.out.print(" " + root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(BNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(" " + root.data + " ");
        inOrder(root.right);

    }

    public void postOrder(BNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.data + " ");
    }

    public int search(int inOrder[], int data) {
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == data) {
                return i;
            }
        }
        return -1;
    }

    static int preIndex = 0;

    public BNode buildBT(int inOrder[], int preOrder[], int inStart, int inEnd) {
        BNode newNode = new BNode(preOrder[preIndex]);
        preIndex++;
        if (inStart > inEnd) {
            return null;
        }
        if (inStart == inEnd) {
            return newNode;
        }
        int inIndex = search(inOrder, newNode.data);
        newNode.left = buildBT(inOrder, preOrder, inStart, inIndex - 1);
        newNode.right = buildBT(inOrder, preOrder, inIndex + 1, inEnd);
        return newNode;
    }

    public static void main(String[] args) {
        ConstructBTree btree = new ConstructBTree();
        btree.insertNode(btree.root, 6);
        btree.insertNode(btree.root, 8);
        btree.insertNode(btree.root, 4);
        btree.insertNode(btree.root, 3);
        btree.insertNode(btree.root, 5);
        btree.insertNode(btree.root, 9);
        btree.insertNode(btree.root, 7);
        btree.printLevelOrderTree(btree.root);
        System.out.println();
        System.out.println("preOrder --> ");
        btree.preOrder(btree.root);
        System.out.println();
        System.out.println("InOrder --> ");
        btree.inOrder(btree.root);
        System.out.println();
        System.out.println("postOrder --> ");
        btree.postOrder(btree.root);

        System.out.println();
        System.out.println("Building binary tree from inorder and preorder -->");
        BNode binaryTree = btree.buildBT(new int[]{3,4,5,6,7,8,9},new int[]{6,4,3,5,8,7,9},0,6);
        btree.printLevelOrderTree(binaryTree);
    }
}

class BNode {
    BNode left;
    BNode right;
    int data;

    public BNode(int data) {
        this.data = data;
    }
}
