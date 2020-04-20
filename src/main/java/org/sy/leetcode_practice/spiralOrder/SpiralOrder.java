package org.sy.leetcode_practice.spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0) {
            return new ArrayList<>();
        }
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        //方向
        char dir = 'r';//
        //当前位置
        int i=0;
        int j=0;
        //已经遍历的层
        int top = 0;
        int right = 0;
        int bottom = 0;
        int left = 0;
        for(int k=0;k<m*n;k++) {
            result.add(k, matrix[i][j]);
            if(dir=='r') {
                if(j+1==n-right) {
                    top++;
                    dir = 'b';
                    i++;
                } else {
                    j++;
                }
            }else if(dir=='b') {
                if(i+1==m-bottom) {
                    right++;
                    dir = 'l';
                    j--;
                } else {
                    i++;
                }
            }else if(dir=='l') {
                if(j-1==-1+left) {
                    bottom++;
                    dir = 't';
                    i--;
                } else {
                    j--;
                }
            }else if(dir=='t') {
                if(i-1==-1+top) {
                    left++;
                    dir = 'r';
                    j++;
                } else {
                    i--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(new SpiralOrder().spiralOrder(matrix));
    }

}
