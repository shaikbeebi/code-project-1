package xyz;

import java.util.Stack;

public class StackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> bs=new Stack<>();
         bs.push("hello 1");
         bs.push("hello 2");
         bs.push("hello 3");
         System.out.println(bs);
         System.out.println(bs.peek());
         System.out.println(bs.pop());
         if(bs.isEmpty()) {
        	 System.out.println("completed");
         }else {
        	 System.out.println("not yet");
         }
	}

}