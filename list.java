package xyz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class list1{
	 list1() {
		ArrayList<String> al= new ArrayList<String>();
		al.add("hello");
		al.add("hi");
		al.add("how");
		System.out.println(al);
	}
}
 class list2 extends list1{
	 list2() {
		LinkedList<String> al= new LinkedList<String>();
		al.add("harshi");
		al.add("mahi");
		al.add("hmm");
		System.out.println(al);
	}
}
 class list3 extends list2{
	 list3() {
		HashSet<String> al= new HashSet<String>();
		al.add("harshi");
		al.add("harshi");
		al.add("mahi");
		al.add("hmm");
		System.out.println(al);
	}
}
 class list4 extends list3{
	 list4() {
		HashMap<Integer,String> al= new HashMap<>();
		al.put(1,"harshi");
		al.put(1,"harshi");
		al.put(3,"mahi");
		al.put(4,"hmm");
		System.out.println(al);
	}
}
public class SimpleFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list4 lh=new list4();

	}

}