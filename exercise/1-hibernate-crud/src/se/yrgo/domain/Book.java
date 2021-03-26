package se.yrgo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String isbn;
	private String title;
	private String author;
	
	public Book() {}
	
	public Book(String isbn, String title, String author) {
		this.isbn= isbn;
		this.title = title;
		this.author= author;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getAuthor() {
		return author;
	}

	public String getTitle() {
		return title;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String toString() {
		return  " isbn: " + isbn  + " , title: "+  title  + " , author: "+ author;
	}

}
