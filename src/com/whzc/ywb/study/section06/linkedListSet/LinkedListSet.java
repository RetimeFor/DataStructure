package com.whzc.ywb.study.section06.linkedListSet;
/**
 * 用链表实现set集合
 * @author ywb
 *
 * @param <E>
 */
public class LinkedListSet<E> implements Set<E>{
	private LinkedList<E> list;
	public LinkedListSet(){
		list = new LinkedList<>();
	}
	@Override
	public void add(E e) {
		if(!list.contains(e)){
			list.addFirst(e);
		}
	}

	@Override
	public boolean contains(E e) {
		return list.isEmpty();
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
	public void remove(E e) {
		list.deleteElement(e);
	}

}
