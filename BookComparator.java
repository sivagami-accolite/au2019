package com.assignment.book;

import java.util.Comparator;
// implemented in order to implement tree collections
public class BookComparator implements Comparator<Book>{
	//uses price as the base to compare books
	@Override
	public int compare(Book o1, Book o2) {
		if(o1.getPrice()>o2.getPrice())
			return 1;
		else if(o1.getPrice()<o2.getPrice())
			return -1;
		else if(o1.getPrice()==o2.getPrice())
		{
			String s1=o1.getName();
			String s2=o2.getName();
			if(s1!=null && s2!=null)
				return s1.compareTo(s2);
		}
		return 0;
	}
}
