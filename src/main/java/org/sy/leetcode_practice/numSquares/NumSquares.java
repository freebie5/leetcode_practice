package org.sy.leetcode_practice.numSquares;

import java.util.*;

import static java.lang.Math.sqrt;

/**
 * 完全平方数
 * 完全平方指用一个整数乘以自己例如1*1，2*2，3*3等，依此类推。
 * 若一个数能表示成某个整数的平方的形式，则称这个数为完全平方数。
 * 完全平方数是非负数，而一个完全平方数的项有两个。注意不要与完全平方式所混淆。
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
    public int numSquares1(int n) {
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
            min_num = Math.min(min_num, this.numSquares1(n-square_nums[i]) + 1);
        }
        return min_num;

    }

    /**
     * 动态规划
     * 解决递归中堆栈溢出的问题的一个思路就是使用动态规划（DP）技术，
     * 该技术建立在重用中间解的结果来计算终解的思想之上
     */
    public int numSquares2(int n) {
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

    /**
     * 贪心枚举
     */
    Set<Integer> square_nums = new HashSet<Integer>();

    protected boolean is_divided_by(int n, int count) {
        if (count == 1) {
            return square_nums.contains(n);
        }

        for (Integer square : square_nums) {
            if (is_divided_by(n - square, count - 1)) {
                return true;
            }
        }
        return false;
    }

    public int numSquares3(int n) {
        this.square_nums.clear();

        for (int i = 1; i * i <= n; ++i) {
            this.square_nums.add(i * i);
        }

        int count = 1;
        for (; count <= n; ++count) {
            if (is_divided_by(n, count))
                return count;
        }
        return count;
    }

    /**
     * 贪心 + BFS（广度优先搜索）
     */
    public int numSquares4(int n) {
        //生成完全平方数数组
        ArrayList<Integer> square_nums = new ArrayList<Integer>();
        for (int i = 1; i * i <= n; ++i) {
            square_nums.add(i * i);
        }
        //队列
        Set<Integer> queue = new HashSet<Integer>();
        queue.add(n);
        int level = 0;
        while (queue.size() > 0) {
            level += 1;
            Set<Integer> next_queue = new HashSet<Integer>();

            for (Integer remainder : queue) {
                for (Integer square : square_nums) {
                    if (remainder.equals(square)) {
                        return level;
                    } else if (remainder < square) {
                        break;
                    } else {
                        next_queue.add(remainder - square);
                    }
                }
            }
            queue = next_queue;
        }
        return level;
    }

    public int numSquares5(int n) {
        //生产 完全平方数 数组
        int max_square_index = (int) Math.sqrt(n) + 1;
        int square_nums[] = new int[max_square_index];
        for (int i = 1; i < max_square_index; ++i) {
            square_nums[i] = i * i;
        }

        //队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();//每一层的size大小固定
            for (int i=0;i<size;i++) {
                int remainder = queue.remove();
                for (int j=1;j<square_nums.length;j++) {
                    if (remainder == square_nums[j]) {
                        return level;
                    } else if (remainder < square_nums[j]) {
                        break;
                    } else {
                        queue.add(remainder - square_nums[j]);
                    }
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        long stime = System.currentTimeMillis();
        int result = new NumSquares().numSquares4(111);
        long end1 = System.currentTimeMillis() - stime;
        System.out.println("level->"+result+",time->"+end1);

        int result2 = new NumSquares().numSquares5(111);
        long end2 = System.currentTimeMillis() - stime;
        System.out.println("level->"+result2+",time->"+end2);
    }

}
