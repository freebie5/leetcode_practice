package org.sy.leetcode_practice.numSquares;

import java.util.Arrays;

import static java.lang.Math.sqrt;

/**
 * 完全平方数
 */
public class NumSquares {

    public boolean contain(int n, int[] arr) {
        for(int i : arr) {
            if(n == i) {
                return true;
            }
        }
        return false;
    }

    /**
     * 暴力枚举法 [超出时间限制]
     */
    public int numSquares2(int n) {
        //生产 完全平方数 数组
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }
        //刚好是 完全平方数 则直接返回
        if(this.contain(n, square_nums)) {
            return 1;
        }
        //递归
        int min_num = Integer.MAX_VALUE;
        for(int i=1;i<square_nums.length;i++) {
            if(n < square_nums[i]) {
                break;
            }
            int new_num = this.numSquares2(n-square_nums[i]) + 1;
            min_num = Math.min(min_num, new_num);
        }
        return min_num;

    }

    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;

        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        for (int i = 1; i <= n; ++i) {
            for (int s = 1; s < max_square_index; ++s) {
                if (i < square_nums[s])
                    break;
                dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        double result = new NumSquares().numSquares(3);
        System.out.println(result);
    }

}
