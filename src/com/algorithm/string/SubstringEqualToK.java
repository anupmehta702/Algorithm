package com.algorithm.string;

public class SubstringEqualToK {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int sum = 7;
        int count = bruteForceSubstringSumEqualTo(sum,arr);

        System.out.println(String.format("Total substrings matching sum = %s is --> %s",sum,count));
    }

    public static int bruteForceSubstringSumEqualTo(int sum, int[] input) {
        int count = 0 ;
        for (int i = 0; i < input.length; i++) {
            int total = 0;
            for (int j = i; j < input.length; j++) {
                total = total + input[j];
                System.out.println("total of substring -->"+total);
                if(total == sum){
                    count++;
                }
            }
        }

        return count;
    }
}
