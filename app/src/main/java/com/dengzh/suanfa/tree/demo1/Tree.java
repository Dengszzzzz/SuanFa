package com.dengzh.suanfa.tree.demo1;

import java.util.List;

/**
 * @author Dengzh
 * @date 2022/5/19
 * Description:
 */
public interface Tree<E> {
    int getSize(); //节点数
    TreeNode<E> getRoot(); //根节点
    TreeNode<E> getParent(TreeNode<E> node); //父节点
    TreeNode<E> getFirstChild(TreeNode<E> node); //第一个子节点
    TreeNode<E> getNextSibling(TreeNode<E> node); //兄弟节点
    int getHeight(TreeNode<E> node); //高度
    void insertChild(TreeNode<E> node,TreeNode<E> child);
    void deleteChild(TreeNode<E> node,int i);
    List<TreeNode<E>> preOrder(TreeNode<E> x);
    List<TreeNode<E>> postOrder(TreeNode<E> x);
    List<TreeNode<E>> levelOrder(TreeNode<E> x);
}
