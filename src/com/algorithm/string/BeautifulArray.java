package com.algorithm.string;


/*A beautiful array is one which has got 'm' odd numbers in it
example - input 1,2,3,4,5 ,m=2
1,2,3
1,2,3,4
2,3,4,5
3,4,5 .Sum = 4

 */
public class BeautifulArray {
    public static void main(String[] args) {
        System.out.println("Sum -->" + beautifulArray(new int[]{1, 2, 3, 4, 5}, 2));//ans 3
        System.out.println("Sum -->" + beautifulArray(new int[]{2, 5, 4, 9}, 1));// ans 6
    }

    public static int beautifulArray(int[] arr, int m) {
        int output = 0;
        int j = 0;
        int i = 1;
        int oddCount = 0;
        if (arr[j] % 2 != 0) {
            oddCount++;
            if(oddCount == m){ //if m == 1
                output++;
                System.out.println(arr[j]);
            }
        }
        while (j < arr.length) {
            if (oddCount <= m && i < arr.length) {// there is a possiblity that i == arr.length
                if (arr[i] % 2 != 0) {
                    oddCount++;
                }
                if (oddCount == m) {
                    output++;
                    printArray(arr, j, i);
                }
                i++;
            }
            if (oddCount > m || i == arr.length) {
                oddCount = 0;
                j = j + 1;
                i = j + 1;
                if (j < arr.length && arr[j] % 2 != 0) {//check corner case always
                    oddCount++;
                    if(oddCount == m){ //if m==1
                        output++;
                        printArray(arr,j,j);
                    }
                }
            }
        }

        return output;
    }

    public static void printArray(int[] arr, int start, int end) {
        System.out.println("");
        for (int i = start; i <= end; i++) {
            System.out.print(" " + arr[i]);
        }
    }

}
/* Output --
 1 2 3
 1 2 3 4
 2 3 4 5
 3 4 5
 Sum -->4

 2 5
 2 5 4
 5
 5 4
 4 9
 9
 Sum -->6


 */