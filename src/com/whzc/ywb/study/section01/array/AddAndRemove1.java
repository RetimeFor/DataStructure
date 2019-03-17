package com.whzc.ywb.study.section01.array;

import java.util.Arrays;
/**
 * 数组的添加和删除操作
 * @author ywb
 *
 */
public class AddAndRemove1 {
	public static void main(String[] args) {
		arrAdd(2,10);
		arrRemove1(2);
		arrRemove3(6);
	}
	//在数组指定位置添加元素
	public static void arrAdd(int index,int num){
		int[] arr = {1,2,3,4,5};
		int[] arr1 = new int[arr.length+1];
		for(int i=0 ; i<arr1.length;i++){
			if(i<index){
				arr1[i]=arr[i];
			}else if(i==index){
				arr1[i]=num;
			}else{
				arr1[i]=arr[i-1];//注意	不要使用arr1[i+1]=arr[i];否则会出现索引越界异常
			}
		}
		System.out.println(Arrays.toString(arr1));
	}
	public static void arrRemove1(int index){//根据索引删除元素
		int[] arr = {1,2,3,4,5};
		int[] arr1 = new int[arr.length-1];
		for(int i=0;i<arr1.length;i++){
			if(i<index){
				arr1[i]=arr[i];
			}else if(i>=index){
				arr1[i]=arr[i+1];
			}
		}
		System.out.println(Arrays.toString(arr1));
	}
	
	public static void arrRemove3(int number){
		int a[]={1,4,6,9,13,16,19,28,6,100};
		  int i,j;
		  System.out.println("删除前:");
		  for(i=0;i<10;i++){
		   System.out.print(a[i] + "\t");
		  }
		  System.out.println("\n");
		  for (i=0;i<10;i++){
		    if (a[i]==number){
		     break;
		    }
		  }
		  if(i<10){
		   if(i <=8 ){
		     for(j=i;j<9;j++){
		      a[j]=a[j+1];
		     }
		   }
		   System.out.println("\n删除后:");
		   for(i=0;i<9;i++){
		    System.out.print(a[i] + "\t");
		   }
		   System.out.println("\n");
		  }else{
		   System.out.println("\n要删除的元素不存在!");
		  }
	}
}
