package com.algorithm.dynamic;

public class StockBuySellKTransactions {
    static Integer input[] = new Integer[]{2, 5, 7, 1, 4, 3, 1, 3};
    static Integer maxNoOfTransaction = 2;
    public static void main(String[] args) {
        System.out.println("Maximum profit --> "+findMaxProfit(input, maxNoOfTransaction));
    }

    public static int findMaxProfit(Integer[] input, Integer maxNoOfTransaction) {
        int[][] matrix = new int[maxNoOfTransaction + 1][input.length];
        initializeMatrix(matrix);
        printMatrix(matrix);
        for (int i = 1; i < maxNoOfTransaction + 1; i++) {
            for (int j = 1; j < input.length; j++) {
                int maxVal=0;
                for (int m = 0; m < j; m++) {
                    maxVal = Math.max(maxVal,
                            input[j]-input[m]+matrix[i-1][m]);
                }
                matrix[i][j]=Math.max(matrix[i][j-1],maxVal);
            }
        }
        printMatrix(matrix);
        return matrix[maxNoOfTransaction][input.length-1];
    }

    public static void initializeMatrix(int[][] matrix) {
        for (int i = 0; i < input.length; i++) {
            matrix[0][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 0;
        }
    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < input.length; j++) {
                System.out.print(" " + matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
//Input - {2, 5, 7, 1, 4, 3, 1, 3} ,maxNoOfTransaction- 2
// Output
/*
 0  0  0  0  0  0  0  0
 0  3  5  5  5  5  5  5
 0  3  5  5  8  8  8  8

Maximum profit --> 8

Formula - T[i][j]= Math.max{T[i][j-1], // prev best transaction on j-1th Day
 price[j]-price[m] + T[i-1][m]} ,m is number of previous days from 0,1,2..j-1 //transaction made on jth day
*/