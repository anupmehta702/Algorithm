package com.algorithm.string;

public class Segregate0And1 {
    public static void main(String[] args) {
        segregate0And1(new int[]{1, 0, 1, 0, 0, 0, 0});
        segregate0And1(new int[]{1, 0, 1, 0, 1, 0, 1});
        segregate0And1(new int[]{0, 0, 0, 0, 0});
        segregate0And1(new int[]{1, 1, 1, 0, 0});
    }

    public static void segregate0And1(int[] input) {
        int start = 0;
        int end = input.length - 1;
        while (start < end) {
            if (input[start] == 1 && input[end] == 0) {
                int temp = input[start];
                input[start] = input[end];
                input[end] = temp;
            }
            if (input[start] == 0) {
                start++;
            }
            if (input[end] == 1) {
                end--;
            }
        }
        for (int i : input) {
            System.out.print(" " + i + " ");
        }
        System.out.println();
    }
}
/*Start two pointers ,start and end
swap the data pointed by two pointers if start finds 1 and end finds 0
increment start if data is 0 and decrement end if data is 1
Output
 0  0  0  0  0  1  1
 0  0  0  1  1  1  1
 0  0  0  0  0
 0  0  1  1  1
 */
