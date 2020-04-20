package org.sy.leetcode_practice.pivotIndex;

/**
 * 寻找数组的中心索引
 */
public class PivotIndex {

    public int pivotIndex(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            //左边的和
            int lsum = 0;
            for(int l=0;l<i;l++) {
                lsum = lsum+nums[l];
            }
            //右边的和
            int rsum = 0;
            for(int r=i+1;r<nums.length;r++) {
                rsum = rsum+nums[r];
            }
            //
            if(lsum==rsum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,3,6,5,6};
        System.out.println(new PivotIndex().pivotIndex(nums));
    }

}
