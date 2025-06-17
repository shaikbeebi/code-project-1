package xyz;

import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityHeapExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<Integer> minHeap=new PriorityQueue<>();
		minHeap.add(20);
		minHeap.add(100);
		minHeap.add(10);
		minHeap.add(30);
		minHeap.add(60);
		minHeap.add(50);
		System.out.println("min heap");
          while(!minHeap.isEmpty()) {
        	  System.out.println(minHeap.poll());
          }
          
          PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
  		maxHeap.add(20);
  		maxHeap.add(100);
  		maxHeap.add(10);
  		maxHeap.add(30);
  		maxHeap.add(60);
  		maxHeap.add(50); 
  		System.out.println("max heap");
        while(!maxHeap.isEmpty()) {
      	  System.out.println(maxHeap.poll());
        }
  		
	}

}