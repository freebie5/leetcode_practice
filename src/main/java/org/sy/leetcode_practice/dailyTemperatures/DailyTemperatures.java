package org.sy.leetcode_practice.dailyTemperatures;

import java.util.Stack;

/**
 * 每日温度
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        //
        for(int i=0;i<T.length;i++) {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                int j = stack.pop();
                ans[j] = i-j;
            }
            stack.push(i);
        }

        return ans;
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peek()]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = new DailyTemperatures().dailyTemperatures(temperatures);
        for(int i=0;i<result.length;i++) {
            if(i==0) {
                System.out.print("["+result[i]);
            } else {
                System.out.print(","+result[i]);
            }
            if(i==result.length-1) {
                System.out.println("]");
            }
        }
    }

}
