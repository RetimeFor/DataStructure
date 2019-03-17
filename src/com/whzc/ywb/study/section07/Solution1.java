package com.whzc.ywb.study.section07;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class Solution1 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num , map.get(num) + 1);
            }else{
                map.put(num , 1);
            }
        }
        System.out.println(map);
        LinkedList<Integer> list = new LinkedList<>();
        Iterator it = map.keySet().iterator();  
        while (it.hasNext()) {  
            //it.next()得到的是key，map.get(key)得到value
            list.add(map.get(it.next()));
        }
        LinkedList<Integer> list2 = new LinkedList<>();
        Collections.sort(list);//从小到大排序
        for(int i = 0 ; i < k ; i ++){
        	list2.add(list.get(list.size() - i-1));//从大到小取元素
        }
        LinkedList<Integer> list3 = new LinkedList<>();
        list3.add(-1);
        for(int i = 0 ; i < list2.size() ; i ++){
        	for(int num : nums){
                if(map.get(num) == list2.get(i) && !list3.contains(num)){
                	list2.set(i, num);
                	list3.add(num);
                	break;
                }
            }
        }
		return list2;
    }
    public static void main(String[] args) {
    	Solution1 s = new Solution1();
    	int[] arr = {1,2,3,4,3,1,1,2,2,2,1,4,3,2};
    	List<Integer> topKFrequent = s.topKFrequent(arr, 2);
    	System.out.println(topKFrequent.toString());
	}
}