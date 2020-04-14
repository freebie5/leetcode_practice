package org.sy.leetcode_practice.numIslands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿数量
 */
public class NumIslands {

    //广度优先搜索
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0'; // mark as visited
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }
        return num_islands;
    }

    public int numIslands2(char[][] grid) {
        if(grid==null || grid.length==0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int result = 0;
        for(int i=0;i<nr;i++) {
            for(int j=0;j<nc;j++) {
                if(grid[i][j] == '1') {
                    result++;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i*nc + j);
                    grid[i][j] = '0';
                    while(!queue.isEmpty()) {
                        int cur = queue.remove();
                        int curR = cur / nc;
                        int curC = cur % nc;
                        if(curR-1>=0 && grid[curR-1][curC] == '1') {
                            grid[curR-1][curC] = '0';
                            queue.add((curR-1)*nc+curC);
                        }
                        if(curC+1<nc && grid[curR][curC+1] == '1') {
                            grid[curR][curC+1] = '0';
                            queue.add(curR*nc+(curC+1));
                        }
                        if(curR+1<nr && grid[curR+1][curC] == '1') {
                            grid[curR+1][curC] = '0';
                            queue.add((curR+1)*nc+curC);
                        }
                        if(curC-1>=0 && grid[curR][curC-1] == '1') {
                            grid[curR][curC-1] = '0';
                            queue.add(curR*nc+(curC-1));
                        }
                    }
                }
            }
        }
        return result;
    }

    //深度优先搜索
    public int numIslands3(char[][] grid) {

        if(grid==null || grid.length==0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int result = 0;
        for(int r=0;r<nr;r++) {
            for(int c=0;c<nc;c++) {
                if(grid[r][c] == '1') {
                    result++;
                    grid[r][c] = '0';
                    deepSearch(grid, r,c);
                }
            }
        }
        return result;
    }

    private void deepSearch(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;
        if(r-1>=0 && grid[r-1][c]=='1') {
            grid[r-1][c] = '0';
            deepSearch(grid, r-1, c);
        }
        if(r+1<nr && grid[r+1][c]=='1') {
            grid[r+1][c] = '0';
            deepSearch(grid, r+1, c);
        }
        if(c-1>=0 && grid[r][c-1]=='1') {
            grid[r][c-1] = '0';
            deepSearch(grid, r, c-1);
        }
        if(c+1<nc && grid[r][c+1]=='1') {
            grid[r][c+1] = '0';
            deepSearch(grid, r, c+1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1','1','1','1','0'},
            {'1','1','0','1','0'},
            {'1','1','0','0','0'},
            {'0','0','0','0','0'}
        };

        char[][] grid2 = {
            {'1','1','0','0','0'},
            {'1','1','0','0','0'},
            {'0','0','1','0','0'},
            {'0','0','0','1','1'}
        };

        NumIslands numbIslands = new NumIslands();
        int num = numbIslands.numIslands3(grid2);
        System.out.println(num);
    }

}
