package com.algorithm.graph;

public class ConvertZeros {
    public static void main(String[] args) {
        convertZeros(new int[][]
                       {{1, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 1}}
        ); /*output
             1 2 2 3 3
             2 1 2 2 3
             2 2 1 2 2
             3 2 2 2 1
        */
        convertZeros(new int[][]
                       {{1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 0}}
        ); /*output
             1 2 3 4 5
             2 2 3 4 5
             3 3 3 4 5
             4 4 4 4 5
        */
    }

    public static int convertZeros(int[][] input) {
        int count = 1;

        while (doesZeroExist(input)) {
            for (int i = 0; i < input.length; i++) {
                for (int j = 0; j < input[i].length; j++) {
                    if (input[i][j] == count) {
                        if (i != 0)
                            input[i - 1][j] = input[i - 1][j] > 0 ? input[i - 1][j] : count + 1;//up
                        if (i < input.length - 1)
                            input[i + 1][j] = input[i + 1][j] > 0 ? input[i + 1][j] : count + 1;//down
                        if (j < input[i].length - 1)
                            input[i][j + 1] = input[i][j + 1] > 0 ? input[i][j + 1] : count + 1;//right
                        if (j != 0)
                            input[i][j - 1] = input[i][j - 1] > 0 ? input[i][j - 1] : count + 1;//left
                        if (i < input.length - 1 && j < input[i].length - 1)
                            input[i + 1][j + 1] = input[i + 1][j + 1] > 0 ? input[i + 1][j + 1] : count + 1;// bottom right diagonal
                        if (i < input.length - 1 && j != 0)
                            input[i + 1][j - 1] = input[i + 1][j - 1] > 0 ? input[i + 1][j - 1] : count + 1;//bottom left diagonal
                        if (i != 0 && j < input[i].length - 1)
                            input[i - 1][j + 1] = input[i - 1][j + 1] > 0 ? input[i - 1][j + 1] : count + 1;// up right diagonal
                        if (i != 0 && j != 0)
                            input[i - 1][j - 1] = input[i - 1][j - 1] > 0 ? input[i - 1][j - 1] : count + 1;//up left diagonal
                    }
                }
            }
            count++;
        }
        print(input);

        return count;
    }

    public static void print(int[][] input) {
        System.out.println("Output -->");
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                System.out.print("" + input[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean doesZeroExist(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                if (input[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
