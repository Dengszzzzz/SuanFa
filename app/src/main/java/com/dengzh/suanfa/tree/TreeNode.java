package com.dengzh.suanfa.tree;

/**
 * @author Dengzh
 * @date 2022/5/19
 * Description:二叉树结点
 */
public class TreeNode<T> {

    private T content;
    private TreeNode<T> left;
    private TreeNode<T> right;

    public TreeNode(T content, TreeNode<T> left, TreeNode<T> right) {
        this.content = content;
        this.left = left;
        this.right = right;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

}
