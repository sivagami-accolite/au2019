package com.assignment.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.accolite.au.Employee;


public class BookList {

	public static void main(String[] args) {
			Book b1=new Book("Harry Potter",200,"Sivagami");
			Book b2=new Book("Percy jackson",300,"dharshana");
			Book b3=new Book("Far away tree",450,"mudita");
			Book b4=new Book("Alice",55,"sham");
			Book b5=new Book("Famous five",120,"divya");
			Book b6=new Book("Secret seven",400,"ram");
			Book b7=new Book("Batman",800,"mouli");
			Book b8=new Book("Fantastic beast",550,"pavitra");
			Book b9=new Book("Deception point",290,"shalu");
		List<Book> bl=new ArrayList<>();
		bl.add(b1);
		bl.add(b2);
		bl.add(b3);
		bl.add(b4);
		bl.add(b5);
		bl.add(b6);
		bl.add(b7);
		bl.add(b8);
		bl.add(b9);
		System.out.println("List of Books,");
		for(Book b:bl)
			System.out.println(b);
		//sorting based on price using comparable
		Collections.sort(bl);
		System.out.println("Sorted List-Based on Price,using comparable");
		for(Book b:bl)
			System.out.println(b);
		//sorting based on price using comparator
		bl.sort(new BookComparator());
		System.out.println("Sorted List-Based on Price and name,using comparable");
		//prints all the books
		for(Book b:bl)
			System.out.println(b);
		Iterator iter = bl.iterator();
		while (iter.hasNext()) {
			Book cur = (Book) iter.next();
			cur.decreaseCost();
		}
		System.out.println("Books after discount of 20%,");
		for(Book b:bl)
			System.out.println(b);
		
	}

}
