package com.whzc.ywb.study.section01.utils;
import java.util.Arrays;
/**
 * 数组工具类
 * @author ywb
 *
 */
public class ArrayUtil {
	
	private int[] elements;
	
	public ArrayUtil(){
		elements = new int[0];
	}
	
	public int  size(){
		return elements.length;
	}
	public void add(int element){//添加元素
		int[] newArr = new int[elements.length+1];
		for(int i=0;i<elements.length;i++){
			newArr[i]=elements[i];
		}
		newArr[elements.length]=element;
		elements=newArr;
	}
	public void delete(int index){//根据索引删除元素
		if(index<0){
			throw new RuntimeException("索引不能小于0");
		}
		if(elements.length>0){
			int[] newArr = new int[elements.length-1];
			for(int i=0;i<newArr.length;i++){
				if(i<index){
					newArr[i]=elements[i];
				}else if(i>=index){
					newArr[i]=elements[i+1];
				}
			}
			elements=newArr;
			System.out.println("删除元素后"+"\t"+Arrays.toString(newArr));
		}
		else{
			System.out.println("数组长度不能为0");
		}
	}
}
