package org.sy.leetcode_practice.bfs;

import java.util.*;

/**
 * 广度优先搜索 - 模板
 */
public class BFS {

    public int bfs(Node root, Node target) {
        int step = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();//每一层的size大小固定
            for (int i = 0; i < size; i++) {
                Node cur = queue.remove();
                if (cur.getName().equals(target.getName())) {
                    return step;
                }
                Iterator<Node> nexts = cur.getNexts().iterator();
                while (nexts.hasNext()) {
                    queue.add(nexts.next());
                }
            }
        }
        return -1;
    }

    public int bfs2(Node root, Node target) {
        int step = 0;
        Queue<Node> queue = new LinkedList<>();
        Set<Node> used = new HashSet<>();
        queue.add(root);
        used.add(root);
        // BFS
        while (!queue.isEmpty()) {
            step++;
            for (int i = 0; i < queue.size(); i++) {
                Node cur = queue.remove();
                if (cur.getName().equals(target.getName())) {
                    return step;
                }
                Iterator<Node> nexts = cur.getNexts().iterator();
                while (nexts.hasNext()) {
                    Node next = nexts.next();
                    if (!used.contains(next)) {
                        queue.add(next);
                        used.add(next);
                    }
                }
            }
        }
        return -1;
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
        BFS bfs = new BFS();
        int steps = bfs.bfs(A, H);
        System.out.println(steps);
    }

}
