package com.algorithm.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//6938804428
public class VerticalTraversal {

    /*
               1
           2       3
        4     5 6     7
          16       8
                        9

      Ans -
      -2 4
      -1 2 16
       0 1 5 6
       1 3 8
       2 7
       3 9
     */
    public static void main(String[] args) {
        TreeNode root = createInputTree();
        Map<Integer, List<TreeNode>> sortedMap = new TreeMap<>();
        verticalTraversal(root, 0, sortedMap);
        sortedMap.entrySet().forEach((entry) -> System.out.println("Key - " + entry.getKey() + " Value - " + entry.getValue()));
    }


    private static void verticalTraversal(TreeNode root, int yAxis, Map<Integer, List<TreeNode>> sortedMap) {
        if (root == null) return;
        updateSortedMap(root, yAxis, sortedMap);
        verticalTraversal(root.left, yAxis - 1, sortedMap);
        verticalTraversal(root.right, yAxis + 1, sortedMap);
    }

    private static void updateSortedMap(TreeNode node, int yAxis, Map<Integer, List<TreeNode>> sortedMap) {
        if (sortedMap.containsKey(yAxis)) {
            List<TreeNode> exisitingNodes = sortedMap.get(yAxis);
            exisitingNodes.add(node);
        } else {
            List<TreeNode> list = new LinkedList<>();
            list.add(node);
            sortedMap.put(yAxis, list);
        }
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

