package xyz;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample1 {

	public static void main(String[] args) {
       Queue<String> qs=new LinkedList<String>();
       qs.add("stud1");
       qs.add("stud2");
       qs.add("stud3");
       qs.add("stud4");
       qs.add("stud5");
       System.out.println(qs);
       System.out.println(qs.poll());
       System.out.println(qs);
       System.out.println(qs.remove());
       System.out.println(qs);
       System.out.println(qs.size());
	}

}