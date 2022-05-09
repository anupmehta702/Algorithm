package com.algorithm.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BoundaryLevelTraversal {

    /*
    Input -->
               1
           2       3

        4     5 6     7

          16       8

                        9

    Output -->
    Printing elements level wise -->
        TreeNode{val=1}
        TreeNode{val=2}TreeNode{val=3}
        TreeNode{val=4}TreeNode{val=5}TreeNode{val=6}TreeNode{val=7}
        TreeNode{val=16}TreeNode{val=8}TreeNode{val=9}

        Printing list with null entries -->
         TreeNode{val=1} null TreeNode{val=2} TreeNode{val=3} null TreeNode{val=4} TreeNode{val=5} TreeNode{val=6} TreeNode{val=7} null TreeNode{val=16} TreeNode{val=8} TreeNode{val=9} null

        Printing only boundaries -->
         TreeNode{val=1} TreeNode{val=2} TreeNode{val=3} TreeNode{val=4} TreeNode{val=7} TreeNode{val=16} TreeNode{val=9}

     */
    public static void main(String[] args) {
        TreeNode root = createInputTree();
        boundaryTraversal(root);
    }


    public static void boundaryTraversal(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<TreeNode> list = new ArrayList<>();
        queue.add(root);
        list.add(root);
        int size = 0;
        int depth = 0;
        System.out.print("Printing elements level wise --> ");
        while (!queue.isEmpty()) {
            size = queue.size();
            list.add(null);
            System.out.println();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                System.out.print(curr);
                if (curr.left != null) {
                    queue.add(curr.left);
                    list.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    list.add(curr.right);
                }
            }
            depth++;

        }
        System.out.println();
        System.out.println();
        System.out.println("Printing list with null entries -->");
        list.forEach((node) -> System.out.print(" " + node));
        System.out.println();

        printBoundary(list);
    }

    static void printBoundary(List<TreeNode> levelOrderList) {
        System.out.println();
        System.out.println("Printing only boundaries -->");
        for (int i = 0; i < levelOrderList.size(); i++){
            if(levelOrderList.get(i) == null && i+1 != levelOrderList.size() ){
                System.out.print(" "+ levelOrderList.get(i-1)+ " "+ levelOrderList.get(i+1));
            }
        }
        System.out.print(" "+ levelOrderList.get(levelOrderList.size()-2));// to print last element

    }


    private static TreeNode createInputTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.left.right = new TreeNode(16);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.right.left.right = new TreeNode(8);

        root.right.right.right = new TreeNode(9);
        return root;
    }
}
