package com.dengzh.suanfa;

/**
 * @author Dengzh
 * @date 2022/5/17
 * Description:循环队列
 */
class CircleQueueArray {

    private int maxSize;//最大容量、
    private int arr[]; //声明数组
    private int front = 0;//队头元素
    private int rear = 0;//队尾

    public CircleQueueArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法插入");
            return;
        }
        //将数据直接插入到数组，用队尾rear来进行位置的确定
        arr[rear] = n;
        //将 rear 后移, 这里必须考虑取
        rear = (rear + 1) % maxSize;
    }

    public int exitQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无元素");
            return -1;
        }
        // 这里需要分析出 front 是指向队列的第一个元素,因为这里是循环的，所以我们考虑用一个临时变量来获取当前的队头
        // 1. 先把 front 对应的值保留到一个临时变量
        // 2. 将 front 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = front;
        front = (front + 1) % maxSize;
        return arr[value];
    }
}
