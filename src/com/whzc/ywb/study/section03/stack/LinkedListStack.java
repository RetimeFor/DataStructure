package com.whzc.ywb.study.section03.stack;

import com.whzc.ywb.study.section03.linkedList.LinkedList;
/**
 * 底层使用链表实现栈	(对比数组实现的栈)
 * 		数组实现的栈: 需要扩容，需要拷贝数组，栈帧数量一定时，效率比链表实现的栈低
 * 		链表实现的栈: 不需要扩容，但需要不断new结点，当超过一定数量的栈帧，效率会比数组实现的栈低
 * @author ywb
 *
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E>{

	private LinkedList<E> list;
	public LinkedListStack(){
		list = new LinkedList<>();
	}
	@Override
	public int getSize() {
		return list.getSize();
	}
	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}
	@Override
	public void push(E e) {
		list.addFirst(e);
	}
	@Override
	public void pop() {
		list.deleteFirst();
	}
	@Override
	public E peek() {
		return list.getFirst();
	}
	@Override
	public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }
	 public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
