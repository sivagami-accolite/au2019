package com.accolite.au;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesList {

	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("tables");
		list.add("chairs");
		list.add("sofa");
		list.add("tables");
		list.add("fans");
		list.add("lights");
		list.add("beds");
		list.add("mattress");
		list.add("beds");
		List<String> newList = new ArrayList<String>();
		for (String s : new ArrayList<>(list)) {
		        list.remove(s);
		        if(list.contains(s) && !newList.contains(s))
					newList.add(s);
		}
		newList.sort(null);
		System.out.println("List having duplicates in alphabetical order is,");
		for(String s: newList)
			System.out.print(s+",");
	}

}
