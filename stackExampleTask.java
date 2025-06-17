package xyz;

import java.util.Stack;

public class StackExampleTask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Stack<String> example=new Stack<>();
      example.push("write");
      example.push("delete");
      example.push("insert");
      System.out.println(example.peek());
      System.out.println(example.pop());
      System.out.println(example.pop());
      System.out.println(example);
	}

}