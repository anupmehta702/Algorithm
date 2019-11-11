package com.algorithm.StackQueue;

import java.util.Stack;

public class FindNextGreaterElement {

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        printOutput(solution2.nextGreaterElementsUsingStack(new int[]{2, -1, 2})); //output -1,2,-1
        printOutput(solution2.nextGreaterElementsUsingStack(new int[]{1, 2, 1})); //output 2,-1,2
        printOutput(solution2.nextGreaterElementsUsingStack(new int[]{4, 5, 3})); //output 5,-1,4
    }

    public static void printOutput(int[] output) {
        System.out.println("Output -->");
        for (Integer i : output) {
            System.out.print(" , " + i);
        }
        System.out.println();
    }
}

class Solution2 {
    public int[] nextGreaterElements(int[] nums) {
        int[] output = new int[nums.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = -1;
        }
        if (nums.length == 1) {
            return output;
        }
        int greatestNum = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            int i = j + 1;
            while (i != j) {
                if(i >= nums.length){
                    i = -1;
                }
                if (i >-1 && nums[i] > nums[j]) {
                    output[j] = nums[i];
                    break;
                }
              i++;
            }

        }
        return output;
    }
    /*Algo
    1) Start traversing array from right and scan the elements twice using i % nums.length
    2) For every element ,check
        if (stack has value lesser than the element) stack.pop();
    3) Store result in another array with below formula -
       if(stack.isEmpty()) -1
       else stack.peek();
    4) Add current element in stack.
     */
    public int[] nextGreaterElementsUsingStack(int[] nums) { //Runtime 45ms , memory 40.7MB
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
}
