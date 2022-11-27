package com.dengzh.suanfa.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Dengzh
 * @date 2022/5/19
 * Description: 哈夫曼树
 * 对于给定的有各自权值的 n 个结点，构建哈夫曼树有一个行之有效的办法：
 * 1）在 n 个权值中选出两个最小的权值，对应的两个结点组成一个新的二叉树，且新二叉树的根结点的权值为左右孩子权值的和；
 * 2）在原有的 n 个权值中删除那两个最小的权值，同时将新的权值加入到 n–2 个权值的行列中，以此类推；
 * 3）重复 1 和 2 ，直到所以的结点构建成了一棵二叉树为止，这棵树就是哈夫曼树。
 */
public class HuffmanTree {

    public static class Node<T>{
        private T data;
        private int weight; //权重
        private Node leftChild;
        private Node rightChild;

        public Node(T data, int weight) {
            this.data = data;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", weight=" + weight +
                    '}';
        }
    }

    /**
     * 创建Huffman树
     * */
    private static Node createTree(List<Node> nodes){
        //最终nodes只剩下一个节点，就是根节点
        while (nodes.size()>1){
            //将list排序按照权重增序方式进行排序,找到最小的
            sort(nodes);
            //左边比右边小
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            //生成一个新的节点
            Node parent = new Node(null,left.weight+right.weight);
            parent.leftChild = left;
            parent.rightChild = right;
            //把这节点放入nodes，且移除left和right
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 冒泡排序
     * */
    public static void sort(List<Node> nodes){
        if (nodes.size()<1){
            return;
        }
        for (int i=0;i<nodes.size();i++){
            for (int j = 0;j<nodes.size() - 1 - i;j++){
                if (nodes.get(j).weight > nodes.get(j+1).weight){
                    Node tempNode = nodes.get(j);
                    nodes.set(j,nodes.get(j+1));
                    nodes.set(j+1,tempNode);
                }
            }
        }
    }

    /**
     * 递归打印哈夫曼树(先左子树，后右子树打印)
     */
    public static void printTree(Node root){
        System.out.println(root.toString());
        if (root.leftChild!=null){
            System.out.print("Left:");
            printTree(root.leftChild);
        }
        if (root.rightChild!=null){
            System.out.print("Right:");
            printTree(root.rightChild);
        }
    }

    /**
     * 测试
     */
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();
        //把节点加入至list中
        nodes.add(new Node("a", 10));
        nodes.add(new Node("b", 15));
        nodes.add(new Node("c", 12));
        nodes.add(new Node("d", 3));
        nodes.add(new Node("e", 4));
        nodes.add(new Node("f", 13));
        nodes.add(new Node("g", 1));
        //进行哈夫曼树的构造
        Node root = HuffmanTree.createTree(nodes);
        //打印哈夫曼树
        printTree(root);
    }
}
