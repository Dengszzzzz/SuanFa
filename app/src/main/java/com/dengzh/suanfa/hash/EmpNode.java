package com.dengzh.suanfa.hash;

/**
 * @author Dengzh
 * @date 2022/5/17
 * Description:
 */
public class EmpNode {

    public int no;
    public String name;
    public EmpNode next;

    public EmpNode(int no,String name) {
        this.no = no;
        this.name = name;
    }

    public EmpNode() {

    }

    public String toString() {
        return "该雇员的no[" + no + "] 名字是[" + name + "]";
    }
}
