package com.algorithm.graph;

public class NumberOfIsland {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("Number of island -->" + s.numIslands(new char[][]
                       {{'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}}));//ans 1

        System.out.println("Number of island -->" + s.numIslands(new char[][]
                       {{'1', '1', '0', '0', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '1', '0', '0'},
                        {'0', '0', '0', '1', '1'}}));//ans 3
    }

}


class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        if (col == 0) return 0;
        int size = 0;
        if (row > col) size = row;
        else size = col;
        boolean[][] visited = new boolean[size][size];//or simply use boolean[row][column] for perfect 2D map
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < grid[i].length; j++) { //or simply use j < grid[0].length for perfect 2D map
                if (grid[i][j] == '1' && !(visited[i][j])) {
                    count = count + 1;
                    doDFS(i, j, grid, visited);
                }
            }//j
        }//i
        return count;
    }//numsIsland

    public void doDFS(int i, int j, char[][] grid, boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || visited[i][j] == true || grid[i][j] == '0')
            return;
        visited[i][j] = true;
        doDFS(i + 1, j, grid, visited);//up
        doDFS(i - 1, j, grid, visited);//down
        doDFS(i, j + 1, grid, visited);//left
        doDFS(i, j - 1, grid, visited);//right
    }

}