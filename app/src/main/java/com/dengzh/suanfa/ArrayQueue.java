package com.dengzh.suanfa;

/**
 * @author Dengzh
 * @date 2022/5/17
 * Description:
 */
public class ArrayQueue {

    private int maxSize;//最大容量、
    private int arr[]; //声明数组
    private int front = -1;//队头元素
    private int rear = -1;//队尾

    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满，无法插入");
            return;
        }
        rear++;//让rear往后挪动一位
        arr[rear] = n;
    }

    public int exitQueue() {
        if (isEmpty()) {
            throw new RuntimeException("当前队列为空");
        }
        front++;
        return arr[front];
    }

    //显示队列头部数据
    public int headQueue() {
        //判断队列是否为空
        if(isEmpty()) {
            throw new RuntimeException("当前队列为空");
        }
        return arr[front+1];
    }
}




