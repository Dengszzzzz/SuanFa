package com.dengzh.suanfa.hash;

/**
 * @author Dengzh
 * @date 2022/5/17
 * Description:
 */
public class EmpLinedList {
    /**
     * head指向的是第一个节点的,不是头节点,哈希表底层的单向链表是无头节点的
     * */
    private EmpNode head;

    /**
     * 链表尾部添加
     * */
    public void add(EmpNode node) {
        if(head == null) {
            head = node;
            return;
        }
        EmpNode cur = head;
        while(cur.next != null)
            cur = cur.next;
        cur.next = node;
    }

    public boolean findByNo(int no) {
        if(head == null) {
            return false;
        }
        EmpNode cur = head;
        while(cur != null && cur.no != no){
            cur = cur.next;
        }
        return cur != null;
    }

    /**
     * 删除节点
     * 1.是否第一个节点为空
     * 2.是否只有一个节点,且该节点是否为我们想要删除的节点
     * 3.是否含有多个节点,且第一个节点是否为我们想要删除的节点
     * 4.是否含有多个节点,且第一个节点不是我们想要删除的节点
     * */
    public boolean del(EmpNode node) {
        if(head == null) {
            return false;
        }else if(head.next == null) {
            if(head.no == node.no) {
                head = null;
                return true;
            }else {
                return false;
            }
        }else {
            if(head.no == node.no) {
                head = head.next;
                return true;
            }
        }
        EmpNode cur = head;
        boolean loop = false;
        while (cur.next != null){
            if(cur.next.no == node.no) {
                loop = true;
                break;
            }
            cur = cur.next;
        }
        if(loop) {
            cur.next = cur.next.next;
            return true;
        }
        return false;
    }

    /**
     * 插入节点
     * 我们先判断一下第一个节点是否为空,若为空,则直接赋值结课
     * 我们需要判断一下特殊情况,就是插入的节点位于第一个节点之前(单向链表一般都是要找待插入节点的上一个节点,第一个节点没有上一个节点,所以要特殊化处理)
     * 如果满足上述node.no < head.no说明确实要插入第一个节点之前,所以第一步:node.next = head将新节点指向原来的第一个节点,第二步:head = node将node变成第一个节点,原来的第一个节点就会变成第二个节点
     * */
    public void insert(EmpNode node) {
        if(head == null) {
            head = node;
            return;
        }else {
            if(node.no < head.no) {
                node.next = head;
                head = node;
                return;
            }
        }
        boolean loop = false;
        EmpNode cur = head;
        while (cur.next != null) {
            if(cur.next.no > node.no) {
                loop = true;
                break;
            }
            cur = cur.next;
        }
        if(loop) {
            node.next = cur.next;
            cur.next = node;
        }
    }
}
