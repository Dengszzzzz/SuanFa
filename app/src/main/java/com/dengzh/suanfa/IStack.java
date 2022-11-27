package com.dengzh.suanfa;

/**
 * @author Dengzh
 * @date 2022/5/17
 * Description:
 */
interface IStack {
    //置空
    public void clear();
    //判空
    public boolean isEmpty();
    //返回栈中元素个数
    public int length();
    //读取栈顶元素
    public Object peek();
    //入栈
    public void push(Object o) throws Exception;
    //返回栈顶元素 出栈
    public Object pop();
}
