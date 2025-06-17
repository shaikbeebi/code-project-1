package xyz;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExampleTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Queue<String> icecream=new LinkedList<>();
       icecream.add("child 1");
       icecream.add("child 2");
       icecream.add("child 3");
       icecream.add("child 4");
       icecream.add("child 5");
       System.out.println(icecream);
       icecream.add("child 6");
       for(int i=0;i<=icecream.size()+1;i++) {
    	   System.out.println(icecream.poll());
    	   System.out.println(icecream);
       }
	}

}