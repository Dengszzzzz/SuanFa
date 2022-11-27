package com.dengzh.suanfa;

import java.util.Arrays;

/**
 * @author Dengzh
 * @date 2022/5/17
 * Description:
 */
class MyStack<T> {

    private Object[] stack;
    private int top;

    public MyStack(){
        stack = new Object[10]; //初始容量为10
    }


    public boolean isEmpty() {
        return top == 0;
    }

    /**
     * 返回栈顶元素
     * */
    public T peek() {
        T t = null;
        if (top>0){
            t = (T) stack[top - 1];
        }
        return t;
    }

    public void push(T o) throws Exception {
        expandCapacity(top + 1);
        stack[top] = o;
        top++;
    }

    /**
     * 出栈，返回t，且从栈中移除
     * */
    public T pop() {
        T t = null;
        if (top > 0){
            t = (T) stack[top - 1];
            stack[top - 1] = null;
            top--;
        }
        return t;
    }

    /**
     * 扩容
     * */
    private void expandCapacity(int size){
        int len = stack.length;
        if (size>len){
            size = size * 3/2 + 1; //每次扩容50%
            stack = Arrays.copyOf(stack,size);
        }
    }
}
