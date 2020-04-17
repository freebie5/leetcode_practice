package org.sy.leetcode_practice.decodeString;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 字符串解码
 */
public class DecodeString {

//    s = "3[a]2[bc]", 返回 "aaabcbc".
//    s = "3[a2[c]]", 返回 "accaccacc".
//    s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".

    private final String left = "[";
    private final String right = "]";
    private Stack<String> stack = new Stack<>();

    public String decodeString(String s) {

        String result = "";
        for(int i=0;i<s.length();i++) {
            String cur = s.charAt(i)+"";
            if(right.equals(cur)) {
                String top = stack.pop();
                List<String> seg = new ArrayList<>();
                while(!top.equals(left)) {
                    seg.add(top);
                    top = stack.pop();
                }
                List<String> numList = new ArrayList<>();
                while(!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    numList.add(stack.pop());
                }
                String num = "";
                for(String n : numList) {
                    num = n + num;
                }
                int time = Integer.valueOf(num);
                for(int j=0;j<time;j++) {
                    for(int k=seg.size()-1;k>=0;k--) {
                        stack.push(seg.get(k));
                    }
                }

            } else {
                stack.push(cur);
            }

        }
        while(!stack.isEmpty()) {
            result = stack.pop() + result;
        }
        return result;

    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(new DecodeString().decodeString(s));
    }

}
