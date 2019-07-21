package com.assignment.book;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.accolite.au.Employee;

public class BookHashMap {

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
			List<Book> l=new ArrayList<>();
			l.add(b1);
			l.add(b2);
			l.add(b3);
			l.add(b4);
			l.add(b5);
			l.add(b6);
			l.add(b7);
			l.add(b8);
			l.add(b9);
			HashMap<String,Integer> h=new HashMap<>();
			for(Book b:l)
			{
				String s=b.getAuthorName();
				//replaces the value if key already exists
				if(h.containsKey(s))
					h.put(s, h.get(s) + 1);
				//adds data in hash map if key doesnt exist	
				else
					h.put(s, 1);	
			}
			//HashMap having Author Name and No of Books written greater than 2
			System.out.println("Authors who have written more than 2 books:");
			for (Map.Entry<String,Integer> entry : h.entrySet()) {
				if(entry.getValue()>2)
					System.out.println(entry.getKey());
			}
		

	}

}
