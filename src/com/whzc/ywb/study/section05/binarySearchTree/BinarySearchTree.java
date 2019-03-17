package com.whzc.ywb.study.section05.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTree<E extends Comparable<E>> {//结点之间必须具有可比较性

	private class Node{
		public E e;
		public Node left,right;
		public Node(E e){
			this.e = e;
			this.left = null;
			this.right = null;
		}
	}
	
	private Node root;
	private int size;
	public BinarySearchTree(){
		root = null;
		size = 0;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	/*public void add(E e){
		if(root == null){
			root = new Node(e);
		}else{
			add(root , e);
		}
	}
	public void add(Node node , E e){
		if(e.equals(node.e)){
			return;//如果插入的元素和跟节点相等
		}
		else if(e.compareTo(node.e) < 0 && node.left == null){	//e是泛型，不直接使用大于或者小于号比较大小
			node.left = new Node(e);
			size++ ;
			return;
		}
		else if(e.compareTo(node.e) > 0 && node.right == null){
			node.right = new Node(e);
			size++ ;
			return;
		}
		if(e.compareTo(node.e) < 0){//递归调用
			add(node.left , e);
		}
		if(e.compareTo(node.e) > 0){
			add(node.right , e);
		}

	
	}*/
	//对上面的add方法优化
	public void add(E e){
		root = add(root , e);
	}
	public Node add(Node node , E e){
		if(node == null){
			size ++;
			return new Node(e);
		}
		if(e.compareTo(node.e) < 0){
			node.left = add(node.left , e);
		}else if(e.compareTo(node.e) > 0){
			node.right = add(node.right , e);
		}
		return node;
	}
	public boolean contains(E e){
		return contains(root , e);
	}
	private boolean contains(Node node, E e) {
		if(node == null){
			return false;
		}
		if(e.compareTo(node.e) == 0){
			return true;
		}
		else if(e.compareTo(node.e) < 0){
			return contains(node.left , e);
		}else{
			return contains(node.right , e);
		}
	}
	private void iteratorTree(){//遍历二分搜索树
		iteratorTree(root);
	}
	private void iteratorTree(Node node){
		if(node == null){
			return;
		}else{
			System.out.print(node.e + "--");//方案一: 从根节点开始遍历
			iteratorTree(node.left);
			//System.out.print(node.e + "--");//方案二: 从左孩子开始遍历(注意:发现是按从小到大的顺序打印的)
			iteratorTree(node.right);
			//System.out.print(node.e + "--");//方案三：先遍历子节点，再遍历父节点
		}
	}
	private void ergodicTree(){//非递归实现遍历方式
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()){
			Node node = stack.pop();
			System.out.print(node.e + "--");
			if(node.right != null){
				stack.push(node.right);
			}
			if(node.left != null){
				stack.push(node.left);
			}
		}
	}
	public void levelErgodicTree(){//广度优先遍历(用来求最短路径？)
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node = queue.remove();
			System.out.println(node.e);
			if(node.left != null){
				queue.add(node.left);
			}
			if(node.right != null){
				queue.add(node.right);
			}
		}
		
	}
	
	// 寻找二分搜索树的最小元素
    public E minimum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node){
        if( node.left == null )
            return node;

        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum(){
        if(size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node){
        if( node.right == null )
            return node;

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin(){
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax(){
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node){

        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }
    
    // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }
    private Node remove(Node node, E e){

        if( node == null )
            return null;

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		int[] arr = {4,3,5,0,8,6,1,7,9,2};
		for(int i : arr){
			bst.add(i);
		}
		bst.iteratorTree();
		System.out.println("");
		bst.ergodicTree();
		System.out.println("");
		bst.removeMin();
		bst.removeMax();
		bst.remove(4);
		bst.iteratorTree();
	}
}
