package com.whzc.ywb.study.section03.queue;
/**
 * 队列的接口
 * @author ywb
 *
 * @param <E>
 */
public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}