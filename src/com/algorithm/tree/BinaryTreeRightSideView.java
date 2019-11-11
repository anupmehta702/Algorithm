package com.algorithm.tree;

import java.util.*;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList();
        LinkedList<TreeNode> t = new LinkedList();
        if (root == null) {
            return output;
        }
        t.add(root);
        output.add(root.val);

        while (!t.isEmpty()) {
            int size = t.size();
            int outputVal = 0;
            //this for loop is required to group elements of one level
            //and choose the most correct right element
            for (int i = 0; i < size; i++) {
                TreeNode parent = t.remove();
                if (parent.left != null) {
                    t.add(parent.left);
                    outputVal = parent.left.val;
                }
                if (parent.right != null) {
                    t.add(parent.right);
                    outputVal = parent.right.val;
                }
            }
            if (outputVal != 0)
                output.add(outputVal);
        }
        return output;
    }

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.offer(root);
        TreeNode prev, cur;
        int size = 0;

        while (!dq.isEmpty()) {
            size = dq.size();
            prev = null;
            for (int i = 0; i < size; ++i) {
                cur = dq.poll();
                if (cur.left != null) dq.offer(cur.left);
                if (cur.right != null) dq.offer(cur.right);
                prev = cur;
            }
            r.add(prev.val);
        }
        return r;
    }
}

/*
 Algo -
 Use BFS ,however for every level keep overriding the value of output by first writing the
 left value then right value
 i.e override with the latest right value
 example - BFS - 1 23 4567 ,from level 3 (i.e. 4567 choose the rightest value i.e. 7)
 Output
     1
   /   \
  2     3
   \
    5
    Answer - 1,3,5
     1
   /   \
  2     3
   \     \
    5     6
    Answer - 1,3,6

    1
   /
  2
  Answer - 1,2

 */