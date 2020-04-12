package org.sy.leetcode_practice.validBracket;

import java.util.Stack;

/**
 * 有效的括号
 */
public class ValidBracket {

    private String leftBracket = "([{";
    private String rightBracket = "}])";
    private Stack<String> stack = new Stack<>();

    public boolean isValid(String s) {
        //空字符串
        if(s.length()==0) {
            return true;
        }
        //第一个字符就是闭括号
        if(this.rightBracket.indexOf(s.charAt(0))!=-1) {
            return false;
        }
        for(int i=0;i<s.length();i++) {
            String bracket = s.charAt(i)+"";
            //如果是左括号，则进栈
            if(this.leftBracket.indexOf(bracket)!=-1) {
                this.stack.push(bracket);
            }
            //如果是右括号，且和栈顶元素相同，则栈顶元素出栈
            if(this.rightBracket.indexOf(bracket)!=-1) {
                if(!this.stack.isEmpty() && ")".equals(bracket) && "(".equals(this.stack.peek())) {
                    this.stack.pop();
                } else if(!this.stack.isEmpty() && "]".equals(bracket) && "[".equals(this.stack.peek())) {
                    this.stack.pop();
                } else if(!this.stack.isEmpty() && "}".equals(bracket) && "{".equals(this.stack.peek())) {
                    this.stack.pop();
                } else {
                    return false;
                }
            }
        }
        //如果最后栈没有元素，则表达式合法
        if(this.stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ValidBracket().isValid("[])"));
    }

}
