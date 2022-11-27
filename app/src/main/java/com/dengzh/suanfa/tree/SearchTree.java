package com.dengzh.suanfa.tree;

/**
 * @author Dengzh
 * @date 2022/5/19
 * Description:
 */
public class SearchTree {

    /**
     * 二叉搜索树
     * @param tree 二叉搜索树
     * @param target 目标节点
     * @return 是否找到目标节点
     * */
    public static boolean find(TreeNode<Integer> tree,int target){
        if (tree == null){
            return false;
        }
        //非递归
        /*while (tree!=null){
            if (tree.getContent()<target){
                tree = tree.getRight();
            }else if (tree.getContent()>target){
                tree = tree.getLeft();
            }else{
                return true;
            }
        }
        return false;*/
        //递归
        if (tree.getContent()<target){
            return find(tree.getRight(),target);
        }else if (tree.getContent()>target){
            return find(tree.getLeft(),target);
        }else{
            return true;
        }
    }

    /**
     * 二叉搜索树的删除
     *
     * @param tree 二叉树
     * @param value 删除的值
     */
    public static TreeNode<Integer> remove(TreeNode<Integer> tree, int value) {
        //找到需要删除的节点 和 父亲节点 和需要删除节点在父亲结点的右侧还是左侧
        TreeNode<Integer> current = null;
        TreeNode<Integer> parent = null;
        boolean isRight = true;

        TreeNode<Integer> temp = tree;
        while (temp!=null){
            if (temp.getContent() > value){
                parent = temp;
                temp = temp.getLeft();
                isRight = false;
            }else if (temp.getContent() < value){
                parent = temp;
                temp = temp.getRight();
                isRight = true;
            }else {
                //找到该节点
                current = temp;
                break;
            }
        }
        //为null，没找到该节点
        if (current == null){
            return null;
        }

        if (current.getLeft() == null && current.getRight() == null){
            //叶子结点，直接删除
            if (parent == null){
                return null;
            }
            if (isRight){
                parent.setRight(null);
            }else{
                parent.setLeft(null);
            }
        }else if (current.getLeft() == null || current.getRight() == null){
            //单节点，把父节点和子节点直接关联
            TreeNode<Integer> childNode = current.getLeft();
            if (childNode==null){
                childNode = current.getRight();
            }
            if (parent == null){
                return null;
            }
            if (isRight){
                parent.setRight(childNode);
            }else{
                parent.setLeft(childNode);
            }
        }else {
            //双节点，找到该节点右子树最小的节点
            TreeNode<Integer> childParent = current;
            TreeNode<Integer> child = current.getRight();
            while (child.getLeft()!=null){
                childParent = child;
                child = child.getLeft();
            }
            current.setContent(child.getContent());
            childParent.setLeft(null);
        }
        return tree;
    }

    /**
     * 二叉搜索树插入
     *
     * @param tree 二叉搜索树
     * @param target 目标节点
     * @return 插入目标节点
     */
    public static TreeNode<Integer> insert(TreeNode<Integer> tree, int target) {
        if (tree==null){
            return new TreeNode<Integer>(target,null,null);
        }
        TreeNode<Integer> parentNode = tree;
        while (parentNode!=null){
            if (target < parentNode.getContent()){
                //找左子树
                if (parentNode.getLeft() != null){
                    parentNode = parentNode.getLeft();
                }else{
                    //为空，找到子节点
                    break;
                }
            }else if (target > parentNode.getContent()){
                //找右子树
                if (parentNode.getRight() != null){
                    parentNode = parentNode.getRight();
                }else{
                    //为空，找到子节点
                    break;
                }
            }else{
                break;
            }
        }
        //对比父节点
        if (target<parentNode.getContent()){
            parentNode.setLeft(new TreeNode<>(target,null,null));
        }else if (target>parentNode.getContent()){
            parentNode.setRight(new TreeNode<>(target,null,null));
        }else{
            //这个节点和parentNode相等，不能插入
        }
        return tree;
    }
}
