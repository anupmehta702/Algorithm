package com.algorithm.dynamic;

public class CoinExchangeProblem {

    public static void main(String[] args) {
        findNumberOfCoinExchangesFor(new int[]{1, 5, 6, 8}, 11);
        numberOfSolutions( 11,new int[]{1, 5, 6, 8});
    }

    public static void findNumberOfCoinExchangesFor(int[] input, int exchangeValue) {
        int[][] c = new int[input.length + 1][exchangeValue + 1];
        for (int i = 0; i <= input.length; i++) {
            c[i][0] = 0;
        }
        for (int j = 1; j <= exchangeValue; j++) {
            c[0][j] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= exchangeValue; j++) {
                if (input[i - 1] > j) {
                    c[i][j] = c[i - 1][j];
                } else {
                    c[i][j] = Math.min(c[i - 1][j], 1 + c[i][j - input[i - 1]]);
                }
            }
        }
        System.out.println("Number of ways to exchange coins for value ->" + exchangeValue + " is ->" + c[input.length][exchangeValue]);
        System.out.println("Printing dynamic array -->");
        for (int i = 0; i <= input.length; i++) {
            for (int j = 0; j <= exchangeValue; j++) {
                System.out.print(" " + c[i][j]);
            }
            System.out.println();
        }

    }

    public static  int numberOfSolutions(int total, int coins[]){
        int temp[][] = new int[coins.length+1][total+1];
        for(int i=0; i <= coins.length; i++){
            temp[i][0] = 1;
        }
        for(int i=1; i <= coins.length; i++){
            for(int j=1; j <= total ; j++){
                if(coins[i-1] > j){
                    temp[i][j] = temp[i-1][j];
                }
                else{
                    temp[i][j] = temp[i][j-coins[i-1]] + temp[i-1][j];
                }
            }
        }

        System.out.println("Printing dynamic array -->");
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= total; j++) {
                System.out.print(" " + temp[i][j]);
            }
            System.out.println();
        }
        return temp[coins.length][total];
    }
}
