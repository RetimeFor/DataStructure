package com.whzc.ywb.study.section02.stack;
/**
 * 自己实现栈(接口)
 * @author ywb
 *
 * @param <E>
 */
public interface Stack<E> {

	int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
