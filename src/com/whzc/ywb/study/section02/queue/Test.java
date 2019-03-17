package com.whzc.ywb.study.section02.queue;

import java.util.Random;

import com.whzc.ywb.study.section03.queue.LinkedListQueue;
import com.whzc.ywb.study.section03.queue.Queue;
/**
 * 数组队列和循环队列的性能测试
 * @author ywb
 *
 */
public class Test {

	public static double QueueRuntime(Queue<Integer> queue , int count){
		long startTime = System.nanoTime();//(单位是纳秒)	或者用System.currentTimeMillis();(单位是毫秒)
		Random r = new Random();
		for(int i = 0 ; i < count ; i++){
			queue.enqueue(r.nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0 ; i < count ; i++){
			queue.dequeue();
		}
		
		long endTime = System.nanoTime();
		return endTime-startTime;
		
	}
	
	public static void main(String[] args) {
		int count = 100000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		double queueRuntime1 = QueueRuntime(arrayQueue,count);
		System.out.println(queueRuntime1/1000000000.0);//效率低
		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		double queueRuntime2 = QueueRuntime(loopQueue,count);
		System.out.println(queueRuntime2/1000000000.0);//效率高
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		double queueRuntime3 = QueueRuntime(linkedListQueue,count);
		System.out.println(queueRuntime3/1000000000.0);//效率高
	}
}
