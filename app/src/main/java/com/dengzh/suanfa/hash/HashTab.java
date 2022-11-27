package com.dengzh.suanfa.hash;

/**
 * @author Dengzh
 * @date 2022/5/17
 * Description:
 */
public class HashTab {

    public EmpLinedList[] empLinedLists;
    public int size;

    public HashTab() {

    }

    public HashTab(int size){
        this.size = size;
        empLinedLists = new EmpLinedList[size];
        for (int i = 0;i<size;i++){
            empLinedLists[i] = new EmpLinedList();
        }
    }

    /**
     * 简单hash计算，只是%size
     * 举例容量为10，则no=0和no=10，都在0号位的链表上。
     * */
    private int hash(int no){
        return no%size;
    }

    public void add(EmpNode node){
        int index = hash(node.no);
        empLinedLists[index].add(node);
    }

    public boolean findByNo(int no) {
        int index = hash(no);
        return empLinedLists[index].findByNo(no);
    }

    public boolean del(EmpNode node) {
        int index = hash(node.no);
        return empLinedLists[index].del(node);
    }

    public void insert(EmpNode node) {
        int index = hash(node.no);
        empLinedLists[index].insert(node);
    }

}
