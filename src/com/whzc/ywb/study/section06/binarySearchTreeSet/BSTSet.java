package com.whzc.ywb.study.section06.binarySearchTreeSet;

import com.whzc.ywb.study.section05.binarySearchTree.BinarySearchTree;
/**
 * 用二分搜索树实现set集
 * @author ywb
 *
 * @param <E>
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
	private BinarySearchTree<E> bst;
	public BSTSet(){
		bst = new BinarySearchTree<>();
	}
	@Override
	public void add(E e) {
		bst.add(e);
	}
	@Override
	public boolean contains(E e) {
		return bst.contains(e);
	}
	@Override
	public void remove(E e) {
		bst.remove(e);
	}
	@Override
	public int getSize() {
		return bst.size();
	}
	@Override
	public boolean isEmpty() {
		return bst.isEmpty();
	}
	

}
