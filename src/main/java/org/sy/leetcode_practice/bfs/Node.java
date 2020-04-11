package org.sy.leetcode_practice.bfs;

import java.util.Objects;
import java.util.Set;

public class Node {

    private String name;
    private Set<Node> nexts;

    public Node(String name, Set<Node> nexts) {
        this.name = name;
        this.nexts = nexts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Node> getNexts() {
        return nexts;
    }

    public void setNexts(Set<Node> nexts) {
        this.nexts = nexts;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Node node = (Node) o;
//
//        return name.equals(node.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return name.hashCode();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return name != null ? name.equals(node.name) : node.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
