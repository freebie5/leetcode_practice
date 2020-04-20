package org.sy.leetcode_practice.dominantIndex;

/**
 * 至少是其他数字两倍的最大数
 */
public class DominantIndex {

    //时间复杂度n^2，不是最优解
    public int dominantIndex2(int[] nums) {

        for(int i=0;i<nums.length;i++) {
            boolean flag = true;
            for(int j=0;j<nums.length;j++) {
                if(i!=j) {
                    if(nums[i]<nums[j]*2) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag) {
               return i;
            }
        }

        return -1;
    }

    //最优解
    public int dominantIndex(int[] nums) {
        int max = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[max]<nums[i]) {
                max = i;
            }
        }
        for(int i=0;i<nums.length;i++) {
            if(max!=i && nums[max]<nums[i]*2) {
                return -1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,0,1};
        System.out.println(new DominantIndex().dominantIndex(nums));
    }

}
