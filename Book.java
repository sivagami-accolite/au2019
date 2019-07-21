package com.assignment.book;
//basic book class to create objects and modify
public class Book implements Comparable<Book>{

	String name;
	int price;
	String authorName;
	public Book(String name, int price, String authorName) {
		super();
		this.name = name;
		this.price = price;
		this.authorName = authorName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString()
	{
		return name+"->"+price+"->"+authorName;
	}
	@Override
	public int compareTo(Book b)
	{
		if(this.getPrice()>b.getPrice())
			return 1;
		else if(this.getPrice()<b.getPrice())
			return -1;
		return 0;
			
	}
	public void decreaseCost() {
		int dec=20*price/100;
		price=price-dec;
	}
}
