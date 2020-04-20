package org.sy.leetcode_practice.findDiagonalOrder;

import org.sy.leetcode_practice.findTargetSumWays.FindTargetSumWays;

/**
 * 对角线遍历
 */
public class FindDiagonalOrder {

    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length==0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        //结果数组
        int[] result = new int[m*n];
        //当前位置
        int i = 0;
        int j = 0;
        //方向
        boolean dir = true;//向上true，向下false
        for(int k=0;k<result.length;k++) {
            result[k] = matrix[i][j];
            if(dir) {
                if(i-1<0 || j+1>=n) {
                    dir = false;
                    if(j==n-1) {
                        i++;
                    } else {
                        j++;
                    }
                } else {
                    i--;
                    j++;
                }
            } else {
                if(i+1>=m || j-1<0) {
                    dir=true;
                    if(i==m-1) {
                        j++;
                    } else {
                        i++;
                    }
                } else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                { 1, 2, 3, 4, 5},
                { 6, 7, 8, 9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
        };
        int[] result = new FindDiagonalOrder().findDiagonalOrder(matrix);
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+",");
        }
    }

}
