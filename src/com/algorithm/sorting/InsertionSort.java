package com.algorithm.sorting;

public class InsertionSort {
    public static void main(String[] args) {
        insertionSort(new int[]{11,12,13,5,6});
    }
    public static void insertionSort(int[] input){
        for(int i = 1 ; i < input.length ; i++){
            int key = input[i];
            int j=i-1;
            while(j>=0 && key < input[j]){
                input[j+1]=input[j];
                /* for eg 11,12,13,5,6  j=3
                    o/p  11 12 13 13 6
                         11 12 12 13 6
                         11 12 12 13 6
                 */
                j--;
            }
            input[j+1]=key;
        }
        System.out.println("Final output -->");
        print(input);
    }
    public static void print(int[] input){
        for(int i : input){
            System.out.print(" "+i+" ");
        }
        System.out.println();
    }
}
