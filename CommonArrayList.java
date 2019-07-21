package com.accolite.au;

import java.util.ArrayList;
import java.util.List;

public class CommonArrayList {

	public static void main(String[] args) {
		List<String> l1=new ArrayList<>();
		List<String> l2=new ArrayList<>();
		l1.add("Hello");
		l1.add("This");
		l1.add("Is");
		l1.add("Java");
		l2.add("Hello");
		l2.add("Java");
		l2.add("Folks");
		//method1
		List<String> res1=new ArrayList<>();
		for(String s1:l1)
		{
			if(l2.contains(s1))
			{
				res1.add(s1);
			}
		}
		//method2
		List<String> res2=new ArrayList<>(l1);
		res2.retainAll(l2);
		System.out.println("List having common elements");
		System.out.println(res1);
		System.out.println(res2);
	}

}
