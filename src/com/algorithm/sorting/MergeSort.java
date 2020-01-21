package com.algorithm.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0,arr.length-1 );
        print(arr);
    }

    public static void mergeSort(int[] input, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(input, l, m);
            mergeSort(input, m + 1, r);
            merge(input, l, m, r);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]
    public static void merge(int[] arr, int l, int m, int r) {
        //step 1 find out the size of two sub arrays
        int n1 = m - l + 1;
        int n2 = r - m ; //r-m bcoz two subaraays would be l..m and m+1 ..r

        int[] L = new int[n1];
        int[] R = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l; //cant use k=0 bcoz it runs for l=4,m=5,r=6
                   // i.e. L =9,82 R=10
                   // merged array would be 9 ,10 ,82 at position 4,5,6

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
    public static void print(int[] arr){
        for(int i : arr){
            System.out.print(" "+i+" ");
        }
        System.out.println();
    }
}
