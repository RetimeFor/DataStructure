package com.whzc.ywb.study.section01.array;

import com.whzc.ywb.study.section01.utils.ArrayUtil;
/**
 * 测试数组工具
 * 泛型数组的创建
 * @author ywb
 *
 */
public class MyArray {
	
	
	public static void main(String[] args) {
		ArrayUtil arrayutil = new ArrayUtil();
		arrayutil.add(123);
		arrayutil.add(456);
		arrayutil.add(789);
		int size1 = arrayutil.size();
		System.out.println("元素个数为:"+size1);
		
		
		arrayutil.delete(1);
		int size2 = arrayutil.size();
		System.out.println("元素个数为:"+size2);
	}
	
}
class EnumArray<E>{//泛型数组
	public E[] array;
	public void test(){
		E[] arr = (E[]) new Object[10];
	}
}