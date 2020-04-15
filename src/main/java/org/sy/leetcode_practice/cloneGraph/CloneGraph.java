package org.sy.leetcode_practice.cloneGraph;

import java.util.*;

/**
 * 克隆图
 */
public class CloneGraph {

    private Map<Node, Node> visited = new HashMap<Node, Node>();

    //深度优先
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node cloneNode = new Node(node.val, new ArrayList());
        visited.put(node, cloneNode);
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }

    public static void main(String[] args) {
        Node _1 = new Node(1);
        Node _2 = new Node(2);
        Node _3 = new Node(3);
        Node _4 = new Node(4);

        _1.neighbors.add(_2);
        _1.neighbors.add(_4);
        _2.neighbors.add(_1);
        _2.neighbors.add(_3);
        _3.neighbors.add(_2);
        _3.neighbors.add(_4);
        _4.neighbors.add(_1);
        _4.neighbors.add(_3);

        Node cloneNode = new CloneGraph().cloneGraph(_1);
        System.out.println(_1);
        System.out.println(cloneNode);

    }

}
