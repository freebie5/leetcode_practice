package org.sy.leetcode_practice.inorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;

    }

    public void inorder(TreeNode node, ArrayList<Integer> arr) {
        if(node == null) {
            return;
        }
        inorder(node.left, arr);
        arr.add(node.val);
        inorder(node.right, arr);
    }

    public static void main(String[] args) {
        TreeNode _1 = new TreeNode(1);
        TreeNode _2 = new TreeNode(2);
        TreeNode _3 = new TreeNode(3);
        _1.right = _2;
        _2.left = _3;
        List<Integer> result = new InorderTraversal().inorderTraversal(_1);
        for(Integer item:result) {
            System.out.println(item);
        }

    }

}
