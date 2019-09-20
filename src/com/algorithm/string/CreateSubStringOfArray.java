package com.algorithm.string;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CreateSubStringOfArray {

    public static  Integer[] getSubArray(int[] input) {
        Integer[] convertedSubArray = new Integer[input.length * 2];
        int k = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (j == i + 1) {
                    convertedSubArray[k] =  input[i] + input[j];
                } else {
                    convertedSubArray[k] = convertedSubArray[k-1] + input[j];
                }
                k++;
            }
        }
        System.out.println("Sub array --> ");
        for(int i=0;i<convertedSubArray.length;i++){
            System.out.print(convertedSubArray[i]+" ");
        }
        System.out.println();
        return convertedSubArray;
    }

    public static void main(String[] args) {
        int[] input = {4,-1,2,3,5};
        Integer[] subArraySummation = getSubArray(input);
        Arrays.sort(subArraySummation);
        System.out.println("Sorted Sub array --> ");
        for(int i=0;i<subArraySummation.length;i++){
            System.out.print(subArraySummation[i]+" ");
        }
        System.out.println();

    }
}
/*
Input - 4 -1 2 3 5
Sub array -->
3 5 8 13 1 4 9 5 10 8
Sorted Sub array -->
1 3 4 5 5 8 8 9 10 13

 */
