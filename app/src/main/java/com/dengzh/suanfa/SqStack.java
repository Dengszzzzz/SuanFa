package com.dengzh.suanfa;

/**
 * @author Dengzh
 * @date 2022/5/17
 * Description:
 */
public class SqStack implements IStack{

    //对象数组实现栈
    public Object[] stackElem;
    //指向下一存储位置 为0时表示为空
    public int top = 0;

    public SqStack(int maxSize) {
        this.stackElem = new Object[maxSize];;
    }

    @Override
    public void clear() {
        top = 0;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int length() {
        //top指向下一存储位置 即指向的是当前  下标+1 = 当前表长
        return top;
    }

    /**
     * 读取栈顶元素
     * */
    @Override
    public Object peek() {
        if (top!=0){
            return stackElem[top-1];
        }
        return null;
    }

    /**
     * 入栈
     * */
    @Override
    public void push(Object o) throws Exception {
        if (top == stackElem.length){
            throw new Exception("栈已满。");
        }else{
            stackElem[top] = o;
            top++;
        }
    }

    /**
     * 出栈
     * */
    @Override
    public Object pop() {
        if (isEmpty()){
            return null;
        }else{
            top--;
            return stackElem[top];
        }
    }
}
