package com.whzc.ywb.study.section04.recursion;
/**
 * 递归求和
 * @author ywb
 *
 */
public class RecursionArray {

	public static int sum(int[] arr){
		return sum(arr , 0);
	}
	public static int sum(int[] arr , int i){
		return i==arr.length?0:arr[i] + sum(arr , i+1);
	}
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5};
		System.out.println(sum(array));
	}
}
