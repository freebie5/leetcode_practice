package org.sy.leetcode_practice.openLock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 打开转盘锁
 */
public class OpenLock {

    public int openLock2(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for (String d: deadends) dead.add(d);

        Queue<String> queue = new LinkedList();
        queue.offer("0000");
        queue.offer(null);

        Set<String> seen = new HashSet();
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            String node = queue.poll();
            if (node == null) {
                depth++;
                if (queue.peek() != null)
                    queue.offer(null);
            } else if (node.equals(target)) {
                return depth;
            } else if (!dead.contains(node)) {
                for (int i = 0; i < 4; ++i) {
                    for (int d = -1; d <= 1; d += 2) {
                        int y = ((node.charAt(i) - '0') + d + 10) % 10;
                        String nei = node.substring(0, i) + ("" + y) + node.substring(i+1);
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            queue.offer(nei);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int openLock(String[] deadends, String target) {

        Set<String> deads = new HashSet<>();
        for(String str : deadends) {
            deads.add(str);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        queue.offer(null);
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        int deep = 0;

        while(!queue.isEmpty()) {
            String str = queue.poll();
            if(str==null) {
                deep++;
                if(queue.peek()!=null) {
                    queue.offer(null);
                }
            } else if(target.equals(str)) {
                return deep;
            } else if(!deads.contains(str)) {
                for(int i=0;i<4;i++) {
                    for(int j=-1;j<=1;j=j+2) {
                        int cNew = (str.charAt(i) - '0' + 10 + j) % 10;
                        String strNew = str.substring(0,i) + cNew + str.substring(i+1);
                        if(!seen.contains(strNew)) {
                            queue.offer(strNew);
                            seen.add(strNew);
                        }
                    }
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";

        int result = new OpenLock().openLock(deadends, target);
        System.out.println(result);
    }


}
