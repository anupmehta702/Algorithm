package com.algorithm.string;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        //Answer should be 5 3 1 2 2 1
        Solution solution = new Solution();
        System.out.println("min length-->" + solution.minSubArrayLenUsingSplitWindow(15, new int[]{1, 2, 3, 4, 5}));
        solution = new Solution();
        System.out.println("min length-->" + solution.minSubArrayLenUsingSplitWindow(11, new int[]{1, 2, 3, 4, 5}));
        solution = new Solution();
        System.out.println("min length-->" + solution.minSubArrayLenUsingSplitWindow(7, new int[]{2, 3, 1, 2, 4, 3, 7}));
        solution = new Solution();
        System.out.println("min length-->" + solution.minSubArrayLenUsingSplitWindow(7, new int[]{2, 3, 1, 2, 4, 3}));
        solution = new Solution();
        System.out.println("min length-->" + solution.minSubArrayLenUsingSplitWindow(7, new int[]{2, 3, 1, 2, 4, 3}));
        solution = new Solution();
        System.out.println("min length-->" + solution.minSubArrayLenUsingSplitWindow(6, new int[]{10, 2, 3}));
    }
}

class Solution {
    int startIndex = 0;
    int endIndex = 0;
    int lengthOfSubArray = Integer.MAX_VALUE;

    public int minSubArrayLenUsingSplitWindow(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 1, j = 0;
        int sum = nums[0];

        while (i < nums.length) {
            if (nums[i] >= s || nums[j] >= s) calculateLengthOfSubArray(i, i);
            sum = sum + nums[i];
            if (sum < s) i++;
            else if (sum >= s) {
                calculateLengthOfSubArray(j, i);
                while (j != i) {
                    j++;
                    sum = sum - nums[j - 1];
                    if (sum >= s) calculateLengthOfSubArray(j, i);
                    else {
                        break;
                    }
                }
                i++;
            }
        }
        return lengthOfSubArray == Integer.MAX_VALUE ? 0 : lengthOfSubArray;

    }

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 1, j = 0;
        int sum = nums[0];
        while (j <= nums.length - 2 && i < nums.length) {
            sum = nums[i] + sum;
            if (nums[j] == s) {
                calculateLengthOfSubArray(j, j);
            }
            if (sum < s) i++;
            else if (sum >= s || i == nums.length) {
                if (sum == s) calculateLengthOfSubArray(j, i);
                j++;
                i = j + 1;
                sum = nums[j];
            }
        }
        if (nums[nums.length - 1] == s) calculateLengthOfSubArray(nums.length - 1, nums.length - 1);

        return lengthOfSubArray == Integer.MAX_VALUE ? 0 : lengthOfSubArray;
    }

    public void calculateLengthOfSubArray(int j, int i) {
        if (i == j) lengthOfSubArray = 1;
        else if ((i - j) + 1 < lengthOfSubArray) {
            lengthOfSubArray = (i - j) + 1;
            startIndex = j;
            endIndex = i;
            // System.out.println(" start index --> " + startIndex + " end index -->" + endIndex);
        }

    }
}
/*
Output
input --> (15,new int[]{1,2,3,4,5}));, output -> min length-->5
input --> (11,new int[]{1,2,3,4,5}));, output -> min length-->3
input --> (7,new int[]{2,3,1,2,4,3,7})); , output -> min length-->1
input --> (7,new int[]{2,3,1,2,4,3}));, output -> min length-->2
input --> (7, new int[]{2, 3, 1, 2, 4, 3}));, output -> min length-->2
input --> (6, new int[]{10,2,3})); , output -> min length-->1
*/

