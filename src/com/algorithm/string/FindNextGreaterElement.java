package com.algorithm.string;


/*

 */
public class FindNextGreaterElement {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        printOutput(solution2.nextGreaterElements(new int[]{2, -1, 2})); //output -1,2,-1
        printOutput(solution2.nextGreaterElements(new int[]{1, 2, 1})); //output 2,-1,2
        printOutput(solution2.nextGreaterElements(new int[]{4,5,3})); //output 5,-1,4
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
            /*for (int i = j + 1; i != j && i < nums.length; i++) {
                if (nums[i] > nums[j]) {
                    output[j] = nums[i];
                    break;
                }
                if (i > nums.length - 1) {
                    //i = i%(nums.length-1);
                    i = -1;
                }
            }*/
        }
        return output;
    }
}
