package com.dengzh.suanfa.tree.demo1;

import java.util.List;

/**
 * @author Dengzh
 * @date 2022/5/19
 * Description:树的节点（一个父，n个子）
 */
public class TreeNode<E> {
    public E key; //data
    public TreeNode<E> parent;
    public List<TreeNode<E>> children;

    public TreeNode(E key, TreeNode<E> parent) {
        this.key = key;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "key=" + key +
                '}';
    }
}
