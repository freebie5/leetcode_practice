package org.sy.leetcode_practice.evalRPN;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {

        int result = 0;
        Stack<String> stack = new Stack<>();
        String fun = "+-*/";
        for (int i = 0; i < tokens.length; i++) {

            if (fun.indexOf(tokens[i]) != -1) {
                int right = Integer.valueOf(stack.pop());
                int left = Integer.valueOf(stack.pop());
                if ("+".equals(tokens[i])) {
                    int res = left + right;
                    stack.push(res+"");
                }
                if ("-".equals(tokens[i])) {
                    int res = left - right;
                    stack.push(res+"");
                }
                if ("*".equals(tokens[i])) {
                    int res = left * right;
                    stack.push(res+"");
                }
                if ("/".equals(tokens[i])) {
                    int res = left / right;
                    stack.push(res+"");
                }
            } else {
                stack.push(tokens[i]);
            }
        }
        result = Integer.valueOf(stack.peek());
        return result;

    }

    public static void main(String[] args) {
        String[] input = new String[]{"2", "1", "+", "3", "*"};
        String[] input2 = new String[]{"4", "13", "5", "/", "+"};
        String[] input3 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvalRPN().evalRPN(input3));
    }

}
