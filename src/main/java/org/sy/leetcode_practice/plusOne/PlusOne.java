package org.sy.leetcode_practice.plusOne;

/**
 * 加一
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if(digits[i]!=0) {
                return digits;
            }
        }
        int[] result = new int[digits.length+1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{8,9,9,9};
        int[] result = new PlusOne().plusOne(digits);
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+",");
        }
    }

}
