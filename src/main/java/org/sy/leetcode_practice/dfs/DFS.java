package org.sy.leetcode_practice.dfs;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 深度优先搜索
 */
public class DFS {

    public boolean dfs(Node root, Node target, Set<Node> visited) {

        if(root.getName().equals(target.getName())) {
            return true;
        }
        for(Node next : root.getNexts()) {
            if(!visited.contains(next)) {
                visited.add(next);
                if(dfs(next, target, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    //
    public boolean dfsStack(Node root, Node target) {
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node cur = stack.pop();
            if(cur.getName().equals(target.getName())) {
                return true;
            }
            for(Node ne:cur.getNexts()) {
                if(!visited.contains(ne)) {
                    stack.push(ne);
                    visited.add(ne);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        //初始化
        Node H = new Node("H", new HashSet<>());
        Set<Node> GNexts = new HashSet<>();
        GNexts.add(H);
        Node G = new Node("G", GNexts);
        Set<Node> FNexts = new HashSet<>();
        FNexts.add(G);
        Node F = new Node("F", FNexts);
        Node E = new Node("E", new HashSet<>());
        Set<Node> DNexts = new HashSet<>();
        DNexts.add(G);
        DNexts.add(F);
        Node D = new Node("D", DNexts);
        Set<Node> CNexts = new HashSet<>();
        CNexts.add(E);
        CNexts.add(F);
        Node C = new Node("C", CNexts);
        Set<Node> BNexts = new HashSet<>();
        BNexts.add(E);
        Node B = new Node("B", BNexts);
        Set<Node> ANexts = new HashSet<>();
        ANexts.add(B);
        ANexts.add(C);
        ANexts.add(D);
        Node A = new Node("A", ANexts);

        //开始遍历
        DFS dfs = new DFS();
        Set<Node> visited = new HashSet<>();
//        boolean steps = dfs.dfs(A, H, visited);
        boolean steps = dfs.dfsStack(A, H);
        System.out.println(steps);
    }

}
