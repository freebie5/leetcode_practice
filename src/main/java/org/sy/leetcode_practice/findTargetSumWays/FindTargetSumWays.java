package org.sy.leetcode_practice.findTargetSumWays;

import java.util.Arrays;

/**
 * 目标和
 */
public class FindTargetSumWays {

//    public int findTargetSumWays(int[] nums, int S) {
//
//        int result = 0;
//        int sum = getSum(nums);
//        if(sum == S) {
//            result++;
//        }
//        for(int i=0;i<nums.length;i++) {
//            int[] copyNums = Arrays.copyOf(nums, nums.length);
//            copyNums[i] = -copyNums[i];
//            return findTargetSumWays(copyNums, S) + 1;
//        }
//        return result;
//
//    }
//
//    public int getSum(int[] nums) {
//        int sum = 0;
//        for(int item:nums) {
//            sum = sum + item;
//        }
//        return sum;
//    }

    //深度优先
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0, S);
        return count;
    }
    public void calculate(int[] nums, int i, int sum, int S) {
        if (i == nums.length) {
            if (sum == S)
                count++;
        } else {
            calculate(nums, i + 1, sum + nums[i], S);
            calculate(nums, i + 1, sum - nums[i], S);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        System.out.println(new FindTargetSumWays().findTargetSumWays(nums, 3));
    }

}
