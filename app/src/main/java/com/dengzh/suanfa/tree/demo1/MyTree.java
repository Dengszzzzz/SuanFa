package com.dengzh.suanfa.tree.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dengzh
 * @date 2022/5/19
 * Description:有问题，感受一下什么是树即可。
 */
public class MyTree<E> implements Tree<E> {

    private int size;
    private TreeNode<E> root;

    public MyTree(TreeNode<E> root) {
        this.root = root;
        size++;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public TreeNode<E> getRoot() {
        return root;
    }

    @Override
    public TreeNode<E> getParent(TreeNode<E> node) {
        return node.parent;
    }

    /**
     * 获取节点node的子节点
     * */
    @Override
    public TreeNode<E> getFirstChild(TreeNode<E> node) {
        if (node.children == null){
            return null;
        }
        return node.children.get(0);
    }

    /**
     * 获取节点node的兄弟节点，也就是和node具有相同父节点的节点
     * */
    @Override
    public TreeNode<E> getNextSibling(TreeNode<E> node) {
       /* if (node.parent!=null){

        }
        return null;*/
        return null;
    }

    /**
     * 高度，node到叶子的最长路径
     * */
    @Override
    public int getHeight(TreeNode<E> node) {
        List<TreeNode<E>> child = node.children;
        int h = 0;
        for (int i = 0;i<child.size();i++){
            h = Math.max(h,getHeight(node.children.get(i)));
        }
        return h+1;
    }

    /**
     * 插入子节点
     * */
    @Override
    public void insertChild(TreeNode<E> node, TreeNode<E> child) {
        if (node.children == null){
            node.children = new ArrayList<>();
        }
        node.children.add(child);
        size++;
    }

    /**
     * 删除节点
     * */
    @Override
    public void deleteChild(TreeNode<E> node, int i) {
        node.children.remove(i);
        size--;
    }

    @Override
    public List<TreeNode<E>> preOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<TreeNode<E>> postOrder(TreeNode<E> x) {
        return null;
    }

    @Override
    public List<TreeNode<E>> levelOrder(TreeNode<E> x) {
        return null;
    }
}
