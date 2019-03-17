package com.whzc.ywb.study.section06.linkedListMap;
/**
 * 自己实现链表
 * @author ywb
 *
 * @param <E>
 */
public class LinkedList<E> {

	private class Node{
		public E e;//元素
		public Node next;//指针
		public Node(E e,Node next) {//传入元素和指针
			this.e = e;
			this.next = next;
		}
		public Node(){//不传入元素和指针
			this(null,null);//this是传入两个参数的构造器
		}
		public Node(E e){
			this(e,null);
		}
		
		@Override
		public String toString() {
			return "Node [e=" + e + "]";
		}
	}
	
	private Node dummyHead;
	private int size;
	public LinkedList(){
		dummyHead = new Node(null,null);
		size = 0;
	}
	public int getSize(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public void addFirst(E e){//在链表头添加元素
		/*Node node = new Node(e);
		node.next = head;
		head = node;*/	//用下面一行代码代替
		//head = new Node(e,head);//括号内的head是之前的链表的头结点，左边的head是现在的头结点
		add(0,e);
	}
	public void addLast(E e){//在链表的尾部添加元素
		add(size,e);
	}
	public void add(int index,E e){//在链表中间添加元素
		if(index < 0 || index > size){
			throw new IllegalArgumentException("索引越界异常");
		}
		Node prev = dummyHead;//定义一个指针指向头结点
		for(int i = 0 ; i < index ; i++){
			prev = prev.next;//将这个指针移动到要插入的位置的前一个元素
		}
		/*Node node = new Node(e);
		node.next = prev.next;
		prev.next = node;*/	//注意这两行代码的顺序。用下面一行代码实现
		prev.next = new Node(e,prev.next);
		size ++;
	}
	public E get(int index){
		if(index < 0 || index > size){
			throw new IllegalArgumentException("索引越界异常");
		}
		Node cur = dummyHead.next;
		for(int i = 0 ; i < index ; i++){
			cur = cur.next;
		}
		return cur.e;
	}
	public E getFirst(){
		return get(0);
	}
	public E getLast(){
		return get(size-1);
	}
	public void update(int index,E e){//修改某个元素
		if(index < 0 || index > size){
			throw new IllegalArgumentException("索引越界异常");
		}
		Node cur = dummyHead.next;
		for(int i = 0 ; i < index ; i++){
			cur = cur.next;
		}
		cur.e = e;
	}
	public boolean contains(E e){//查询链表中是否存在某个元素
		Node node = dummyHead.next;
		while (node != null){
			if(node.e.equals(e)){
				return true;
			}
			node = node.next;
		}
		return false;
	}
	public void remove(int index){//删除元素
		if(index < 0 || index > size){
			throw new IllegalArgumentException("索引越界异常");
		}
		Node prev = dummyHead;
		for(int i = 0 ; i < index ; i++){
			prev = prev.next;
		}
		/*prev.next = prev.next.next;//注意！！！ 这是错误的
		prev.next.next = null;*/
		Node cur = prev.next;
		prev.next = cur.next;
		cur.next = null;
		size--;
	}
	public void deleteFirst(){
		remove(0);
	}
	public void deleteLast(){
		remove(size-1);
	}
	public void removeElement(E e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.e.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = dummyHead.next;
		while(node != null){
			sb.append(node.e+"->");
			node = node.next;
		}
		sb.append("null");
		return sb.toString();
	}
	public static void main(String[] args) {
		LinkedList<Integer> linkedList = new LinkedList<>();
		for(int i = 0 ; i < 5 ; i++){
			linkedList.addFirst(i);
			System.out.println(linkedList);
		}
		linkedList.add(2, 888);
		System.out.println(linkedList);
		linkedList.update(3,666);
		System.out.println(linkedList);
		linkedList.remove(0);
		System.out.println(linkedList);
		linkedList.deleteFirst();
		linkedList.deleteLast();
		linkedList.removeElement(666);
		System.out.println(linkedList);
		System.out.println("最终数组的长度为" + linkedList.size);
	}
}
