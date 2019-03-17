package com.whzc.ywb.study.section03.queue;


public class LinkedListQueue<E> implements Queue<E> {

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
	private Node head,tail;//头指针和尾指针
	private int size;
	
	
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void enqueue(E e) {
		if(tail == null){
			tail = new Node(e);
			head = tail;
		}else{
			tail.next = new Node(e);
			tail = tail.next;
		}
		size ++;
	}

	@Override
	public E dequeue() {
		if(isEmpty()){
			throw new IllegalArgumentException("不能从空队列中取值");
		}else{
			Node node = head;//node是需要移除的队首元素
			head = head.next;//将第二个元素设为队首
			node.next = null;//原来的队首元素指向空
			if(head == null){//如果需要移除的队列只有一个元素，移除后head 为null，tail也为null
				tail = null;
			}
			size --;
			return node.e;
		}
	}

	@Override
	public E getFront() {
		if(isEmpty()){
			throw new IllegalArgumentException("不能从空队列中取值");
		}else{
			return head.e;
		}
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = head;
		while(node != null){
			sb.append(node.e+"->");
			node = node.next;
		}
		sb.append("null");
		return sb.toString();
	}
	public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}
