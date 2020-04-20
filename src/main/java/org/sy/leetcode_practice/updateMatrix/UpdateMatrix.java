package org.sy.leetcode_practice.updateMatrix;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 01矩阵
 */
public class UpdateMatrix {

    //深度优先搜索
    public int[][] updateMatrix(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;
        for(int r=0;r<nr;r++) {
            for(int c=0;c<nc;c++) {
                Set<Integer> visited = new HashSet<>();
                visited.add(r*nr+c);
                matrix[r][c] = dfs(matrix, r, c, visited);
            }
        }
        return matrix;
    }
    private int dfs(int[][] matrix, int r, int c, Set<Integer> visited) {
        if(matrix[r][c]==0) {
            return 0;
        } else {
            int minStep = 20000;
            int nr = matrix.length;
            int nc = matrix[0].length;
            if(r-1>=0 && !visited.contains((r-1)*nr+c)) {
                visited.add((r-1)*nr+c);
                minStep = Math.min(minStep, dfs(matrix, r-1, c, visited)+1);
                visited.remove((r-1)*nr+c);
            }
            if(r+1<matrix.length && !visited.contains((r+1)*nr+c)) {
                visited.add((r+1)*nr+c);
                minStep = Math.min(minStep, dfs(matrix, r+1, c, visited)+1);
                visited.remove((r+1)*nr+c);
            }
            if(c-1>=0 && !visited.contains(r*nr+c-1)) {
                visited.add(r*nr+c-1);
                minStep = Math.min(minStep, dfs(matrix, r, c-1, visited)+1);
                visited.remove(r*nr+c-1);
            }
            if(c+1<matrix[0].length && !visited.contains(r*nr+c+1)) {
                visited.add(r*nr+c+1);
                minStep = Math.min(minStep, dfs(matrix, r, c+1, visited)+1);
                visited.remove(r*nr+c+1);
            }
            return minStep;
        }
    }

    //广度优先搜索
    public int[][] updateMatrix2(int[][] matrix) {

        int nr = matrix.length;
        int nc = matrix[0].length;
        int[][] result = new int[nr][nc];

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        //0进栈
        for(int i=0;i<nr;i++) {
            for(int j=0;j<nc;j++) {
                if(matrix[i][j]==0) {
                    queue.add(i*nc+j);
                }
            }
        }

        //
        while(!queue.isEmpty()) {
            int cur = queue.remove();
            int r = cur / nc;
            int c = cur % nc;
            if(r-1>=0 && !visited.contains((r-1)*nc+c) && matrix[r-1][c]==1) {
                visited.add((r-1)*nc+c);
                queue.add((r-1)*nc+c);
                result[r-1][c] = result[r][c]+1;
            }
            if(r+1<nr && !visited.contains((r+1)*nc+c) && matrix[r+1][c]==1) {
                visited.add((r+1)*nc+c);
                queue.add((r+1)*nc+c);
                result[r+1][c] = result[r][c]+1;
            }
            if(c-1>=0 && !visited.contains(r*nc+c-1) && matrix[r][c-1]==1) {
                visited.add(r*nc+c-1);
                queue.add(r*nc+c-1);
                result[r][c-1] = result[r][c]+1;
            }
            if(c+1<nc && !visited.contains(r*nc+c+1) && matrix[r][c+1]==1) {
                visited.add(r*nc+c+1);
                queue.add(r*nc+c+1);
                result[r][c+1] = result[r][c]+1;
            }
        }

        return result;

    }

    //动态规划
    public int[][] updateMatrix3(int[][] matrix) {
        int nr = matrix.length;
        int nc = matrix[0].length;
        //初始化结果
        int[][] dist = new int[nr][nc];
        for(int i=0;i<nr;i++) {
            for(int j=0;j<nc;j++) {
                if(matrix[i][j]==0) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE/2;
                }
            }
        }
        //左上
        for(int i=0;i<nr;i++) {
            for(int j=0;j<nc;j++) {
                if(i-1>=0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                }
                if(j-1>=0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
                }
            }
        }
        //左下
        for(int i=0;i<nr;i++) {
            for(int j=0;j<nc;j++) {
                if(i+1<nr) {
                    dist[i][j] = Math.min(dist[i][j], dist[i+1][j]+1);
                }
                if(j-1>=0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j-1]+1);
                }
            }
        }
        //右上
        for(int i=0;i<nr;i++) {
            for(int j=0;j<nc;j++) {
                if(i-1>=0) {
                    dist[i][j] = Math.min(dist[i][j], dist[i-1][j]+1);
                }
                if(j+1<nc) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j+1]+1);
                }
            }
        }
        //右下
        for(int i=0;i<nr;i++) {
            for(int j=0;j<nc;j++) {
                if(i+1<nr) {
                    dist[i][j] = Math.min(dist[i][j], dist[i+1][j]+1);
                }
                if(j+1<nc) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][j+1]+1);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}};
        int[][] matrix2 = {
                {0},
                {0},
                {0},
                {0},
                {0}
        };
        int[][] matrix3 = {
                {0,0,0},
                {0,1,0},
                {1,1,1},
        };
        int[][] result = new UpdateMatrix().updateMatrix3(matrix3);
        for(int i=0;i<result.length;i++) {
            for(int j=0;j<result[0].length;j++) {
                System.out.print(result[i][j]+",");
            }
            System.out.println();
        }

    }

}
