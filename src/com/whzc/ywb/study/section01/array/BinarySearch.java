package com.whzc.ywb.study.section01.array;

import java.util.Arrays;

/**
 * 使用二分法查找某个值
 * @author ywb
 *
 */
public class BinarySearch {
	private int[] arr = {14,5,33,7,6,12,4,2,16,10,22,23,24,28,36,44,3,9,13,11,18,17,19,27,45,1};
	private int begin = 0;
	private int end = arr.length;
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		Arrays.sort(bs.arr);
		System.out.println(Arrays.toString(bs.arr));
		System.out.println(bs.binarySearchArr(22));
		
	}
	
	
	public int binarySearchArr(int target){//二分查找排序后元素的位置
		int x = (begin + end)/2;
		while(arr[x] != target){
			if(arr[x] > target ){
				end = x;
			}else{
				begin = x;
			}
			x = (begin + end)/2;
		}
		return x;
	}
}
