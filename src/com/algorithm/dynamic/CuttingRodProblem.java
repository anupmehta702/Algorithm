package com.algorithm.dynamic;

public class CuttingRodProblem {
    static int[] price = new int[]{2, 5, 7, 8};
    static int lengthOfRod = 5;
    /*static int[] price = new int[]{1,5,8,9,10,17,17,20};
    static int lengthOfRod = 8;
*/
    public static void main(String[] args) {
        System.out.println("Max value of rod -->" + maxRodPrice());
    }

    public static int maxRodPrice() {
        int[][] T = new int[price.length + 1][lengthOfRod + 1];
        initializeMatrix(T);
        int maxVal = 0;
        for (int i = 1; i < price.length+1; i++) {
            for (int j = 1; j < lengthOfRod + 1; j++) {
                int remainingWeight = j - i;
                if (remainingWeight >= 0) { //This is for cases where the length of piece is more than the requirement .
                                            //Example length of piece is 3 and requirement is 1 ,eg T[3][2]
                    T[i][j] = Math.max(price[i - 1] + T[i][remainingWeight], T[i - 1][j]);
                    if (T[i][j] > maxVal) {
                        maxVal = T[i][j];
                    }
                }else{
                    T[i][j]=T[i - 1][j];
                }
            }
        }
        printMatrix(T);
        return maxVal;
    }

    public static void initializeMatrix(int[][] T) {
        for (int i = 0; i < lengthOfRod + 1; i++) {
            T[0][i] = 0;
        }
        for (int i = 0; i < price.length + 1; i++) {
            T[i][0] = 0;
        }
        printMatrix(T);
    }

    public static void printMatrix(int[][] T) {
        for (int i = 0; i < price.length + 1; i++) {
            System.out.println();
            for (int j = 0; j < lengthOfRod + 1; j++) {
                System.out.print(" " + T[i][j] + " ");
            }
        }
        System.out.println();
    }

}
//Output

/* input - 2,5,7,8 and resultantLengthOfRod - 5
 0  0  0  0  0  0
 0  2  4  6  8  10
 0  2  5  7  10  12
 0  2  5  7  10  12
 0  2  5  7  10  12
 Max value of rod -->12

 Formula --- T[i][j] = Max{val[i]+ T[i][j-i],T[i-1][j]}
*/
